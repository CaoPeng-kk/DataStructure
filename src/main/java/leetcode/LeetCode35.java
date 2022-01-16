package leetcode;

/**
 * @Description: leetCode35 搜索插入位置
 * @Date: Created in 17:48 2021/11/14
 * @Author: caopeng
 */
public class LeetCode35 {

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 6};
        int i = searchInsert(array, 2);
        System.out.println(i);
    }

    /**
     *
     */
    public static int searchInsert(int[] nums, int target) {
        /**
         * 二分法 根据题意简化 返回一个 大于或者等于target值的下标
         */
        int length = nums.length;
        // ans默认在数组长度的位置  可以省略target比数组所有元素都大的长度校验
        int left = 0, right = length - 1, ans = length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                ans = mid;
                right = mid - 1;
            }
        }
        return ans;
    }
}
