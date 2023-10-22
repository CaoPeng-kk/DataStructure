package leetcode.tree;

/**
 * @Description:
 * @Date: Created in 22:33 2023/10/22/0022
 * @Author: caopeng
 */
public class MaxDepth_104 {


    public static void main(String[] args) {
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

        int i = maxDepth(root);
        System.out.println(i);
    }

    public static int maxDepth(TreeNode root) {
        int leftDepth = traverseDepth(root.left);
        int rightDepth = traverseDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    private static int traverseDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = traverseDepth(root.left);
        int rightDepth = traverseDepth(root.right);
        // 后序位置判断返回子树最大的直径
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
