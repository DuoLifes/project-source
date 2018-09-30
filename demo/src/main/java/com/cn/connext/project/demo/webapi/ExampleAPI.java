package com.cn.connext.project.demo.webapi;

import com.alibaba.fastjson.JSONObject;
import com.cn.connext.project.framework.JSON;
import com.cn.connext.project.framework.annotation.WebAPI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebAPI("api/demo/example")
public class ExampleAPI {

    private static final Logger logger = LoggerFactory.getLogger(ExampleAPI.class);

    /*多态实现*/
//    public static void main(String[] args) {
//        Tea tea=new Tea();
//        tea.drinkTea();
//        tea.drink();
//        tea.drink(1);
//        Drink drink=new Tea();
//        drink.drink();
//        Drink drink1=new Coffee();
//        drink1.drink();
//    }

//    public static void main(String[] args) {
//        String a="zbcdefg";
//        System.out.println(a.length());
//
//        String [] test={"abc","efg","hij"};
//        System.out.println(test.length);
//
//        String demo="test1";
//        demo="test2";
//        StringBuffer demo2=new StringBuffer("abcdefg");
//        demo2.indexOf("cd");
//        System.out.println(demo2.indexOf("cd"));
//        List<Tea>list=new ArrayList<>();
//        Map<String,Object> map=new HashMap<>();
//        Hashtable<String,Tea> hashtable=new Hashtable<>();
//        Integer cc=2;
//        int b=4;
//        Object object1=b;
//        Object object=a;
//        byte aa=11;
//        System.out.println("aa=="+aa);
//    }

        /*判断*/
//    public static void main(String[] args) {
//        String a="b";
//        String test="a".equals(a)?test="yes":"no";
//        System.out.println(test);
//    }


    /*正则表达式验证字符串*/
//    public static void main(String[] args) {
//        Pattern pattern = Pattern.compile("^[a-zA-Z]\\w{5,17}$");
//        String test="abcdef";
//        Matcher matcher = pattern.matcher(test);
//        System.out.println(matcher.find());
//        try {
//            String aa=matcher.group();
//            System.out.println("aa=="+aa);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


//    public static void main(String[] args) {
//        //圆周率
//        //System.out.println(Math.PI);
//        //计算当前时间的半小时前
//        SimpleDateFormat sfm1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.MINUTE, -30);
//        String date = sfm1.format(calendar.getTime());
//        System.out.println(date);
//    }

    /*HttpGet访问本地服务*/
//    public static void main(String[] args) {
//        try {
//            String url = "http://10.129.104.167:8510/api/demo/media/list";
//            HttpGet httpGet = new HttpGet(url);
//            CloseableHttpClient httpclient = HttpClients.createDefault();
//            CloseableHttpResponse response = httpclient.execute(httpGet);
//            int statusCode = response.getStatusLine().getStatusCode();
//            if (statusCode != 200) {
//                httpGet.abort();
//                throw new RuntimeException("HttpClient,error status code :" + statusCode);
//            }
//            HttpEntity entity = response.getEntity();
//            String result = null;
//            if (entity != null) {
//                result = EntityUtils.toString(entity, "utf-8");
//                EntityUtils.consume(entity);
//                response.close();
//                System.out.println(result);
//            }
//        }catch (Exception e){
//            System.out.println(e);
//        }
//    }


    /*HttpGet访问本地服务*/
//    public static void main(String[] args) {
//        HttpGet get = new HttpGet("http://10.129.104.167:8510/api/demo/media/list");
//        HttpClient client = HttpClients.createDefault();
//        HttpResponse response = null;
//        try {
//            response = client.execute(get);
//            HttpEntity entity = response.getEntity();
//            String result = null;
//            if (entity != null) {
//                result = EntityUtils.toString(entity, "utf-8");
//                EntityUtils.consume(entity);
//                System.out.println(result);
//            }
//        } catch (IOException e1) {
//            e1.printStackTrace();
//        }
//    }



    /*public static String httpPost(String host, int port, byte[] buf) { CloseableHttpClient httpClient = HttpClients.createDefault(); CloseableHttpResponse httpResponse = null; BufferedReader reader = null; StringBuffer response = new StringBuffer(); try { String url = "http://" + host + ":" + port; HttpPost httpPost = new HttpPost(url); RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(6000).setConnectTimeout(6000).build();//设置请求和传输超时时间 httpPost.setConfig(requestConfig); httpPost.addHeader("User-Agent", "Mozilla/5.0"); ByteArrayEntity entity = new ByteArrayEntity(buf); httpPost.setEntity(entity); httpResponse = httpClient.execute(httpPost); reader = new BufferedReader(new InputStreamReader( httpResponse.getEntity().getContent())); String inputLine; while ((inputLine = reader.readLine()) != null) { response.append(inputLine); } }catch (Exception var){ var.printStackTrace(); }finally { if(reader != null){ reader.close(); } if(httpResponse != null){ httpResponse.close(); } httpClient.close(); } return response.toString(); }
    */

    /*public void httpGet() { CloseableHttpClient httpclient = HttpClients.createDefault(); try { // 创建httpget. HttpGet httpget = new HttpGet("http://www.baidu.com/"); System.out.println("executing request " + httpget.getURI()); // 执行get请求. CloseableHttpResponse response = httpclient.execute(httpget); try { // 获取响应实体 HttpEntity entity = response.getEntity(); // 打印响应状态 System.out.println(response.getStatusLine()); if (entity != null) { // 打印响应内容长度 System.out.println("Response content length: " + entity.getContentLength()); // 打印响应内容 System.out.println("Response content: " + EntityUtils.toString(entity)); } } finally { response.close(); } } catch (ClientProtocolException e) { e.printStackTrace(); } catch (ParseException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); } finally { // 关闭连接,释放资源 try { httpclient.close(); } catch (IOException e) { e.printStackTrace(); } } }
    */


    /*格式化字符串的作用*/
    public static void main(String[] args) {
//       String a= MessageFormat.format("{0}''s Grade is A.", "abcdef");
//        System.out.println(a);
            String a= "aaa";
            String b= "bb";
            String c= "c";
            StringBuilder sb = new StringBuilder();	sb.append(a).append(b).append(c);
            System.out.println(MessageFormat.format(" {0} {1} {2} {3}", a, b,"",sb));
            System.out.println(MessageFormat.format(" ''{0}'' '{1}' {2} {3}", a, b,"",sb.toString()));
           }
}
