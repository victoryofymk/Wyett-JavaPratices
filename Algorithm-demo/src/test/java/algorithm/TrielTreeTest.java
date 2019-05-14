package algorithm;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * @author yanmingkun
 * @date 2018-11-15 16:22
 */
public class TrielTreeTest {
    public static void main(String[] args) {
        TrielTree trielTree = new TrielTree();
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://randomuser.me/api/?results=5000&inc=gender");
//        HttpGet httpGet = new HttpGet("https://randomuser.me/api/?results=5000&inc=gender,email,phone,cell,nat");

        CloseableHttpResponse closeableHttpResponse;
        try {
            closeableHttpResponse = closeableHttpClient.execute(httpGet);
            if (closeableHttpResponse.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
                System.out.println(content);
                List<HashMap<String, String>> list = JSON.parseObject(JSON.parseObject(content).get("results").toString(), new TypeReference<List<HashMap<String, String>>>() {
                });
                trielTree.insertMap(list, "gender");
                System.out.println(trielTree.searchMapKey("fem"));
            }
            if (closeableHttpResponse != null) {
                closeableHttpResponse.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                closeableHttpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
