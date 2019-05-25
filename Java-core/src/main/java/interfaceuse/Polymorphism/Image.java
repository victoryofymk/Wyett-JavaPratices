package interfaceuse.Polymorphism;

import org.springframework.util.StringUtils;

import interfaceuse.Constant;
import interfaceuse.ShareListener;

/**
 * @author yanmingkun
 * @date 2019-05-23 15:55
 */
public class Image extends ShareItem {
    String imagePath;

    public Image(String imagePath) {

        super(Constant.TYPE_IMAGE);
        this.imagePath = !StringUtils.isEmpty(imagePath) ? imagePath : "default";

    }

    @Override
    public void doShare(ShareListener listener) {
        // do share
    }
}
