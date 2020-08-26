package com.test.data.jsoup;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class DemoJsupData {

    public static void main(String[] args) {
//        https://www.kuaidi100.com/autonumber/autoComNum?resultv2=1&text=4307703802424
        Connection connect = Jsoup.connect("https://www.kuaidi100.com/autonumber/autoComNum");
        //添加参数
        connect.data("resultv2", "1", "text", "4307703802424");
        Connection.Response response = null;
        try {
            response = connect.method(Connection.Method.GET).ignoreContentType(true).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取数据,处理成HTML
        Document document = null;
        try {
            document = response.parse();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(document);
    }

}
