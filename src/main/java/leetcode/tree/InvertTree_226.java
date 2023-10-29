package leetcode.tree;

/**
 * @Description:
 * @Date: Created in 22:51 2023/10/23/0023
 * @Author: caopeng
 */
public class InvertTree_226 {

    /**
     * 翻转二叉树
     */
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

        TreeNode i = invertTree(root);
        System.out.println(i);
    }

    public static TreeNode invertTree(TreeNode root) {
        traverse(root);
        return root;
    }

    public static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tempNode;
        tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;

        traverse(root.left);
        traverse(root.right);
    }
}
