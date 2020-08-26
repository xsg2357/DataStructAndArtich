package com.test.data.data_struct.stack;

public class NumArrayStack {

    private int maxSize;//栈的大小
    private int[] stack;//数组模拟栈 数据就放在该数组
    private int top = -1; //栈顶 初始化-1

    public NumArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    // 返回运算符的优先级 优先级是程序员来确定 优先级使用数字表示
    // 数字越大 优先级越高
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1; //设定的表达式只有+ - * /
        }
    }

    /**
     * 返回当前栈顶的值
     */
    public  int peek(){

        return  stack[top];
    }


    /**
     * 是不是操作符
     */
    public boolean isOper(char val) {

        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return  res;
    }

    /**
     * 显示站的情况[遍历栈]
     * 需要从栈顶开始显示数据
     */
    public void show() {
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d \n", i, stack[i]);
        }
    }


    /**
     * 出栈-pop 键栈顶的数据返回
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        int i = stack[top];
        top--;
        return i;

    }

    /**
     * 入栈-push
     */
    public void push(int val) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = val;
    }

    /**
     * 栈满
     */
    public boolean isFull() {

        return top == maxSize - 1;
    }

    /**
     * 栈空
     */
    public boolean isEmpty() {

        return top == -1;
    }
}
