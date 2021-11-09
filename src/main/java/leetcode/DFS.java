package leetcode;

import java.util.*;

/**
 * @Description: 构建图
 * @Date: Created in 16:42 2021/10/12
 * @Author: caopeng
 */
public class DFS {

    public static void main(String[] args) {
        GraphInstance<Integer> graph = new GraphInstance<>();
        Vertex v0 = graph.createVertex(0);
        Vertex v1 = graph.createVertex(1);
        Vertex v2 = graph.createVertex(2);
        Vertex v3 = graph.createVertex(3);
        Vertex v4 = graph.createVertex(4);
        Vertex v5 = graph.createVertex(5);
        Vertex v6 = graph.createVertex(6);
//
        graph.addDirectedEdge(v0, v2, "1");
        graph.addDirectedEdge(v0, v1, "1");
        graph.addDirectedEdge(v1, v2, "1");
        graph.addDirectedEdge(v2, v3, "1");
        graph.addDirectedEdge(v3, v4, "1");
        graph.addDirectedEdge(v3, v5, "1");
        graph.addDirectedEdge(v5, v6, "1");
//
//        graph.printGraph();


        graph.DFS(0);
//        MutableGraph<Object> graph1 = GraphBuilder.directed().build();
//        graph1.putEdge(v0, v1);
//        graph1.putEdge(v0, v2);
//        graph1.putEdge(v1, v2);
//        graph1.putEdge(v2, v3);
//        graph1.putEdge(v3, v4);
//        graph1.putEdge(v3, v5);
//        graph1.putEdge(v5, v6);
//
//        // Google DFS
//        Iterable<Object> objects = Traverser.forGraph(graph1).depthFirstPreOrder(v3);
//        for (Object node : objects) {
//            System.out.println(node.toString());
//        }


    }

}

/**
 * 构建图
 */
class GraphInstance<T> {

    // 维护邻接列表
    List<EdgeList> edgeLists = new ArrayList<>();

    /**
     * 创建顶点
     */
    public Vertex createVertex(T vertex) {
        Optional<EdgeList> first = edgeLists.stream().filter(item -> item.vertex.curNode.equals(vertex)).findFirst();
        if (first.isPresent()) {
            return first.get().vertex;
        }
        EdgeList edgeList = new EdgeList(new Vertex<>(vertex));
        edgeLists.add(edgeList);
        return edgeList.vertex;
    }

    /**
     * 添加一条有向边
     */
    public void addDirectedEdge(Vertex from, Vertex to, String weight) {
        Edge edge = new Edge(from, to, weight);
        Optional<EdgeList> first = edgeLists.stream().filter(item -> item.vertex.equals(from)).findFirst();
        if (first.isPresent()) {
            first.get().edges.add(edge);
            return;
        }
        System.out.println("===无此" + from + "开始节点，添加失败===");
        return;
    }

    /**
     * 打印图
     */
    public void printGraph() {
        edgeLists.forEach(System.out::println);
    }

    /**
     * dfs
     */
    public void DFS(T vertx) {
        EdgeList begin = new EdgeList(new Vertex("default"));
        for (EdgeList edgeList : edgeLists) {
            if (edgeList.vertex.curNode.equals(vertx)) {
                begin = edgeList;
                break;
            }
        }
        Deque<EdgeList> stack = new ArrayDeque<>();
        Set<Vertex> visit = new HashSet<>();
        stack.push(begin);
        while (true) {
            if (stack.isEmpty()) {
                return;
            }
            EdgeList headNode = stack.getFirst();
            // 首次访问节点
            boolean firstVisit = visit.add(headNode.vertex);
            boolean lastVisit = !headNode.iterator().hasNext();
            if (lastVisit) {
                stack.pop();
            } else {
                Vertex next = (Vertex) headNode.iterator().next();
                if (!visit.contains(next)) {
                    for (EdgeList edgeList : edgeLists) {
                        if (edgeList.vertex.equals(next)) {
                            stack.push(edgeList);
                            break;
                        }
                    }
                }
            }
            if (firstVisit) {
                System.out.println(headNode.vertex);
            }
        }
    }
}

/**
 * 邻接列表
 */
class EdgeList implements Iterable{

    Vertex vertex;

    Vertex next;

    List<Edge> edges = new ArrayList();

    EdgeList(Vertex vertex) {
        this.vertex = vertex;
    }

    public void addEdge(Edge edge){
        edges.add(edge);
    }

    @Override
    public String toString() {
        return "EdgeList{" +
                "vertex=" + vertex +
                ", edges=" + edges +
                '}';
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            @Override
            public boolean hasNext() {
                List<Edge> temps = edges;
                for (Edge edge : temps) {
                    next = edge.to;
                    temps.remove(edge);
                    return true;
                }
                return false;
            }

            @Override
            public Vertex next() {
                return next;
            }
        };
    }
}

/**
 * 顶点
 */
class Vertex<T> {

    T curNode;

    /**
     * 标识是否被访问过
     */
    boolean visited = false;

    List<Edge> edges = new ArrayList<>();

    Vertex(T vtex) {
        curNode = vtex;
    }

    // 省略不用
    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "vertex='" + curNode + '\'' +
                '}';
    }

}

/**
 * 边
 */
class Edge {

    Vertex from;

    Vertex to;

    String weight;

    Edge(Vertex from, Vertex to, String weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "from=" + from +
                ", to=" + to +
                ", weight='" + weight + '\'' +
                '}';
    }
}
