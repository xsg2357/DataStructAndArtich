package com.test.data.data_struct.stack;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PolandLocation {


    /**
     * 逆波兰表达式 放入到List中
     */
    public static List<String> getListString(String suffixExpression) {
        String[] s = suffixExpression.split(" ");

        return new ArrayList<>(Arrays.asList(s));
    }

    /**
     * 逆波兰表达式计算
     * 1)从左至右扫描，将3和4压入堆栈;
     * 2)遇到+运算符， 因此弹出4和3 (4为栈项元素，3为次顶元素)，计算出3+4的值，得7， 再将7入栈;3) 将5入栈;
     * 4) 接下来是X运算符，因此弹出5和7，计算出7X5=35，将35入栈;
     * 5)将6入栈;
     * 6) 最后是-运算符，计算出35-6的值，即29， 由此得出最终结果
     */
    public static int cal(List<String> ls) {
        Stack<String> stack = new Stack<>();
        for (String item : ls) {
            //使用正则表达式取出数
            if (item.matches("\\d+")) {//匹配多位数
                //入栈
                stack.push(item);
            } else {
                // pop出两个数 并运算 在入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                switch (item) {
                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res = num1 - num2;
                        break;
                    case "*":
                        res = num1 * num2;
                        break;
                    case "/":
                        res = num1 / num2;
                        break;
                    default:
                        throw new RuntimeException("运算符号有问题");
                }
                stack.push(String.valueOf(res));
            }
        }

        //最后在stack中的数据就是运算结果
        return Integer.parseInt(stack.pop());

    }

    /**
     * 将中缀表达式转成对应的List
     */
    public static List<String> toInfixExpresionList(String s) {

        List<String> ls = new ArrayList<>();
        int i = 0; //指针 用于遍历种子表达式字符串
        StringBuilder str;//多位数拼接
        char c;//每遍历一个字符串 就放到c
        do {
            // c是一个非数字 加入到ls
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                ls.add("" + c);
                i++;
            } else {//是数字 考虑多位数
                str = new StringBuilder();//'0'[48] -> '9'[57]
                while (i < s.length() && (c =s.charAt(i)) >=48 && (c =s.charAt(i)) <=57){
                    str.append(c);//拼接
                    i++;
                }
                ls.add(str.toString());
            }

        } while (i < s.length());


        return  ls;

    }

    /**
     * 将得到的中缀表达式对应的 List => 后缀表达式对应的 List
     * ArrayList [1,+,(,(,2,+,3,),*,4,),-,5] =》 ArrayList [1,2,3,+,4,*,+,5,–]
     */
    public static List<String> parseSuffixExpressionList(List<String> ls) {
        Stack<String> s1 = new Stack<>();//s1 符号栈
        //s2 存储中间结果的栈 整个转换过程中没有pop操作
        //不用Stack<String> s2 直接使用List<String>s2
//        Stack<String> s2 = new Stack<>();
        List<String> s2 =new ArrayList<>();
        for (String item:ls){
            //是一个数 加入s2
            if (item.matches("\\d+")){
                s2.add(item);
            }else  if (item.equals("(")){
                s1.push(item);
//                如果是左括号“("，则直接压入s1
//                如果是右括号“)”，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为
//                止，此时将这一对括号丢弃
            }else  if (item.equals(")")){
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();//将(弹出s1栈 消除小括号
            }else{//优先级
//                遇到运算符时，比较其与s1栈顶运算符的优先级:
//                (1)如果s1为空，或栈顶运算符为左括号“(”，则直接将此运算符入栈;
//                (2)否则，若优先级比栈顶运算符的高，也将运算符压入s1;
//                (3)否则（当item的优先级 <= 栈顶运算符优先级） 将s1栈顶的运算符弹出并压入到s2中，
//                再次转到(4-1)与s1中新的栈顶运算符相比较;
                try {
                    while (s1.size() != 0 && OperationPrority.
                            getValue(s1.peek()) >=OperationPrority.getValue(item)){
                        s2.add(s1.pop());
                    }
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }

                //还需要将item压入栈
                s1.push(item);
            }
        }
        //将s1中 剩余的运算符依次弹出并压入s2
        while (s1.size() != 0){
            s2.add(s1.pop());
        }

        return  s2;//因为是存放到list list是有序的 按顺序输出就是对应的后缀表达式
    }


    public static void main(String[] args) {
        //完成将一个中缀表达式转成后缀表达式的功能
        //说明
        //1. 1+((2+3)×4)-5 => 转成 1 2 3 + 4 × + 5 –
        // 即 "1+((2+3)×4)-5" => ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]
        //3. 将得到的中缀表达式对应的 List => 后缀表达式对应的 List
        // 即 ArrayList [1,+,(,(,2,+,3,),*,4,),-,5] =》 ArrayList [1,2,3,+,4,*,+,5,–]
        String expression = "1+((2+3)*4)-5";//注意表达式
        List<String> infixExpresionList = toInfixExpresionList(expression);
        System.out.println(infixExpresionList); // [1, +, (, (, 2, +, 3, ), *, 4, ), -, 5]
        //为了方便 逆波兰表达式 数字和符号用空格隔开
        List<String> suffixExpressionList = parseSuffixExpressionList(infixExpresionList);
        System.out.println(suffixExpressionList);//[1, 2, 3, +, 4, *, +, 5, -]
        //        String suffixExpression = "3 4 + 5 * 6 -";

//        StringBuilder suffixExpression = new StringBuilder();
//        for (String s : suffixExpressionList) {
//            suffixExpression.append(s);
//        }
//
//        //(30+4)×5-6 => 30 4 + 5 × 6 - => 164
//        // 4 * 5 - 8 + 60 + 8 / 2 => 4 5 * 8 - 60 + 8 2 /
//        //（3+4）x5 -6 ==> 先将"3 4 + 5 x 6 - " 放到ArrayList中
//        //将ArrayList 传递给一个方法 遍历ArrayList配合栈完成计算
//        List<String> rpnList = getListString(suffixExpression.toString());
//        System.out.println("rpnList=" + rpnList);
        int res = cal(suffixExpressionList);
        System.out.printf("res=%d\n", res);
    }


}

