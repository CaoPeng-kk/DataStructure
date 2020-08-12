package jan.secondweek.sort;

/**
 * @Author: caopeng
 * @Description: 冒泡排序
 * @Date: Created in 15:09 2020/8/4
 */
public class PopSort {

    public static void main(String[] args) {
        int[] array = {2,4,7,0,3,7,1};
        popSort(array);
        for(int num : array) {
            System.out.print(num+" ");
        }
    }

    /**
     * @Description: 冒泡排序算法
     * @Param:
     * @return:
     * @Author: caopeng
     * @Date: 2020/8/4
     */
    public static void popSort(int[] array) {
        boolean flag = true;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length-1; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }
}
