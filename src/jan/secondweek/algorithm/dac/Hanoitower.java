package jan.secondweek.algorithm.dac;

/**
 * @Description: 分治算法解决汉诺塔问题
 * @Date: Created in 14:57 2021/4/20
 * @Author: caopeng
 */
public class Hanoitower {

    public static void main(String[] args) {
        hanoitoter(3, 'A', 'B', 'C');
    }

    /**
     * @Description: 汉诺塔的移动方法
     * @param
     * @Return: void
     * @Author: caopeng
     * @Date: 2021/4/20 16:38
     */
    public static void hanoitoter(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("第一个盘从 " + a + " 移动到->" + c);
        } else {
            // 如果有n >= 2的情况 可以把a上面的所有盘看成两种情况 最下面的一个盘 和上面的所有盘
            // 先把上面的所有盘 从a移动到b
            hanoitoter(num - 1, a, c, b);
            System.out.println("第" + num + "个盘从" + a + "移动到 ->" + c);
            // 把b 上的所有盘移动到c  此处的方法参数已经是递归传进来的参数了 b为c  c为b
            hanoitoter(num - 1, b, a, c);
        }
    }
}
