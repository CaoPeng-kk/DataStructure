package leetcode.tree;

/**
 * @Description: 二叉树的直径
 * @Date: Created in 0:11 2023/10/22/0022
 * @Author: caopeng
 */
public class DiameterOfBinaryTree_548 {

    private static int maxDiameter = 0;

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

        int i = diameterOfBinaryTree(root);
        System.out.println(i);
    }

    public static int diameterOfBinaryTree(TreeNode root) {

        int leftDepth = traverseDepth(root.left);
        int rightDepth = traverseDepth(root.right);
        return Math.max(leftDepth + rightDepth, maxDiameter);
    }

    private static int traverseDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = traverseDepth(root.left);
        int rightDepth = traverseDepth(root.right);
        // 后序位置判断下当前子树是否是最大的直径
        if (leftDepth + rightDepth > maxDiameter) {
            maxDiameter = leftDepth + rightDepth;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
