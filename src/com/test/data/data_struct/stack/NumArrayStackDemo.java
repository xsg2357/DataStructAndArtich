package com.test.data.data_struct.stack;

public class NumArrayStackDemo {

    public static void main(String[] args) {
        String expression = "30+20*6-2";
        NumArrayStack numArrayStack = new NumArrayStack(10);
        NumArrayStack operArrayStack = new NumArrayStack(10);

        int index = 0;//扫描
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';//扫描到的char保存ch
        String keepNum = "";//用于拼接多位数

        while (true) {
            //依次得到每一个字符
            ch = expression.substring(index, index + 1).charAt(0);
            if (operArrayStack.isOper(ch)) {//是运算符
                //符号栈有操作符 就进行比较 当前的操作符优先级小于或者等于栈中的操
                // 作符 这是就需要从书展中pop出两个数
                // 再从符号栈中pop出一个符号 进行运算 将得到结果 入数栈
                // 然后将当前的操作符入符号栈
                if (!operArrayStack.isEmpty()) {
                    if (operArrayStack.priority(ch) <=
                            operArrayStack.priority(operArrayStack.peek())) {
                        num1 = numArrayStack.pop();
                        num2 = numArrayStack.pop();
                        oper = operArrayStack.pop();
                        res = numArrayStack.cal(num1, num2, oper);
                        numArrayStack.push(res);
                        operArrayStack.push(ch);
                    } else {
                        //如果当前的操作符优先级大于栈中的操作符 就直接入符号栈  不进行计算
                        operArrayStack.push(ch);
                    }
                } else {//不为空直接入符号栈
                    operArrayStack.push(ch);
                }
            } else {//入数栈
//                numArrayStack.push(ch - 48);
                //处理多位数时 不能发现是一个数就立即入栈
                //在处理数  需要向expression的表达式的index  后在看以为 如果是数就进行扫描
                //是符号才入栈
                //定义一个变量（字符串） 用于拼接

                //处理多位数
                keepNum += ch;

                if (index == expression.length() -1){
                    numArrayStack.push(Integer.parseInt(keepNum));
                }else{
                    //注意看后一位 不是index++ 判断下一位是不是 数字继续扫描 运算符 入栈数字
                    if (operArrayStack.isOper(expression.substring(index+1,index+2).charAt(0))){
                        //后一位是运算符 keepNum = “1” keepNum = “123”
                        numArrayStack.push(Integer.parseInt(keepNum));
                        //keepNum情况
                        keepNum  = "";
                    }
                }


            }
            //index+1 判断是否扫描到express的最后
            index++;
            if (index >= expression.length()) { //到最后 不再做栈操作
                break;
            }
        }

        while (true) {
            //符号栈为空 则计算到最后的结果 数栈中只有一个数字
            if (operArrayStack.isEmpty()) {
                break;
            }
            num1 = numArrayStack.pop();
            num2 = numArrayStack.pop();
            oper = operArrayStack.pop();
            res = numArrayStack.cal(num1, num2, oper);
            numArrayStack.push(res);
        }

        //展示最后数 将数栈的嘴最后一个数pop出
        System.out.printf("表达式%s=%d", expression, numArrayStack.pop());
    }

}
