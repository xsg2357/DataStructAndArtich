package com.test.data.data_struct.queue;

/**
 * 使用队列数组模拟队列
 */
public class ArrayQueue {
    private int maxSize;//数组最大容量
    private int front;//队列头
    private int rear;//队列为
    private int[] arr;//存放数据 模拟队列

    //创建队列
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[this.maxSize];
        front = -1;//执行对列头部，分析出front是指向队列头部的前一个位置
        rear = -1;//执行对列wei部，指向队列尾的（最后一个）数据
    }

    //队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }


    //队列是否为空
    public boolean isEmpty() {

        return rear == front;
    }

    /**
     * 添加进队列
     */
    public void addQueue(int n) {
        if (isFull()){
            System.out.println("队列满，不能加入数据");
            return;
        }
        rear ++; // rear后移
        arr[rear] = n;
    }

    /**
     * 取数据出队列
     */
    public  int getQueue(){
        if (isEmpty()){
            throw  new RuntimeException("队列为空，不能取数据");
        }
        front ++;// front后移

        return  arr[front];

    }


    /**
     * 显示队列数据
     */
    public  void   showQueue(){
        if (isEmpty()){
            throw  new RuntimeException("队列为空，不能打印数据");
        }
        for (int i = 0; i <arr.length ; i++) {
            System.out.printf("arr[%d]= %d\n",i,arr[i]);
        }
    }

    /**
     * 显示队列头数据
     */
    public  int headQueue(){
        if (isEmpty()){
            throw  new RuntimeException("队列为空，不能取数据");
        }
        return  arr[front+1];
    }
}
