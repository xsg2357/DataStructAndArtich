package com.test.data.data_struct.likedlist;

import java.util.Stack;

public class TestStack {

    public static void main(String[] args) {
        Stack<String> objects = new Stack<>();
        //入栈
        objects.add("jack");
        objects.add("tom");
        objects.add("smith");

        //出栈
        while (objects.size()>0){
            System.out.println(objects.pop());
        }
//        smith
//        tom
//        jack

    }


}
