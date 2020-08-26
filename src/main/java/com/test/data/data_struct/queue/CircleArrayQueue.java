package com.test.data.data_struct.queue;

/**
 * 使用环形队列数组队列
 */
public class CircleArrayQueue {
    private int maxSize;//数组最大容量
    private int front;//队列头
    private int rear;//队列为
    private int[] arr;//存放数据 模拟队列

    //创建队列
    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[this.maxSize];
        front = 0;//front 变量的含义做一个调整: front 就指向队列的第一个元素,也就是说ar[front]就是队列的第一个元素
        rear = 0;//rear 变量的含义做一个调整: rear 指向队列的最后一个元素的后一个位置.因为希望空出一个空间做为约定.
    }

    //队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }


    //队列是否为空
    public boolean isEmpty() {

        return rear == front;
    }

    /**
     * 添加进队列
     */
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满，不能加入数据");
            return;
        }
        arr[rear] = n;//直接存放数据
        rear = (rear + 1) % maxSize; // rear后移 考虑取模
    }

    /**
     * 取数据出队列
     */
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能取数据");
        }
        // front是直接指向数组的第一个元素
        // 1. 先把 front 对应的值保留到一个临时变量
        // 2. 将 front 后移, 考虑取模
        // 3. 将临时保存的变量返回
        int val = arr[front];
        front = (front + 1) % maxSize;

        return val;

    }


    /**
     * 显示队列数据
     */
    public void showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能打印数据");
        }
        //从front开始遍历 遍历多少个元素
        for (int i = front; i < front +size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    // 求出当前队列有效数据的个数
    public int size() {
        // rear = 2
        // front = 1
        // maxSize = 3
        return (rear + maxSize - front) % maxSize;
    }

    /**
     * 显示队列头数据
     */
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能取数据");
        }
        return arr[front + 1];
    }
}
