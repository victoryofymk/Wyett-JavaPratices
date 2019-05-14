package beans.ioc.io;


import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author yanmingkun
 * @date 2018-11-26 15:15
 */
public class WyattResourceUrl implements WyattResource {
    /**
     * 类库URL
     */
    private final URL url;

    /**
     * 需要一个类库URL
     */
    public WyattResourceUrl(URL url) {
        this.url = url;
    }

    /**
     * 从URL中获取输入流
     */
    public InputStream getInputstream() throws Exception {
        URLConnection urlConnection = url.openConnection();
        urlConnection.connect();
        return urlConnection.getInputStream();

    }

}
