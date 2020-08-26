package com.test.data.data_struct.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {

        int arr[] = {3, 9, -1, 10, -2};

        //将排序最大的数排在最后
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            //前面的数比后面的数大 则交换
            if (arr[i] > arr[i + 1]) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        System.out.println("1次排序:" + Arrays.toString(arr));

        //将排序二大的数排在最后二
        for (int i = 0; i < arr.length - 1 - 1; i++) {
            //前面的数比后面的数大 则交换
            if (arr[i] > arr[i + 1]) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        System.out.println("2次排序:" + Arrays.toString(arr));

        //将排序三大的数排在最后三
        for (int i = 0; i < arr.length - 1 - 2; i++) {
            //前面的数比后面的数大 则交换
            if (arr[i] > arr[i + 1]) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        System.out.println("3次排序:" + Arrays.toString(arr));

        //将排序四大的数排在最后四
        for (int i = 0; i < arr.length - 1 - 3; i++) {
            //前面的数比后面的数大 则交换
            if (arr[i] > arr[i + 1]) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        System.out.println("4次排序:" + Arrays.toString(arr));

//        1次排序:[3, -1, 9, -2, 10]
//        2次排序:[-1, 3, -2, 9, 10]
//        3次排序:[-1, -2, 3, 9, 10]
//        4次排序:[-2, -1, 3, 9, 10]
        System.out.println("优化后：");
//        int arr1[] = {3,9,-1,10,-2};
        int arr1[] = {3, 9, -1, 10, 20};
        boolean flag = false;//标识变量 标识是否进行过交换
        for (int i = 0; i < arr1.length - 1; i++) {
            int temp1 = 0;
            for (int j = 0; j < arr1.length - 1 - i; j++) {
                if (arr1[j] > arr1[j + 1]) {
                    flag = true;
                    temp1 = arr1[j];
                    arr1[j] = arr1[j + 1];
                    arr1[j + 1] = temp1;
                }
            }
            System.out.println((i + 1) + "次排序:" + Arrays.toString(arr1));
            if (!flag) {//交换一次都没有发生过
                break;
            } else {
                flag = false; //重置flag！！！ 进行下次交换
            }
        }
      /*  1次排序:[3, -1, 9, -2, 10]
        2次排序:[-1, 3, -2, 9, 10]
        3次排序:[-1, -2, 3, 9, 10]
        4次排序:[-2, -1, 3, 9, 10]
        优化后：
        1次排序:[3, -1, 9, -2, 10]
        2次排序:[-1, 3, -2, 9, 10]
        3次排序:[-1, -2, 3, 9, 10]
        4次排序:[-2, -1, 3, 9, 10]*/

        /*1次排序:[3, -1, 9, 10, 20]
        2次排序:[-1, 3, 9, 10, 20]
        3次排序:[-1, 3, 9, 10, 20]*/
        //测试一下冒泡排序的速度o(n^2)  时间复杂度计算
        int[] arr2 = new  int[80000];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = (int) (Math.random() * 8000000);
        }
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("sort before:"+sdf.format(date));
        bubbleSort(arr2);
        System.out.println("sort after:"+sdf.format(new Date()));
    }

    /**
     * 冒泡排序
     */
    public static void bubbleSort(int[] arr1) {
        boolean flag = false;//标识变量 标识是否进行过交换
        for (int i = 0; i < arr1.length - 1; i++) {
            int temp1 = 0;
            for (int j = 0; j < arr1.length - 1 - i; j++) {
                if (arr1[j] > arr1[j + 1]) {
                    flag = true;
                    temp1 = arr1[j];
                    arr1[j] = arr1[j + 1];
                    arr1[j + 1] = temp1;
                }
            }
//            System.out.println((i + 1) + "次排序:" + Arrays.toString(arr1));
            if (!flag) {//交换一次都没有发生过
                break;
            } else {
                flag = false; //重置flag！！！ 进行下次交换
            }
        }
    }

}
