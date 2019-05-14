package beans.ioc.io;

import java.net.URL;

/**
 * @author yanmingkun
 * @date 2018-11-26 15:33
 */
public class WyattResourceLoader {
    /**
     * 给定一个位置， 使用累加器的资源加载URL，并创建一个“资源URL”对象，便于获取输入流
     */
    public WyattResourceUrl getResource(String location) {
        URL url = this.getClass().getClassLoader().getResource(location);
        return new WyattResourceUrl(url);
    }
}
