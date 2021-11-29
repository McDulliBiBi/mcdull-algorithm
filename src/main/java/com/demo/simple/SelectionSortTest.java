package com.demo.simple;

/**
 * 选择排序
 * 升序
 * 1，从数列中找到最小值，放在已排序数组的第一个
 * 2，从剩余未排序的元素中找到最小值，放在已排序数组中的最后
 * 3，重复步骤2
 * 时间复杂度
 */
public class SelectionSortTest {

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            swap(arr, i, minIndex);
        }
    }

    public static void swap(int[] arr, int m, int n) {
        int temp = arr[m];
        arr[m] = arr[n];
        arr[n] = temp;
    }

    public static void output(int[] arrays) {
        for (int array : arrays) {
            System.out.print(array + ", ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        //数组初始化
        int [] arrays = {3,2,4,1,5};
        output(arrays);

        selectionSort(arrays);
        output(arrays);
    }
}
