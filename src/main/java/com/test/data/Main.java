package com.test.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

//        System.out.println(takeLastDecimal(0.05));
//        System.out.println(takeLastDecimal(0.15));
//        System.out.println(takeLastDecimal(0.25));
//        System.out.println(takeLastDecimal(0.35));
//        System.out.println(oldSevenTime(1));
//        System.out.println(oldSevenTime(7));
//        System.out.println(oldSevenTime(30));

        System.out.println(oldTime(-1));
        System.out.println(oldTime(-7));
        System.out.println(oldTime(-30));
    }

    public static int takeLastDecimal(double value) {
        String b = String.valueOf(value);
        char[] c = b.toCharArray();

        return  Integer.parseInt(String.valueOf(c[c.length-1]));
    }

    public static  String oldSevenTime(int  day){

        long nowTime = new Date().getTime();
        long oldTime = nowTime - day * 24 * 3600 * 1000;
        System.out.println(oldTime);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return  sdf.format(new Date(oldTime));

    }

    public static  String oldTime(int  day){
        SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd");
        String maxDateStr = sdf.format(new Date().getTime());
        String minDateStr = "";
        Calendar calc =Calendar.getInstance();
        try {
            calc.setTime(sdf.parse(maxDateStr));
            calc.add(Calendar.DATE, day);
            Date minDate = calc.getTime();
            minDateStr = sdf.format(minDate);
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        return  minDateStr;
    }


}
