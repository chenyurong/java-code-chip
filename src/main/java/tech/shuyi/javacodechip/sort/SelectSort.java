package tech.shuyi.javacodechip.sort;

import java.util.Arrays;

/**
 * @author Ronald
 * @description
 * @date 2021/8/17
 */
public class SelectSort {

    /**
     * 选择排序
     * @param arr
     */
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // 每一趟循环比较时，min用于存放较小元素的数组下标，这样当前批次比较完毕最终存放的就是此趟内最小的元素的下标，避免每次遇到较小元素都要进行交换。
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            // 进行交换，如果min发生变化，则进行交换
            if (min != i) {
                swap(arr,min,i);
            }
        }
    }

    private static void swap(int[] arr, int min, int i) {
        int tmp = arr[min];
        arr[min] = arr[i];
        arr[i] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {9, 3, 1, 4, 2, 7};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
