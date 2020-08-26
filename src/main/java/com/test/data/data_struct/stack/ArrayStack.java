package com.test.data.data_struct.stack;

public class ArrayStack {

    private  int maxSize ;//栈的大小
    private int[] stack;//数组模拟栈 数据就放在该数组
    private  int top = -1; //栈顶 初始化-1

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new  int[maxSize];
    }

    /**
     * 显示站的情况[遍历栈]
     * 需要从栈顶开始显示数据
     */
    public  void  show(){
        if (isEmpty()){
            System.out.println("栈空");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d \n",i,stack[i]);
        }
    }


    /**
     * 出栈-pop 键栈顶的数据返回
     */
    public int pop(){
        if (isEmpty()){
            throw  new RuntimeException("栈空");
        }
        int i = stack[top];
        top --;
        return  i;

    }

    /**
     * 入栈-push
     */
    public  void  push(int  val){
       if (isFull()){
           System.out.println("栈满");
           return;
       }
        top ++;
       stack[top] = val;
    }

    /**
     * 栈满
     */
    public  boolean isFull(){

        return  top == maxSize -1;
    }

    /**
     * 栈空
     */
    public  boolean isEmpty(){

        return  top == -1;
    }
}
