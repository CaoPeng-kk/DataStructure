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
     * @param a b c 这里的入参可以理解为 源与目的
     * @Return: void
     * @Author: caopeng
     * @Date: 2021/4/20 16:38
     */
    public static void hanoitoter(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("第1个盘从 " + a + " 移动到->" + c);
        } else {
            // 如果有n >= 2的情况 可以把a上面的所有盘看成两种情况 最下面的一个盘 和上面的所有盘
            // 先把上面的所有盘 从a移动到b   注意！这里把入参 b c 的位置交换递归调用
            hanoitoter(num - 1, a, c, b);
            System.out.println("第" + num +  "个盘从" + a + "移动到 ->" + c);
            // 以三个盘子为例   此处处理 第二个 处理完第二个之后还要对第一个也就是上面的那个落到2的上面
            // 把b 上的所有盘移动到c  此处的方法参数已经是递归传进来的参数了 b为c  c为b
            hanoitoter(num - 1, b, a, c);
        }
    }
}
