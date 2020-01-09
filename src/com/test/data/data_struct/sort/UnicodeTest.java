package com.test.data.data_struct.sort;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnicodeTest {

    public static void main(String[] args) {
        String test = "\\u5c31\\u50cf\\u8fd9\\u79cd\\u0055\\u006e\\u0069\\u0063\\u006f\\u0064\\u0065\\u7f16\\u7801";
        long st = new Date().getTime();
        System.out.println(UnicodeToCN(test));
        long et = new Date().getTime();
        System.out.println(new Date().getTime());
        long st1 = new Date().getTime();
        System.out.println(unicodetoString(test));
        long et1 = new Date().getTime();
        System.out.println(((et-st) - (et1-st1)));
    }


    private static String UnicodeToCN(String unicodeStr) {
        Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
        Matcher matcher = pattern.matcher(unicodeStr);
        char ch;
        while (matcher.find()) {
            //group
            String group = matcher.group(2);
            //ch:'李四'
            ch = (char) Integer.parseInt(group, 16);
            //group1
            String group1 = matcher.group(1);
            unicodeStr = unicodeStr.replace(group1, ch + "");
        }

        return unicodeStr.replace("\\", "").trim();
    }


    private static String unicodetoString(String unicode) {
        if (unicode == null || "".equals(unicode)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i = -1;
        int pos = 0;
        while ((i = unicode.indexOf("\\u", pos)) != -1) {
            sb.append(unicode.substring(pos, i));
            if (i + 5 < unicode.length()) {
                pos = i + 6;
                sb.append((char) Integer.parseInt(unicode.substring(i + 2, i + 6), 16));
            }
        }
        return sb.toString();
    }

}
