package com.test.data.data_struct.queue;

import java.util.Scanner;

public class ArrayQueueDemo {

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加进队列");
            System.out.println("g(get):取数据出队列");
            System.out.println("h(head):显示队列头");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    try {
                        arrayQueue.showQueue();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);

                    break;
                case 'g':
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.printf("取出的数据：%d", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 'h':
                    try {
                        int res = arrayQueue.headQueue();
                        System.out.printf("取出的队列头数据：%d", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;

            }
        }
        System.out.println("exit(0)");
    }

}


