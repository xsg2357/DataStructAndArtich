package com.test.data.jsoup;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class DemoJsoup1 {

    public static void main(String[] args) {
        String url = "https://read.douban.com/?dcm=normal-nav";
        Connection connection = Jsoup.connect(url);
        //connection.get()
        //connection.post()
        //设置单个请求头
        Connection conheader = connection.header("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
                "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.108 Safari/537.36");
       try {
            Document document = conheader.get();
            //设置一个请求头
            System.out.println(document.html());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
