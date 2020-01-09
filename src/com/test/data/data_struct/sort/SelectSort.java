package com.test.data.data_struct.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 选择排序比冒泡排序时间短
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {101, 34, 1119, 1};
        System.out.println("原始：" + Arrays.toString(arr));
//        selectOrderSort(arr);
        selectSort(arr);
        int[] arr2 = new int[80000];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = (int) (Math.random() * 8000000);
        }
        //时间复杂度计算
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("sort before:" + sdf.format(date));
        selectDaoSort(arr2);
        System.out.println("sort after:" + sdf.format(new Date()));
//        sort before:2020-01-09 10:18:11
//        sort after:2020-01-09 10:18:19
    }

    /**
     * 选择排序 从小到大
     */
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {//假定最小值 并不是最小
                    min = arr[j];//重置min
                    minIndex = j;//重置minIndex
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
            System.out.println((i + 1) + "次排序:" + Arrays.toString(arr));
        }
    }

    /**
     * 选择排序 从大到小
     */
    public static void selectDaoSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min < arr[j]) {//假定最小值 并不是最小
                    min = arr[j];//重置min
                    minIndex = j;//重置minIndex
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
//            System.out.println((i+1)+"次排序:" + Arrays.toString(arr));
        }
    }


    /**
     * 逐步推导 简单到复杂
     */
    public static void selectOrderSort(int[] arr) {
        int minIndex = 0;
        int min = arr[0];
        for (int i = 0 + 1; i < arr.length; i++) {
            if (min > arr[i]) {//假定最小值 并不是最小
                min = arr[i];//重置min
                minIndex = i;//重置minIndex
            }
        }
        if (minIndex != 0) {
            arr[minIndex] = arr[0];
            arr[0] = min;
        }
        System.out.println("1 排序:" + Arrays.toString(arr));

        minIndex = 1;
        min = arr[1];
        for (int i = 1 + 1; i < arr.length; i++) {
            if (min > arr[i]) {//假定最小值 并不是最小
                min = arr[i];//重置min
                minIndex = i;//重置minIndex
            }
        }
        if (minIndex != 1) {
            arr[minIndex] = arr[1];
            arr[1] = min;
        }
        System.out.println("2排序:" + Arrays.toString(arr));

        minIndex = 2;
        min = arr[2];
        for (int i = 2 + 1; i < arr.length; i++) {
            if (min > arr[i]) {//假定最小值 并不是最小
                min = arr[i];//重置min
                minIndex = i;//重置minIndex
            }
        }
        if (minIndex != 2) {
            arr[minIndex] = arr[2];
            arr[2] = min;
        }
        System.out.println("3排序:" + Arrays.toString(arr));

    }

}
