package jan.secondweek.sort;

/**
 * @Author: caopeng
 * @Description: 插入排序
 * @Date: Created in 9:42 2020/8/4
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] array = {3,5,1,4,9,0,2};
        insertSort(array);
        for(int num : array) {
            System.out.print(" "+num);
        }
    }

    /**
     * @Description: 插入排序方法
     * @Param: [array]
     * @return: void
     * @Author: caopeng
     * @Date: 2020/8/4
     */
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {

                int temp = array[i];
                int j = i;

                while (j > 0 && array[j - 1] > temp) {
                    array[j] = array[j - 1];
                    j--;
                }

                array[j] = temp;
            }
        }
    }
}
