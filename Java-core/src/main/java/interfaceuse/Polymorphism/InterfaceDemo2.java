package interfaceuse.Polymorphism;

import java.util.HashMap;
import java.util.Map;

import interfaceuse.Constant;
import interfaceuse.ShareListener;

/**
 * 利用多态，每种业务单独处理，在接口不再做任何业务判断。把 ShareItem抽象出来，作为基础类，然后针对每种业务各自实现其子类
 * （注意：上面每个子类的构造方法还对每个字段做了空值处理，为空的话，赋值 default，这样如果用户传了空值，在调试就会发现问题。）
 *
 * 实现了多态后，分享接口的就简洁多了
 * 嘻嘻，怎样，内部接口一个 ifelse都没了，是不是很酷~ 如果这个分享功能是自己App里面的功能，不是第三方SDK，到这里已经没问题了。但如果是第三方分享SDK的功能的话，这样暴露给用户的类增加了很多（各 ShareItem的子类，相当于把 ifelse抛给用户了），用户的接入成本提高，违背了“迪米特原则”了。
 *
 * 处理这种情况也很简单，再次封装一层即可。把 ShareItem的子类的访问权限降低，在暴露给用户的主类里定义几个方法，在内部帮助用户创建具体的分享类型，这样用户就无需知道具体的类了：
 * 或者有人会说，这样用户也需额外了解多几个方法。我个人觉得让用户了解多几个方法好过了解多几个类，而已方法名一看就能知道意图，成本还是挺小，是可以接受的。
 *
 * 其实这种情况，更多人想到的是使用工厂模式。嗯，工厂模式能解决这个问题（其实也需要用户额外了解多几个 type类型），但工厂模式难免又引入分支，我们可以用 Map消除分支。
 * 
 * @author yanmingkun
 * @date 2019-05-23 16:01
 */
public class InterfaceDemo2 {
    private Map<Integer, Class<? extends ShareItem>> map = new HashMap<>();

    private void init() {
        map.put(Constant.TYPE_LINK, Link.class);
        map.put(Constant.TYPE_IMAGE, Image.class);
    }

    public void share(ShareItem item, ShareListener listener) {
        if (item == null) {
            if (listener != null) {
                listener.onCallback(ShareListener.STATE_FAIL, "ShareItem 不能为 null");
            }
            return;
        }
        if (listener == null) {
            listener = new ShareListener() {
                @Override
                public void onCallback(int state, String msg) {
                    //Log.i("DEBUG", "ShareListener is null");
                }
            };

        }
        shareImpl(item, listener);

    }

    private void shareImpl(ShareItem item, ShareListener listener) {
        item.doShare(listener);

    }

    public ShareItem createLinkShareItem(String link, String title, String content) {
        return new Link(link, title, content);

    }

    public ShareItem createImageShareItem(String ImagePath) {
        return new Image(ImagePath);
    }

    public ShareItem createShareItem(int type) {
        try {
            Class<? extends ShareItem> shareItemClass = map.get(type);
            return shareItemClass.newInstance();

        } catch (Exception e) {
            return new DefaultShareItem();
            // 返回默认实现，不要返回null

        }

    }

    public static void main(String[] args) {
        InterfaceDemo2 interfaceDemo2 = new InterfaceDemo2();
        interfaceDemo2.share(new Link("", "", ""), new ShareListener() {
            @Override
            public void onCallback(int state, String msg) {

            }
        });
    }
}
