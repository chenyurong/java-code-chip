package tech.shuyi.javacodechip.sort;

import java.util.Arrays;

/**
 * @author Ronald
 * @description
 * @date 2021/8/17
 */
public class BubbleSort {
    /**
     * 冒泡排序
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            //设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已然完成。
            boolean flag = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr,j,j+1);
                    flag = false;
                }
            }
            if (flag) {
                break;
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
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
