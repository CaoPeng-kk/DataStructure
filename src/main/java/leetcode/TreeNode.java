package leetcode;

/**
 * @Description: 公共二叉树
 * @Date: Created in 20:35 2021/11/9
 * @Author: caopeng
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
