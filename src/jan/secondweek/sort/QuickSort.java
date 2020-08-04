package jan.secondweek.sort;

/**
 * @Author: caopeng
 * @Description: 快速排序算法
 * @Date: Created in 19:12 2020/8/3
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = {3,5,4,1,7,9,2};
        quickSort(array, 0, array.length-1);
        for (int num : array) {
            System.out.print(num);
        }
    }

    public static void quickSort(int[] array, int left, int right) {
        if (left > right)
            return;
        int base = array[left];
        int leftIndex = left;
        int rightIndex = right;
        while (leftIndex < rightIndex) {
            while (rightIndex > leftIndex && array[rightIndex] >= base ) {
                rightIndex--;
            }
            while (leftIndex < rightIndex && array[leftIndex] <= base) {
                leftIndex++;
            }
            if (leftIndex == rightIndex)
                break;
            int temp = array[leftIndex];
            array[leftIndex] = array[rightIndex];
            array[rightIndex] = temp;
        }
        int exchangeBase = array[left];
        array[left] = array[leftIndex];
        array[leftIndex] = exchangeBase;

        quickSort(array, left, leftIndex-1);
        quickSort(array, leftIndex+1, right);
    }
}
