package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 两数之和 hash版
 * @Date: Created in 23:21 2022/1/11
 * @Author: caopeng
 */
public class LeetCode01 {

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 18;
        int[] ints = twoSum(nums, target);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(target - nums[i]) != null) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
