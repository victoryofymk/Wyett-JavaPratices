package interfaceuse.Polymorphism;

import org.springframework.util.StringUtils;

import interfaceuse.Constant;
import interfaceuse.ShareListener;

/**
 * @author yanmingkun
 * @date 2019-05-23 15:55
 */
public class Link extends ShareItem {
    String title;
    String content;
    String link;

    public Link(String link, String title, String content) {

        super(Constant.TYPE_LINK);
        this.link = !StringUtils.isEmpty(link) ? link : "default";
        this.title = !StringUtils.isEmpty(title) ? title : "default";
        this.content = !StringUtils.isEmpty(content) ? content : "default";

    }

    @Override
    public void doShare(ShareListener listener) {
        // do share
    }
}
