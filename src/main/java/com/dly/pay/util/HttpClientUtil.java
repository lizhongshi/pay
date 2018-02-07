package com.dly.pay.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;

import com.alibaba.fastjson.JSONObject;
/**
 * 
 * @author 12622
 *
 */
public class HttpClientUtil {
	
	public static final int connTimeout=10000;
    public static final int readTimeout=10000;
    public static final String charset="UTF-8";
    public static CloseableHttpClient getClient() {
    	 CloseableHttpClient client = null;
    	PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
    	cm.setMaxTotal(128);
    	cm.setDefaultMaxPerRoute(128);
    	client = HttpClients.custom().setConnectionManager(cm).build();
		return client;
    }
    public  static  String  doPost(String url,Map<String, String> params) {
    	CloseableHttpClient httpClient = HttpClientUtil.getClient();
		CloseableHttpResponse httpRes=null;
		Builder customReqConf = RequestConfig.custom();
        customReqConf.setConnectTimeout(connTimeout);
        customReqConf.setSocketTimeout(readTimeout);
		HttpPost post =new HttpPost(url);
		//post.addHeader("Content-Type", "application/json;charset=UTF-8");
		post.setConfig(customReqConf.build());
		//设置请求体
		if(params!=null&&!params.isEmpty()) { 
           String json=JSONObject.toJSONString(params);
            post.setEntity( new StringEntity(json,Consts.UTF_8));  
		}
		//设置请求头
		
		 try {
			 httpRes=httpClient.execute(post);
			 return IOUtils.toString(httpRes.getEntity().getContent(), charset);  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			try {
				httpClient.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return null;
		
    }
    
	
	
	public static String doPost(String url,Map<String, String> params, Map<String, String> headers) {
		CloseableHttpClient httpClient = HttpClientUtil.getClient();
		CloseableHttpResponse httpRes=null;
		Builder customReqConf = RequestConfig.custom();
        customReqConf.setConnectTimeout(connTimeout);
        customReqConf.setSocketTimeout(readTimeout);
		HttpPost post =new HttpPost(url);
		//post.addHeader("Content-Type", "application/json;charset=UTF-8");
		post.setConfig(customReqConf.build());
		//设置请求体
		if(params!=null&&!params.isEmpty()) { 
           String json=JSONObject.toJSONString(params);
            post.setEntity( new StringEntity(json,Consts.UTF_8));  
		}
		//设置请求头
		 if (headers != null && !headers.isEmpty()) {  
             for (Entry<String, String> entry : headers.entrySet()) {  
                 post.addHeader(entry.getKey(), entry.getValue());
             }  
         }
		 try {
			 httpRes=httpClient.execute(post);
			 return IOUtils.toString(httpRes.getEntity().getContent(), charset);  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			try {
				httpClient.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return null;
		
		
	}

}
