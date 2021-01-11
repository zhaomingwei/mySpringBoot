package com.zw.cn.myspringboot.interfaceAutoTest;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.message.BasicNameValuePair;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhaowei
 * Date: 2019/11/1
 * Time: 16:03
 * To change this template use File | Settings | File Templates.
 * Description: TODO
 */
public class TestPostNG {
    RestfulClient client;
    JSONObject responseBody;
    JSONParser jParser;
    int responseCode;
    String errorCode;
    String url = "http://www.yapi.hoau.net/mock/24/body-typkp-itf/rs/ty/smpv/v1/queryWaybillEntity";
    String postBody;

    @Test
    public void testPostRequest() {
        //断言反馈中城市信息是否正确
        Assert.assertEquals(errorCode, "1000");
        //断言反馈的状态码是否正确
        Assert.assertEquals(responseCode, 200);
    }
    @BeforeClass
    public void beforeClass() throws ClientProtocolException, IOException {
        client = new RestfulClient();
        //用NameValuePair的list来添加请求主体参数
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("companyId", "SMPV"));
        String[] strArray = {"H0281075","H0216004"};
        params.add(new BasicNameValuePair("waybills", strArray.toString()));
        //用哈希图准备请求头部信息
        HashMap<String, String> hashHead = new HashMap();
        hashHead.put("Content-Type", "application/x-www-form-urlencoded");
        //传参发送post请求并接收反馈
        client.sendPost(url, params, hashHead);
        responseBody = client.getBodyInJSON();
        responseCode = client.getCodeInNumber();
        System.out.println(responseBody);
        jParser = new JSONParser();
        errorCode = jParser.getErrorCode(responseBody);
    }
}
