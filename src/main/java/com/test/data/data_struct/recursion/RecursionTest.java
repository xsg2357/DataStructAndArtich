package com.test.data.data_struct.recursion;

public class RecursionTest {

    public static void main(String[] args) {
        test(4);

        System.out.println(factorial(5)); // 120
    }


    public static void test(int n) {
        if (n > 2) {
            test(n - 1);
        }//else { n =2
            System.out.println("n=" + n);
       // }
        //        n=2
//        n=3
//        n=4
    }

    public static  int factorial(int n){
        if (n==1){
            return  1;
        }else{
            return factorial(n -1) * n;
        }

    }

}
