package com.huihui.sms.tool;
/**
 * Created by bingone on 15/12/16.
 */


    import org.apache.http.HttpEntity;
    import org.apache.http.NameValuePair;
    import org.apache.http.client.entity.UrlEncodedFormEntity;
    import org.apache.http.client.methods.CloseableHttpResponse;
    import org.apache.http.client.methods.HttpPost;
    import org.apache.http.impl.client.CloseableHttpClient;
    import org.apache.http.impl.client.HttpClients;
    import org.apache.http.message.BasicNameValuePair;
    import org.apache.http.util.EntityUtils;
    import java.io.IOException;
    import java.net.URISyntaxException;

    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.List;
    import java.util.Map;

/**
 * 短信http接口的java代码调用示例
 * 基于Apache HttpClient 4.3
 *
 * @author songchao
 * @since 2015-04-03
 */

public class JavaSmsApi {

    //编码格式,发送编码格式统一用UTF-8
    private static String ENCODING = "UTF-8";
    private static String URI_TPL_SEND_SMS="https://sms.yunpian.com/v2/sms/batch_send.json";
    public  static String apikey = "60e77079f91e480ddfc614395c82b1c0";

    public  static String mobile = "15870077929,18434369411";

    public  static String text = "【太原工业学院】尊敬的老师，值此中秋佳节，太原工业学院党政办公室，祝您中秋快乐！";
    

    public static void main(String[] args) throws IOException, URISyntaxException {
        System.out.println(JavaSmsApi.batchSend(apikey, text, mobile));
    }

    public static String batchSend(String apikey,String text, String mobile) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("apikey", apikey);
        params.put("text", text);
        params.put("mobile", mobile);
        return post(URI_TPL_SEND_SMS, params);
    }

    public static String post(String url, Map<String, String> paramsMap) {
        CloseableHttpClient client = HttpClients.createDefault();
        String responseText = "";
        CloseableHttpResponse response = null;
        try {
            HttpPost method = new HttpPost(url);
            if (paramsMap != null) {
                List<NameValuePair> paramList = new ArrayList<NameValuePair>();
                for (Map.Entry<String, String> param : paramsMap.entrySet()) {
                    NameValuePair pair = new BasicNameValuePair(param.getKey(), param.getValue());
                    paramList.add(pair);
                }
                method.setEntity(new UrlEncodedFormEntity(paramList, ENCODING));
            }
            response = client.execute(method);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                responseText = EntityUtils.toString(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return responseText;
    }
}
