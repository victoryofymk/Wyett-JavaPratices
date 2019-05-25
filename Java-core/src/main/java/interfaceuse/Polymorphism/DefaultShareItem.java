package interfaceuse.Polymorphism;

import interfaceuse.ShareListener;

/**
 * @author yanmingkun
 * @date 2019-05-23 16:15
 */
public class DefaultShareItem extends ShareItem {
    public DefaultShareItem(int type) {
        super(type);
    }

    public DefaultShareItem() {
        super();
    }

    @Override
    public void doShare(ShareListener listener) {

    }
}
