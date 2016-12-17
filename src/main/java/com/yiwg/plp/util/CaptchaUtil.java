package com.yiwg.plp.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.Consts;
import org.apache.http.client.HttpClient;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
*@date:2016/12/14
*@className:CaptchaUtil
*@author：yiweiguo
*@description:文件检查工具类
*/
public class CaptchaUtil {
//secret相关
    static String secretId="1437c8025e17ed7565fa946880b21cfd";
    static String secretKey="e0fecafffab944984c246392b64ef8ab";
    static String businessId="5fe1eee642b3b1a5010636fb3b0a17fd";
    static String apiUrl="https://api.aq.163.com/v2/text/check";

    public static String checkText(String content) throws Exception {
        HttpClient httpClient = HttpClient4Utils.createHttpClient(100, 20, 1000, 1000, 1000);
        Map<String, String> params = new HashMap<String, String>();
// 1.设置公共参数
        params.put("secretId", secretId);
        params.put("businessId", businessId);
        params.put("version", "v2");
        params.put("timestamp", String.valueOf(System.currentTimeMillis()));
        params.put("nonce", String.valueOf(new Random().nextInt()));
// 2.设置私有参数
        params.put("dataId", "ebfcad1c-dba1-490c-b4de-e784c2691768");
        params.put("content", content);
        params.put("dataOpType", "1");
        params.put("dataType", "1");
        params.put("ip", "123.115.77.137");
        params.put("account", "java@163.com");
        params.put("deviceType", "4");
        params.put("deviceId", "92B1E5AA-4C3D-4565-A8C2-86E297055088");
        params.put("callback", "ebfcad1c-dba1-490c-b4de-e784c2691768");
        params.put("publishTime", String.valueOf(System.currentTimeMillis()));
        // 3.生成签名信息
        String signature = CaptchaUtil.genSignature(secretKey, params);
        params.put("signature", signature);
        params.put("signature", signature);
        // 4.发送HTTP请求，这里使用的是HttpClient工具包，产品可自行选择自己熟悉的工具包发送请求
        String response = HttpClient4Utils.sendPost(httpClient, apiUrl, params, Consts.UTF_8);

        return response;
    }

    public static String genSignature(String secretKey, Map<String, String> params) throws UnsupportedEncodingException {
        // 1. 参数名按照ASCII码表升序排序
        String[] keys = params.keySet().toArray(new String[0]);
        Arrays.sort(keys);
        // 2. 按照排序拼接参数名与参数值
        StringBuffer paramBuffer = new StringBuffer();
        for (String key : keys) {
            paramBuffer.append(key).append(params.get(key));
        }
        // 3. 将secretKey拼接到最后
        paramBuffer.append(secretKey);
        // 4. MD5是128位长度的摘要算法，用16进制表示，一个十六进制的字符能表示4个位，所以签名后的字符串长度固定为32个十六进制字符。
        return DigestUtils.md5Hex(paramBuffer.toString().getBytes("UTF-8"));
    }
}
