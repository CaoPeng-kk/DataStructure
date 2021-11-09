package leetcode;

/**
 * @Description: leetCode 05 最长回文子串
 * @Date: Created in 15:32 2021/11/6
 * @Author: caopeng
 */
public class LeetCode05 {

    /**
     *
     */
    public static void main(String[] args) throws InterruptedException {
        String babad = longestPalindrome("ac");
        System.out.println(babad);
    }

    /**
     * 返回最长的回文子串
     * 状态转移方程式为   p[i, j] = s[i] = s[j] && p[i+1, j-1]
     */
    public static String longestPalindrome(String str) {
        if (str == null || str.length() < 2) {
            return str;
        }
        // 二维数组长度
        int len = str.length();
        // 设置回文串起始指针
        int begin = 0;
        // 设置最长回文串的长度
        int maxLength = 1;
        // 将所有的一个字符都置为回文串
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            // 设置动态规划初始状态  后面状态转移方程式会用到
            dp[i][i] = true;
        }
        char[] charArray = str.toCharArray();
        // 控制回文串长度  因为小于2 都是回文串  所以长度从2开始  以此递增长度
        for (int length = 2; length <= len; length++) {
            // 内层循环 逐位按长度遍历字符数组  找出是否为回文串并记录长度  length = j - i + 1
            // i 为左角标
            for (int i = 0; i < len; i++) {
                // j为右角标
                int j = length + i - 1;
                if (j > len - 1) {
                    break;
                }
                // 判断p[i, j] 是否相等 不相等就不是回文串 相等再进行子串的是否相等判断
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    // 判断子串
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                // 如果是回文子串 判断长度是否大于已经记录的最大长度  如果大于 将长度更新 并记录起始位置
                if (dp[i][j] && j - i + 1 > maxLength) {
                    maxLength = j - i + 1;
                    begin = i;
                }
            }
        }
        return str.substring(begin, begin + maxLength);
    }
}

