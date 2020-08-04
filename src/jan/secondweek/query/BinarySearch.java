package jan.secondweek.query;

/**
 * @Author: caopeng
 * @Description: 二分查找
 * @Date: Created in 13:58 2020/8/4
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] array = {1,2,4,5,6,7,8};
        int keymap = 5;
        int result = binarySearch(array,keymap);
        System.out.println(result);
    }

    /**
     * @Description: 二分查找
     * @Param: [array, key]
     * @return: int
     * @Author: caopeng
     * @Date: 2020/8/4
     */
    public static int binarySearch(int[] array, int key) {
        int leftIndex = 0;
        int rightIndex = array.length - 1;
        int middle = (leftIndex + rightIndex) / 2;

        while (leftIndex <= rightIndex) {
            if (key == array[middle]) {
                return middle;
            }
            if (key > array[middle]) {
                leftIndex = middle + 1;
            }
            if (key < array[middle]) {
                rightIndex = middle - 1;
            }
            middle = (leftIndex + rightIndex) / 2;
        }
        return 0;
    }
}
