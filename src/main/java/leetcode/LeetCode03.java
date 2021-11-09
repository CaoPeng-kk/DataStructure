package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: leetCode 03 最长不重复子串
 * @Date: Created in 10:32 2021/11/5
 * @Author: caopeng
 */
public class LeetCode03 {

    /**
     * 测试用例
     *
     *
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     *
     * 输入: s = ""
     * 输出: 0
     */

    public static void main(String[] args) throws InterruptedException {
        Deque<Character> stack = new ArrayDeque<>();
        String norepeStr = "bbbbb";
        int i = strLength(norepeStr);
        // leetCode版本
//        int i = leetCodeVersion(norepeStr);
        System.out.println(i);
    }

    /**
     * 不重复子串长度 (滑动窗口)
     */
    private static int strLength(String string) {
        int size = 0;
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < string.length(); i++) {
            Character c = string.charAt(i);
            // 窗口中有与待存入元素相同的  就remove掉头部元素
            while (!stack.isEmpty() && stack.contains(c)) {
                stack.pollLast();
            }
            stack.push(c);
            // 保持栈中不重复的最大长度
            size = Math.max(stack.size(), size);
        }
        return size;
    }

    /**
     * leetCode版本   也是一种滑动窗口
     */
    private static int leetCodeVersion(String string) {
        if (string.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < string.length(); i++) {
            if (map.containsKey(string.charAt(i))) {
                // 此元素上一次出现的位置 的下一个元素的位置
                left = Math.max(left, map.get(string.charAt(i)) + 1);
            }
            map.put(string.charAt(i), i);
            // i + 1 为此次元素的位置  - left为减去上次元素出现的位置  得出max（字串）长度
            max = Math.max(max, i + 1 - left);
        }
        return max;
    }
}
