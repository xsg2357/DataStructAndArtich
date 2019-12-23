package com.test.data.data_struct.recursion;

public class Queue8 {

    //多少个皇后
    int  max = 8;

    //定义数组 保存皇后放置位置的结果
    int[] array = new int[max];

    static  int  count = 0;
    static  int  judge = 0;


    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.printf("queue 8 一共 %d 解法",count);
        System.out.printf("queue 8 一共 %d 判断",judge);
        /*0 4 7 5 2 6 1 3
        0 5 7 2 6 3 1 4
        0 6 3 5 7 1 4 2
        0 6 4 7 1 3 5 2
        1 3 5 7 2 0 6 4
        1 4 6 0 2 7 5 3
        1 4 6 3 0 7 5 2
        1 5 0 6 3 7 2 4
        1 5 7 2 0 3 6 4
        1 6 2 5 7 4 0 3
        1 6 4 7 0 3 5 2
        1 7 5 0 2 4 6 3
        2 0 6 4 7 1 3 5
        2 4 1 7 0 6 3 5
        2 4 1 7 5 3 6 0
        2 4 6 0 3 1 7 5
        2 4 7 3 0 6 1 5
        2 5 1 4 7 0 6 3
        2 5 1 6 0 3 7 4
        2 5 1 6 4 0 7 3
        2 5 3 0 7 4 6 1
        2 5 3 1 7 4 6 0
        2 5 7 0 3 6 4 1
        2 5 7 0 4 6 1 3
        2 5 7 1 3 0 6 4
        2 6 1 7 4 0 3 5
        2 6 1 7 5 3 0 4
        2 7 3 6 0 5 1 4
        3 0 4 7 1 6 2 5
        3 0 4 7 5 2 6 1
        3 1 4 7 5 0 2 6
        3 1 6 2 5 7 0 4
        3 1 6 2 5 7 4 0
        3 1 6 4 0 7 5 2
        3 1 7 4 6 0 2 5
        3 1 7 5 0 2 4 6
        3 5 0 4 1 7 2 6
        3 5 7 1 6 0 2 4
        3 5 7 2 0 6 4 1
        3 6 0 7 4 1 5 2
        3 6 2 7 1 4 0 5
        3 6 4 1 5 0 2 7
        3 6 4 2 0 5 7 1
        3 7 0 2 5 1 6 4
        3 7 0 4 6 1 5 2
        3 7 4 2 0 6 1 5
        4 0 3 5 7 1 6 2
        4 0 7 3 1 6 2 5
        4 0 7 5 2 6 1 3
        4 1 3 5 7 2 0 6
        4 1 3 6 2 7 5 0
        4 1 5 0 6 3 7 2
        4 1 7 0 3 6 2 5
        4 2 0 5 7 1 3 6
        4 2 0 6 1 7 5 3
        4 2 7 3 6 0 5 1
        4 6 0 2 7 5 3 1
        4 6 0 3 1 7 5 2
        4 6 1 3 7 0 2 5
        4 6 1 5 2 0 3 7
        4 6 1 5 2 0 7 3
        4 6 3 0 2 7 5 1
        4 7 3 0 2 5 1 6
        4 7 3 0 6 1 5 2
        5 0 4 1 7 2 6 3
        5 1 6 0 2 4 7 3
        5 1 6 0 3 7 4 2
        5 2 0 6 4 7 1 3
        5 2 0 7 3 1 6 4
        5 2 0 7 4 1 3 6
        5 2 4 6 0 3 1 7
        5 2 4 7 0 3 1 6
        5 2 6 1 3 7 0 4
        5 2 6 1 7 4 0 3
        5 2 6 3 0 7 1 4
        5 3 0 4 7 1 6 2
        5 3 1 7 4 6 0 2
        5 3 6 0 2 4 1 7
        5 3 6 0 7 1 4 2
        5 7 1 3 0 6 4 2
        6 0 2 7 5 3 1 4
        6 1 3 0 7 4 2 5
        6 1 5 2 0 3 7 4
        6 2 0 5 7 4 1 3
        6 2 7 1 4 0 5 3
        6 3 1 4 7 0 2 5
        6 3 1 7 5 0 2 4
        6 4 2 0 5 7 1 3
        7 1 3 0 6 4 2 5
        7 1 4 2 0 6 3 5
        7 2 0 5 1 4 6 3
        7 3 0 2 5 1 6 4
        queue 8 一共 92 解法*/
    }

    /**
     * 放置第n个皇后
     */
    private  void check(int n){
        //n = 8 其实8个皇后就已然放好了
        if (n==max){
            print();
            return;
        }
        //依次放入皇后 平判断是否冲突
        for (int i = 0; i <max ; i++) {
            //先把当前这个皇后n 放到改行的第一列
            array[n] = i;
            //i列 是否冲突
            if (judge(n)){ //不冲突 放N+1个皇后
                check(n+1);// 8--> check --for循环--> 回溯
            }
            //冲突 继续执行array[n] = i 即将第n个皇后放在在本行的后移的一个位置
        }
    }


    /**
     * 检测要摆放的皇后和已摆放的皇后是否冲突
     * n =1 放在第二列 1 n =1  array[1] =1
     * Math.abs(1-0) = 1
     * Math.abs(n-i) == Math.abs(array[n]-array[i]) = Math.abs(1-0) =1
     * 判断是否在同一行 没有必要 n每次都在递增
     * @param n 表示第n个皇后
     */
    private  boolean judge(int  n){
        for (int i = 0; i < n ; i++) {
            judge ++;
            if (array[i] ==array[n] //同一列
                    ||Math.abs(n-i) == Math.abs(array[n]-array[i])){//同一斜线
                return  false;
            }
        }
        return  true;
    }


    /**
     * 皇后位置的输出
     */
    private  void print() {
        count ++;
        for (int i = 0; i <array.length ; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }




}
