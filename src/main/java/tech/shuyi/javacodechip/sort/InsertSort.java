package tech.shuyi.javacodechip.sort;

import java.util.Arrays;

/**
 * @author Ronald
 * @description
 * @date 2021/8/17
 */
public class InsertSort {
    /**
     * 插入排序
     * @param arr
     */
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                swap(arr,j,j-1);
                j--;
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
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}