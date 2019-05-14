package beans.ioc.factory;

import beans.ioc.WyattBeanDefinition;

/**
 * bean工厂
 *
 * @author yanmingkun
 * @date 2018-11-26 13:43
 */
public interface WyattBeanFactory {
    /**
     * @param bean
     * @throws Exception
     */
    void registerBeanDefinition(String name, WyattBeanDefinition bean) throws Exception;

    /**
     * @param name
     * @return
     * @throws Exception
     */
    Object getBean(String name) throws Exception;
}
