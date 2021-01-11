package com.zw.cn.myspringboot.interfaceAutoTest;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: zhaowei
 * Date: 2019/11/1
 * Time: 15:44
 * To change this template use File | Settings | File Templates.
 * Description: TODO
 */
public class TestGetNG {
    RestfulClient client;
    JSONObject responseBody;
    JSONParser jParser;
    int responseCode;
    String city;
    String url = "https://api.apishop.net/communication/phone/getLocationByPhoneNum?apiKey=nMke6NK29c40b1d1331690abb50b3eec8aa0808389b16c4&phoneNum=1861195236";

    @Test
    public void TestGetRequest() {
        //断言反馈中城市是否正确
        Assert.assertEquals(city, "北京");
        //断言反馈中的状态码是否正确
        Assert.assertEquals(responseCode, 200);
    }

    @BeforeClass
    public void beforeClass() throws ParseException, IOException {
        //发送请求，获取反馈
        client = new RestfulClient();
        client.getResponse(url);
        responseBody = client.getBodyInJSON();
        responseCode = client.getCodeInNumber();
        //调用JSONParser获取反馈中的城市信息
        jParser = new JSONParser();
        city = jParser.getErrorCode(responseBody);
    }

}
