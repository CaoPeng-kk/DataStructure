package jan.secondweek.algorithm.sort;

import java.util.Arrays;

/**
 * @Description: 堆排序
 * @Date: Created in 16:53 2021/4/13
 * @Author: caopeng
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] array = {4, 6, 8, 5, 9};
        System.out.println(Arrays.toString(array));

        // 循环控制每次调整的叶子节点 规则为自下而上 从左到右  循环结束后 就会产生一个最大的值在堆顶 此二叉树 也变成了一个大顶堆
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            adjustHeap(array, i, array.length);
            System.out.println("循环调整" + Arrays.toString(array));
        }
        System.out.println("找出最大值在堆顶 (大顶堆构造完成) " + Arrays.toString(array));
        int temp;

        // 将堆顶元素与数组末尾元素互换、循环之后与此末尾替换
        for (int j = array.length - 1; j >= 0; j--) {
            temp = array[0];
            array[0] = array[j];
            array[j] = temp;
            // 因为之前的二叉树已经是一个大顶堆了 所以以后每次只需从父节点开始 找出最大值并与末尾替换即可
            System.out.println("互换之后" + Arrays.toString(array));
            adjustHeap(array, 0, j);
            System.out.println("重排" + Arrays.toString(array));
        }

        System.out.println(Arrays.toString(array));
    }

    /**
     * @Description: 构造大顶堆方法
     *               4
     *             /   \
     *            6     8
     *          / \
     *        5    9
     *         {4, 6, 8, 5, 9}
     * @param arr 待调整的数组
     * @param i 表示非叶子节点在数组中的索引
     * @param length 表示对多少个元素继续调整 length在逐渐减少
     * @Return: void
     * @Author: caopeng
     * @Date: 2021/4/14 13:49
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        // 将叶子节点的值赋给临时变量
        int temp;
        // 循环 找出以此叶子节点为二叉树的最大值 并放到堆顶
        for (int k = i * 2 + 1; k < length; k = 2 * k + 1) {
            // 如果左子节点的值小于右子节点的值 那么就将索引指向右子节点
            if ((k+1) < length && arr[k] < arr[k+1]) {
                k++;
            }
            if (arr[k] > arr[i]) {
                temp = arr[k];
                arr[k] = arr[i];
                arr[i] = temp;
                // 将i 指向 k 以便下一次循环的时候将子树的最大值也找出来 放到堆顶
                i = k;
            } else {
                break;
            }
        }
    }
}
