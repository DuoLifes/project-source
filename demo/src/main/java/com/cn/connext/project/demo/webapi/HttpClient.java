package com.cn.connext.project.demo.webapi;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClient {

    /*HttpGet访问本地服务:CloseableHttpResponse方式*/
    /*public static void main(String[] args) {
        try {
            String url = "http://10.129.104.167:8510/api/demo/media/list";
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpClient httpclient = HttpClients.createDefault();
            CloseableHttpResponse response = httpclient.execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                httpGet.abort();
                throw new RuntimeException("HttpClient,error status code :" + statusCode);
            }
            HttpEntity entity = response.getEntity();
            String result = null;
            if (entity != null) {
                result = EntityUtils.toString(entity, "utf-8");
                EntityUtils.consume(entity);
                response.close();
                System.out.println(result);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }*/


    /*HttpGet访问本地服务:HttpResponse方式*/
    /*public static void main(String[] args) {
        HttpGet get = new HttpGet("http://10.129.104.167:8510/api/demo/media/list");
        HttpClient client = HttpClients.createDefault();
        HttpResponse response = null;
        try {
            response = client.execute(get);
            HttpEntity entity = response.getEntity();
            String result = null;
            if (entity != null) {
                result = EntityUtils.toString(entity, "utf-8");
                EntityUtils.consume(entity);
                System.out.println(result);
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }*/

    /*HttpGet*/
    /*public void httpGet() {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            // 创建httpget.
            HttpGet httpget = new HttpGet("http://www.baidu.com/");
            System.out.println("executing request " + httpget.getURI()); // 执行get请求.
            CloseableHttpResponse response = httpclient.execute(httpget);
            try {
                // 获取响应实体
                HttpEntity entity = response.getEntity(); // 打印响应状态
                System.out.println(response.getStatusLine());
                if (entity != null) {
                    // 打印响应内容长度
                    System.out.println("Response content length: " + entity.getContentLength());
                    // 打印响应内容
                    System.out.println("Response content: " + EntityUtils.toString(entity));
                }
            } finally {
                response.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }*/


    /*HttpPost访问本地服务*/
    /*public static String httpPost(String host, int port, byte[] buf) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse httpResponse = null;
        BufferedReader reader = null;
        StringBuffer response = new StringBuffer();
        try {
            String url = "http://" + host + ":" + port;
            HttpPost httpPost = new HttpPost(url);
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(6000).setConnectTimeout(6000).build();//设置请求和传输超时时间
            httpPost.setConfig(requestConfig);
            httpPost.addHeader("User-Agent", "Mozilla/5.0");
            ByteArrayEntity entity = new ByteArrayEntity(buf);
            httpPost.setEntity(entity);
            httpResponse = httpClient.execute(httpPost);
            reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
            String inputLine;
            while ((inputLine = reader.readLine()) != null) {
                response.append(inputLine);
            }
        } catch (Exception var) {
            var.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (httpResponse != null) {
                    httpResponse.close();
                }
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return response.toString();
    }*/



}
