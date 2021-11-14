package leetcode;

/**
 * @Description: leetCode27 移除元素
 * @Date: Created in 22:41 2021/11/13
 * @Author: caopeng
 */
public class LeetCode27 {

    public static void main(String[] args) {
        int[] ints = {0, 1, 2, 2, 3, 0, 4, 2};
        int[] inss = {3, 4};
        int i = removeElement(inss, 4);
        for (int j = 0; j < i; j++) {
            System.out.println("数组元素=>" + inss[j]);
        }
        System.out.println("===数组长度 {}===" + i);
    }

    /**
     * 双指针移除元素
     */
    public static int removeElement(int[] nums, int val) {
        /**
         * 定义左右指针指向数组头尾 左指针代表要赋值的元素的位置  右指针代表输入数组的索引
         * 左指针也要判断当前元素是否是被删除值 如果是 则判断右指针的元素是否是 如果右指针的值是，则
         * 想左移以为继续判断 如果不是 将值赋值给左指针的位置
         */
        // 右指针
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }
}
