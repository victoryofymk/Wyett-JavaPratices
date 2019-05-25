package interfaceuse.Polymorphism;

import interfaceuse.Constant;
import interfaceuse.ShareListener;

/**
 * @author yanmingkun
 * @date 2019-05-23 16:22
 */
public class ShareItemFactory {
    //使用 getShape 方法获取形状类型的对象
    public static ShareItem getShape(int shapeType) {
        if (shapeType == 0) {
            return null;
        }
        if (shapeType == (Constant.TYPE_TEXT)) {
            return new Link("", "", "");
        }
        else if (shapeType == (Constant.TYPE_IMAGE)) {
            return new Image("");
        }
        return null;
    }

    public static void main(String[] args) {
        ShareItemFactory.getShape(1).doShare(new ShareListener() {
            @Override
            public void onCallback(int state, String msg) {

            }
        });
    }
}
