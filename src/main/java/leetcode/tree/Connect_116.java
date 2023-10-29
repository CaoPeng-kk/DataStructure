package leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description:
 * @Date: Created in 22:24 2023/10/24/0024
 * @Author: caopeng
 */
public class Connect_116 {

    public static void main(String[] args) {
        TreeNode.Node root = new TreeNode.Node(1);
        TreeNode.Node two = new TreeNode.Node(2);
        TreeNode.Node three = new TreeNode.Node(3);
        TreeNode.Node four = new TreeNode.Node(4);
        TreeNode.Node five = new TreeNode.Node(5);
        TreeNode.Node six = new TreeNode.Node(6);
        TreeNode.Node seven = new TreeNode.Node(7);
        root.left = two;
        root.right = three;
        two.left = four;
        two.right = five;
        three.left = six;
        three.right = seven;

        TreeNode.Node traverse = traverse(root);
        System.out.println(1);
    }

    public static TreeNode.Node traverse(TreeNode.Node root) {
        if (root == null) {
            return root;
        }
        Deque<TreeNode.Node> q = new LinkedList<>();
        root.next = null;
        q.offer(root);
        // 从上到下遍历二叉树的每一层
        while (!q.isEmpty()) {
            int sz = q.size();
            // 从左到右遍历每一层的每个节点
            for (int i = 0; i < sz; i++) {
                // 将下一层节点放入队列
                TreeNode.Node cur = q.poll();
                if (i > 0 && i < sz) {
                    // 队尾
                    TreeNode.Node tailNode = q.peekLast();
                    if (tailNode != null) {
                        tailNode.next = cur.left;
                    }
                }
                if (cur.left != null && cur.right != null) {
                    cur.left.next = cur.right;
                    q.offer(cur.left);
                    q.offer(cur.right);
                }
            }
        }
        return root;
    }
}
