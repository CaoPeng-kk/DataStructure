package leetcode.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 课程表
 * @Date: Created in 21:15 2023/11/19/0019
 * @Author: caopeng
 */
public class Courses_207 {

    private static boolean[] onPath;

    private static boolean[] visited;

    private static boolean hasCycle = false;

    public static void main(String[] args) {
        boolean canFinish = canFinish(2, new int[][]{{0, 1}});
        System.out.println(canFinish);
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }
        onPath = new boolean[numCourses];
        visited = new boolean[numCourses];

        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }
        // 是否成环
        return !hasCycle;
    }

    private static List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        // 课程大小的数组
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] course : prerequisites) {
            int from = course[1];
            int to = course[0];

            graph[from].add(to);
        }
        return graph;
    }

    private static void traverse(List<Integer>[] graph, int index) {
        // 前序位置
        // 先检测是否成环
        if (onPath[index]) {
            hasCycle = true;
        }
        // 节点访问过 或成环 return
        if (visited[index] || hasCycle) {
            return;
        }
        onPath[index] = true;
        visited[index] = true;
        for (Integer to : graph[index]) {
            traverse(graph, to);
        }
        // 后序位置 此节点访问过
        onPath[index] = false;
    }
}
