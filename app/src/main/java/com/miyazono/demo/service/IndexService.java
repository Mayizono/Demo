package com.miyazono.demo.service;

import android.support.annotation.Nullable;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by miyazono on 2017/11/28.
 */

public class IndexService {
    @Nullable
    public static String IndexByPost(){
        try{
            //访问的资源路径
            String path = "http://192.168.2.107:8080/Service/IndexServlet";

            //创建url实例
            URL url = new URL(path);

            //获取HttpURLConnection对象
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

//            //设置超时对象
//            conn.setConnectTimeout(5000);
//
//            //指定请求方式
//            conn.setRequestMethod("POST");
//
//            //准备数据、将参数编码
//            String data = "username="+ URLEncoder.encode(username)
//                    +"&password="+URLEncoder.encode(password);
//
//            //设置请求头
//            conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
//            conn.setRequestProperty("Content-Length",data.length()+"");
//
//            //将数据传给服务器
//            conn.setDoOutput(true);
//
//            //得到输出流
//            OutputStream os = conn.getOutputStream();
//            os.write(data.getBytes());
//            int code = conn.getResponseCode();
//            if(code==200){
//                //得到服务器返回的输入流
//                InputStream is = conn.getInputStream();
//
//                //将输入流转换成字符串
//                String text = StreamTools.readInputStream(is);
//                return text;
//            }else {
//                return null;
//            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
