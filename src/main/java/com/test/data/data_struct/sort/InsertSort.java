package com.test.data.data_struct.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 插入排序
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {101,34,119,1};
        insertDaoSort(arr);
        int[] arr1 = {101,34,119,1};
        insertSort(arr1);
        int[] arr2 = new int[80000];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = (int) (Math.random() * 8000000);
        }
        //时间复杂度计算
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("sort before:" + sdf.format(date));
        insertSort(arr2);
        System.out.println("sort after:" + sdf.format(new Date()));
//        sort before:2020-01-09 10:16:19
//        sort after:2020-01-09 10:16:22       if (insertVal+1 != i) { 加入前

//        sort before:2020-01-09 10:22:33 if (insertVal+1 != i) { 加入后
//        after before:2020-01-09 10:22:36
    }


    public  static void  insertSort(int[] arr){

        for (int i = 1; i < arr.length ; i++) {
            int insertVal = arr[i];
            int insertIndex = i-1;//arr[1]前面一个数的下标
            //insertVal 找到插入的位置
            //insertIndex >= 0 保证插入位置 不越界
            //insertVal < arr[insertIndex] 待插入的数 还没有找到插入位置
            //将需要将arr[insertIndex]后移
            while (insertIndex >= 0 && insertVal < arr[insertIndex]){
                //eg：{101,34,119,1} ==>{101,101,119,1}
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex --;
            }
            //当退出外循环的时候 说明的插入位置找到 insertIndex+1
            if (insertVal+1 != i) {
                arr[insertIndex + 1] = insertVal;
            }
            //            System.out.println(i+"次插入排序后："+ Arrays.toString(arr));
        }
//        1次插入排序后：[34, 101, 119, 1]
//        2次插入排序后：[34, 101, 119, 1]
//        3次插入排序后：[1, 34, 101, 119]
    }


    public  static void  insertDaoSort(int[] arr){
        //1：{101,34,119,1} ==>{34,101,119,1}
        int insertVal = arr[1];
        int insertIndex = 1-1;//arr[1]前面一个数的下标
        //insertVal 找到插入的位置
        //insertIndex >= 0 保证插入位置 不越界
        //insertVal < arr[insertIndex] 待插入的数 还没有找到插入位置
        //将需要将arr[insertIndex]后移
        while (insertIndex >= 0 && insertVal < arr[insertIndex]){
            //eg：{101,34,119,1} ==>{101,101,119,1}
            arr[insertIndex+1] = arr[insertIndex];
            insertIndex --;
        }
        //当退出外循环的时候 说明的插入位置找到 insertIndex+1
        arr[insertIndex+1] = insertVal;
        System.out.println("1次插入排序后："+ Arrays.toString(arr));

        //2：
        insertVal = arr[2];
         insertIndex = 2-1;//arr[2]前面一个数的下标
        //insertVal 找到插入的位置
        //insertIndex >= 0 保证插入位置 不越界
        //insertVal < arr[insertIndex] 待插入的数 还没有找到插入位置
        //将需要将arr[insertIndex]后移
        while (insertIndex >= 0 && insertVal < arr[insertIndex]){
            arr[insertIndex+1] = arr[insertIndex];
            insertIndex --;
        }
        //当退出外循环的时候 说明的插入位置找到 insertIndex+1
        arr[insertIndex+1] = insertVal;
        System.out.println("2次插入排序后："+ Arrays.toString(arr));

        //2：
        insertVal = arr[3];
        insertIndex = 3-1;//arr[3]前面一个数的下标
        //insertVal 找到插入的位置
        //insertIndex >= 0 保证插入位置 不越界
        //insertVal < arr[insertIndex] 待插入的数 还没有找到插入位置
        //将需要将arr[insertIndex]后移
        while (insertIndex >= 0 && insertVal < arr[insertIndex]){
            arr[insertIndex+1] = arr[insertIndex];
            insertIndex --;
        }
        //当退出外循环的时候 说明的插入位置找到 insertIndex+1
        arr[insertIndex+1] = insertVal;
        System.out.println("3次插入排序后："+ Arrays.toString(arr));

//        1次插入排序后：[34, 101, 119, 1]
//        2次插入排序后：[34, 101, 119, 1]
//        3次插入排序后：[1, 34, 101, 119]

    }

}
