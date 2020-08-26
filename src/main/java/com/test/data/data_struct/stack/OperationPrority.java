package com.test.data.data_struct.stack;

public class OperationPrority {

    public static final int  ADD = 1;
    public static final int  SUB = 1;
    public static final int  MUL = 2;
    public static final int  DIV = 2;

    public  static  int getValue(String oper){
        int result = 0;
        switch (oper){
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                throw  new RuntimeException("运算符错误:"+oper);
        }
        return  result;
    }

}
