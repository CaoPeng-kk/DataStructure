package jan.secondweek.algorithm.sort;

/**
 * @Author: caopeng
 * @Description: 选择排序
 * @Date: Created in 13:52 2020/8/4
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] array = {-2,4,1,6,9,2,5};
        selectSort(array);
        for(int num : array) {
            System.out.print(num+" ");
        }
    }

    /**
     * @Description: 选择排序算法
     * @Param: [array]
     * @return: void
     * @Author: caopeng
     * @Date: 2020/8/4
     */
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
