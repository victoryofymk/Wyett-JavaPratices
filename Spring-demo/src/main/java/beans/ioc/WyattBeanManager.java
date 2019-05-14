package beans.ioc;

import beans.ioc.factory.WyattBeanFactory;

/**
 * @author yanmingkun
 * @date 2018-11-26 13:50
 */
public class WyattBeanManager {
    private WyattBeanFactory wyattBeanFactory;

    public void init(String packageName) throws Exception {

    }

    public Object getBean(String name) throws Exception {
        return wyattBeanFactory.getBean(name);
    }
}
