package interfaceuse.Polymorphism;

import interfaceuse.ShareListener;

/**
 *
 * @author yanmingkun
 * @date 2019-05-23 15:53
 */
public abstract class ShareItem {
    int type;

    public ShareItem(int type) {
        this.type = type;
    }

    public ShareItem() {

    }

    public abstract void doShare(ShareListener listener);

}
