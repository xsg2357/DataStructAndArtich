package com.test.data.data_struct;

/**
 * 稀疏数组
 */
public class SparseArray {

    public static void main(String[] args) {
        //创建一个 11 * 11 的二维数组
        int rowCount = 11; //行个数
        int colCount = 11; // 列个数
        int[][] chessArr  = new int[rowCount][colCount];
        // 0 表示没有棋子 1 黑子 2 篮子
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;

        System.out.println("原始棋子：");
        for (int[] row:chessArr) {
            for (int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        //二维数组转稀疏数组
        //计算原始数组有数据的个数
        int sum = 0;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j <colCount ; j++) {
                if (chessArr[i][j] != 0){
                    sum++;
                }
            }
        }
        System.out.println("sum =" +sum);
        // 创建对应的稀疏数组
        int[][] sparseArr = new int[sum+1][3];
        sparseArr[0][0] = rowCount;
        sparseArr[0][1] = colCount;
        sparseArr[0][2] = sum;

        // 遍历二维数组 将非0的值存入稀疏数组
        int count = 0;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j <colCount ; j++) {
                if (chessArr[i][j] != 0){
                    count ++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr[i][j];
                }
            }
        }

        //输出稀疏数组
        System.out.println("稀疏数组棋子：");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }

        // 稀疏数组 ==> 二维数组
        int[][] chessArr1  = new int[sparseArr[0][0]][sparseArr[0][1]];

        // 二维数组赋值  从稀疏数组2行开始
        for (int i = 1; i < sparseArr.length  ; i++) {
            chessArr1[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        //输出恢复后的二维数组
        System.out.println("输出恢复后的二维数组：");
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j <chessArr1[i].length ; j++) {
                System.out.printf("%d\t",chessArr1[i][j]);
            }
            System.out.println();
        }
    }
}
