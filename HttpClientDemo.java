import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HttpClientDemo {
    public static  void main(String args[])
    {
        try {
            InputStream is ;
            BufferedReader br ;
            HttpGet httpGet = new HttpGet("http://127.0.0.1:8801/");
            CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse responseInfo=httpClient.execute(httpGet);
            is = responseInfo.getEntity().getContent();
            // 封装输入流is，并指定字符集
            br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            // 存放数据
            StringBuffer sbf = new StringBuffer();
            String temp = null;
            while ((temp = br.readLine()) != null) {
                sbf.append(temp);
            }
            System.out.println(sbf.toString());
        } catch (IOException e) {
            System.out.println("访问失败");
        }
    }


}
