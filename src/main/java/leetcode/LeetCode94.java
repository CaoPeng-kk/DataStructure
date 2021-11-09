package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Description: leetCode 94 深度优先搜索中序遍历二叉树
 * @Date: Created in 10:32 2021/11/5
 * @Author: caopeng
 */
public class LeetCode94 {

    /**
     *
     */

    public static void main(String[] args) throws InterruptedException {
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        root.left = two;
        root.right = three;
        two.left = four;
        two.right = five;
        three.left = six;

        List<Integer> integers = inorderTraversal(root);
        List<Integer> integersRecursive = inorderRecursiveTraversal(root);
        integers.forEach(System.out::print);
        System.out.println();
        integersRecursive.forEach(System.out::print);
    }

    /**
     * DFS 递归 中序遍历   左->根-> 右
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        // 栈 模拟递归
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        // 先将左子节点入栈
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 当左子节点 或右子节点没有是 弹栈一个元素
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    /**
     * 递归实现
     */
    public static List<Integer> inorderRecursiveTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        recursiveOrder(root, res);
        return res;
    }

    /**
     *
     */
    private static void recursiveOrder(TreeNode root, List<Integer> list) {
        if (root.left != null) {
            recursiveOrder(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            recursiveOrder(root.right, list);
        }
    }
}

