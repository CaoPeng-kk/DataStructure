package leetcode.tree;

import java.util.Arrays;

/**
 * @Description: 构造最大二叉树
 * @Date: Created in 22:54 2023/10/29/0029
 * @Author: caopeng
 */
public class ConstructMaximumBinaryTree_654 {

    public static void main(String[] args) {
        int[] array = {3,2,1,6,0,5};

        TreeNode treeNode = constructMaximumBinaryTree(array);
        System.out.println(1);
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private static TreeNode build(int[] nums, int arraybegin, int arrayEnd) {
        if (nums == null || nums.length == 0 || arraybegin > arrayEnd) {
            return null;
        }
        int maxValue = Integer.MIN_VALUE;
        int index = 0;
        // 找到数组中最大的值
        for (int i = arraybegin; i <= arrayEnd; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(maxValue);
        root.left = build(nums, arraybegin, index - 1);
        root.right = build(nums, index + 1, arrayEnd);
        return root;
    }
}
