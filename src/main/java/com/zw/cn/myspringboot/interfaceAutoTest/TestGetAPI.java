package com.zw.cn.myspringboot.interfaceAutoTest;

import lombok.Data;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: zhaowei
 * Date: 2019/11/1
 * Time: 15:10
 * To change this template use File | Settings | File Templates.
 * Description: TODO
 */
@Data
public class TestGetAPI {

    private static String url = "http://www.yapi.hoau.net/mock/24/body-typkp-itf/rs/ty/smpv/v1/queryWaybillEntity";
    private static CloseableHttpClient httpClient;
    private static HttpGet httpGet;
    private static CloseableHttpResponse httpResponse;
    private static String responseBody;
    private static int responseCode;
    private static Header[] responseHeader;

    public static void main(String[] args) throws IOException {
        //创建一个httpClient的实例
        httpClient = HttpClients.createDefault();
        //创建一个httpGet请求实例
        httpGet = new HttpGet(url);
        //使用httpClient实例发送刚创建的get请求，并用httpResponse将反馈接收
        httpResponse = httpClient.execute(httpGet);

        //从反馈中提取出状态码
        responseCode = httpResponse.getStatusLine().getStatusCode();
        //从反馈中提取出反馈主体
//        responseBody = httpResponse.getEntity();
        //从反馈中提取出所有头部信息
        responseHeader = httpResponse.getAllHeaders();
        //从反馈中提取出反馈主体
        //用EntityUtils工具类将反馈主体处理为字符串形式
        String resnponseBodyString = EntityUtils.toString(httpResponse.getEntity(),"utf-8");

       //反馈头信息以键值对形式保存
       HashMap<String,String> hashMap = new HashMap<String,String>();
       for(Header header:responseHeader){
           hashMap.put(header.getName(), header.getValue());
       }
        System.out.println("responseCode:" + responseCode);
        System.out.println("responseHeader:" + hashMap);
        System.out.println("resnponseBodyString:" + resnponseBodyString);
    }

}
