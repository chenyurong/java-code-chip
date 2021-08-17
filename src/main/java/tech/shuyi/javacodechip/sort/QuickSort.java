package tech.shuyi.javacodechip.sort;

import java.util.Arrays;

/**
 * @author Ronald
 * @description
 * @date 2021/8/17
 */
public class QuickSort {

    /**
     * @param arr -- 待排序的数组
     * @param l -- 数组的左边界(例如，从起始位置开始排序，则l=0)
     * @param r -- 数组的右边界(例如，排序截至到数组末尾，则r=arr.length-1)
     */
    public static void quickSort(int arr[], int l, int r) {
        if (l < r) {
            int i,j,x;

            i = l;
            j = r;
            x = arr[i];
            while (i < j)
            {
                // 从右向左找第一个小于x的数
                while(i < j && arr[j] > x) {
                    j--;
                }
                if(i < j) {
                    arr[i] = arr[j];
                    i++;
                }
                // 从左向右找第一个大于x的数
                while(i < j && arr[i] < x) {
                    i++;
                }
                if(i < j) {
                    arr[j] = arr[i];
                    j--;
                }
            }
            arr[i] = x;
            quickSort(arr, l, i-1);
            quickSort(arr, i+1, r);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 4, 2, 7};
        quickSort(arr, 0, 5);
        System.out.println(Arrays.toString(arr));
    }
}
