package com.test.data.data_struct.stack;

import java.util.Scanner;

public class ArrayStackDemo {

    public static void main(String[] args) {
        //创建栈
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop  = true;
        Scanner scanner = new Scanner(System.in);
        while (loop){
            System.out.println("show--显示栈");
            System.out.println("exit--退出程序");
            System.out.println("push--入栈（加数据）");
            System.out.println("pop--出栈（取数据）");

            key= scanner.next();
            switch (key){
                case  "show":
                    stack.show();
                    break;
                case  "exit":
                    scanner.close();
                    loop = false;
                    break;
                case  "push":
                    System.out.println("输入一个数：");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case  "pop":
                    try {
                        int res = stack.pop();
                        System.out.printf("出战数据%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println("exit");
//        show--显示栈
//        exit--退出程序
//        push--入栈（加数据）
//        pop--出栈（取数据）
//        show
//                栈空
//        show--显示栈
//        exit--退出程序
//        push--入栈（加数据）
//        pop--出栈（取数据）
//        push
//        输入一个数：
//        10
//        show--显示栈
//        exit--退出程序
//        push--入栈（加数据）
//        pop--出栈（取数据）
//        push
//        输入一个数：
//        20
//        show--显示栈
//        exit--退出程序
//        push--入栈（加数据）
//        pop--出栈（取数据）
//        show
//        stack[1]=20
//        stack[0]=10
//        show--显示栈
//        exit--退出程序
//        push--入栈（加数据）
//        pop--出栈（取数据）
//        push
//        输入一个数：
//        30
//        show--显示栈
//        exit--退出程序
//        push--入栈（加数据）
//        pop--出栈（取数据）
//        push
//        输入一个数：
//        40
//        show--显示栈
//        exit--退出程序
//        push--入栈（加数据）
//        pop--出栈（取数据）
//        show
//        stack[3]=40
//        stack[2]=30
//        stack[1]=20
//        stack[0]=10
//        show--显示栈
//        exit--退出程序
//        push--入栈（加数据）
//        pop--出栈（取数据）
//        push
//        输入一个数：
//        50
//        栈满
//        show--显示栈
//        exit--退出程序
//        push--入栈（加数据）
//        pop--出栈（取数据）
//        pop
//                出战数据40
//        show--显示栈
//        exit--退出程序
//        push--入栈（加数据）
//        pop--出栈（取数据）
//        pop
//                出战数据30
//        show--显示栈
//        exit--退出程序
//        push--入栈（加数据）
//        pop--出栈（取数据）
//        pop
//                出战数据20
//        show--显示栈
//        exit--退出程序
//        push--入栈（加数据）
//        pop--出栈（取数据）
//        show
//        stack[0]=10
//        show--显示栈
//        exit--退出程序
//        push--入栈（加数据）
//        pop--出栈（取数据）
//        pop
//                出战数据10
//        show--显示栈
//        exit--退出程序
//        push--入栈（加数据）
//        pop--出栈（取数据）
//        show
//                栈空
//        show--显示栈
//        exit--退出程序
//        push--入栈（加数据）
//        pop--出栈（取数据）
    }



}
