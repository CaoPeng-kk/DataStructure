package jan.secondweek.tree.bsttree;

/**
 * @Description: 二叉排序树BST
 * @Date: Created in 15:49 2021/5/13
 * @Author: caopeng
 */
public class BSTTree {

    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9};
        BinarySortTree binarySortTree = new BinarySortTree();
        // 将数组构造为二叉排序树
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }
//        binarySortTree.add(new Node(arr[0]));
//        binarySortTree.add(new Node(arr[1]));
        binarySortTree.infixOrder();
        System.out.println();
        // 测试查找节点
        System.out.println(binarySortTree.searchNode(5));
        // 测试查找要删除节点的父节点
        System.out.println();
        System.out.println(binarySortTree.searchParentNode(1));

    }
}

/**
 * 二叉查找树
 */
class BinarySortTree {

    private Node root;

    /**
     * 二叉查找树添加方法
     */
    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.addNode(node);
        }
    }

    /**
     * 二叉查找树中序遍历
     */
    public void infixOrder() {
        if (root == null) {
            System.out.println("二叉排序树为空, 无法遍历");
        }
        root.infixOrder();
    }

    /**
     * 查找要删除的节点
     */
    public Node searchNode(int value) {
        return root.searchDeleteNode(value);
    }

    /**
     * 查找要删除节点的父节点
     */
    public Node searchParentNode(int value) {
        return root.searchDeleteNodeParent(value);
    }
}

/**
 * Node节点
 */
class Node {

    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
    }

    /**
     * @Description: 添加节点方法
     * @param
     * @Return: void
     * @Author: caopeng
     * @Date: 2021/5/13 17:07
     */
    public void addNode(Node node) {
        // 如果待添加的节点为空 直接返回
        if (node == null) {
            return;
        }
        /**
         * 比较本节点与待添加节点的值 如果待添加节点小于本节点的左子节点
         * 目前没有考虑等于的情况
         */
        if (node.value < this.value) {
            if (this.left != null) {
                this.left.addNode(node);
            } else {
                this.left = node;
            }
        } else {
            // 待添加节点的值大于本节点
            if (this.right != null) {
                this.right.addNode(node);
            } else {
                this.right = node;
            }
        }
    }

    /**
     * @Description: 查找要删除的节点
     * @param
     * @Return: jan.secondweek.tree.bsttree.Node
     * @Author: caopeng
     * @Date: 2021/5/17 22:07
     */
    public Node searchDeleteNode(int value) {
        // 将参数值与本节点值比较
        if (value == this.value) {
            return this;
        }
        if (value < this.value) {
            if (this.left != null) {
                return this.left.searchDeleteNode(value);
            }
        } else {
            if (this.right != null) {
                return this.right.searchDeleteNode(value);
            }
        }
        return null;
    }

    /**
     * 查找要删除节点的父节点
     *          7
     *        /  \
     *       3    10
     *      / \   /  \
     *    1   5  9    12
     */
    public Node searchDeleteNodeParent(int value) {
        if (this.left != null && this.left.value == value || this.right != null && this.right.value == value) {
            return this;
        } else if (value == this.value) {
            return null;
        } else if (value < this.value) {
            if (this.left != null) {
                return this.left.searchDeleteNodeParent(value);
            }
        } else {
            if (this.right != null) {
                return this.right.searchDeleteNodeParent(value);
            }
        }
        return null;
    }

    /**
     * 中序遍历方法
     */
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
