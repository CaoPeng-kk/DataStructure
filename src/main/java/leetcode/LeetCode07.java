package leetcode;

/**
 * @Description: leetcode07 整数反转
 * @Date: Created in 12:01 2022/1/16
 * @Author: caopeng
 */
public class LeetCode07 {

    public static void main(String[] args) {
        int reverse = reverse(1200);
        System.out.println(reverse);
    }

    /**
     * @Description:
     * @param x
     * @Return: int
     * @Date: 2022/2/8 0:02
     * @Author: caopeng
     */
    public static int reverse(int x) {
        int res = 0;
        int tempInt;
        // 还要考虑长度限制 不能超过32位
        while (x != 0) {
            tempInt = x % 10;
            if (res > 214748364 || res < -214748364) {
                // 溢出
                return 0;
            }
            if (res == 214748364) {
                if (tempInt > 7) {
                    return 0;
                }
            } else if (res == -214748364) {
                if (tempInt > 8) {
                    return 0;
                }
            }
            res = res * 10 + tempInt;
            x = x / 10;
        }
        return res;
    }
}
