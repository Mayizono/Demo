package com.miyazono.demo.service;

import android.support.annotation.Nullable;

import com.miyazono.demo.tools.StreamTools;

import org.json.JSONObject;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by miyazono on 2017/11/27.
 */

public class RegisterService {
    @Nullable
    public static String RegisterByPost(String username, String password){
        try{

            //json对象
            JSONObject userjson = new JSONObject();
            userjson.put("userName",username);
            userjson.put("userPwd",password);
//            JSONObject youyou = new JSONObject();
//            youyou.put("User",userjson);
//            String content = String.valueOf(youyou);
            System.out.println(userjson);

            //访问的资源路径
            String path = "http://192.168.23.1:8080/Service/RegisterServlet";

            //创建url实例
            URL url = new URL(path);

            //获取HttpURLConnection对象
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            //设置超时对象
            conn.setConnectTimeout(5000);

            //指定请求方式
            conn.setRequestMethod("POST");

            //将数据传给服务器
            conn.setDoOutput(true);
            conn.setDoInput(true);

            //转换为字节数组
            byte[] data = (userjson.toString()).getBytes();

            //准备数据、将参数编码
//            String data = "username="+ URLEncoder.encode(username)
//                    +"&password="+URLEncoder.encode(password);

            //设置请求头
            conn.setRequestProperty("Content-Type","application/json; charset=UTF-8");
            conn.setRequestProperty("accept","application/json");
            conn.setRequestProperty("ser-Agent", "Fiddler");
//            conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length",String.valueOf(data.length));

            //请求连接
            conn.connect();

            //得到输出流
            OutputStream os = conn.getOutputStream();
            os.write(data);

            int code = conn.getResponseCode();
            if(code==200){
//                Toast.makeText(this, "Post完成", 1).show();
                //得到服务器返回的输入流
                InputStream is = conn.getInputStream();

                //将输入流转换成字符串
                String text = StreamTools.readInputStream(is);

//                //然后我们把json转换成JSONObject类型得到{"Person": //{"username":"zhangsan","age":"12"}}
//                JSONObject jsonObject = new JSONObject(text).getJSONObject("username");
                return text;
            }else {
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
