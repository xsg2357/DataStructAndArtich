package com.test.data.data_struct.recursion;

public class MiGong {

    public static void main(String[] args) {
        //地图
        int[][] map = new int[8][7];
        //使用1表示墙 上下全部
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //使用1表示墙 左右全部
        for (int i = 0; i < 7; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j <7 ; j++) {
                System.out.print(map[i][j] +" ");
            }
            System.out.println();
        }
        //设置挡板
        map[3][1] = 1;
        map[3][2] = 1;

        //使用递归给小球找路
//        setWay(map,1,1);
        /*1 1 1 1 1 1 1
        1 2 0 0 0 0 1
        1 2 2 2 0 0 1
        1 1 1 2 0 0 1
        1 0 0 2 0 0 1
        1 0 0 2 0 0 1
        1 0 0 2 2 2 1
        1 1 1 1 1 1 1*/
        setWay2(map,1,1);
        //设置挡板

        System.out.println("已走过：");
        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j <7 ; j++) {
                System.out.print(map[i][j] +" ");
            }
            System.out.println();
        }
    }

    /**
     * 出发map[1][1] --> map[6][5]终点
     * 0 没有走过 1墙 2 表示路可以走 3 表示该点已走过 但是走不通
     * 策略：下 右 上 左 该点走不通 在回溯
     *
     * @param map 地图
     * @param i   从哪个位置开始找 x
     * @param j   从哪个位置开始找 y
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0){
                map[i][j] =2;//假定该点可以走通
                if (setWay(map,i+1,j)){//往下走
                    return true;
                }else if (setWay(map,i,j+1)){//向右走
                    return  true;
                }else if (setWay(map,i-1,j)) {//向上走
                    return  true;
                }else if (setWay(map,i,j-1)) {//向左走
                    return  true;
                }else{
                    //搜不同 是死路
                    map[i][j] =3;
                    return false;
                }

            }else{//如果map[i][j] != 0 可能是1/2/3
                return false;
            }
        }
       /* 1 1 1 1 1 1 1
        1 2 0 0 0 0 1
        1 2 2 2 0 0 1
        1 1 1 2 0 0 1
        1 0 0 2 0 0 1
        1 0 0 2 0 0 1
        1 0 0 2 2 2 1
        1 1 1 1 1 1 1*/
    }

    /**
     * 修改测略 上右下左
     */
    public static boolean setWay2(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0){
                map[i][j] =2;//假定该点可以走通
                if (setWay2(map,i-1,j)){////向上走
                    return true;
                }else if (setWay2(map,i,j+1)){//向右走
                    return  true;
                }else if (setWay2(map,i+1,j)) {//往下走
                    return  true;
                }else if (setWay2(map,i,j-1)) {//向左走
                    return  true;
                }else{
                    //搜不同 是死路
                    map[i][j] =3;
                    return false;
                }

            }else{//如果map[i][j] != 0 可能是1/2/3
                return false;
            }
        }
        /*1 1 1 1 1 1 1
        1 2 2 2 2 2 1
        1 0 0 0 0 2 1
        1 1 1 0 0 2 1
        1 0 0 0 0 2 1
        1 0 0 0 0 2 1
        1 0 0 0 0 2 1
        1 1 1 1 1 1 1*/
    }
}
