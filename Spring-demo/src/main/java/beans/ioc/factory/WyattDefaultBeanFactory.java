package beans.ioc.factory;

import beans.ioc.WyattBeanDefinition;

import java.util.HashMap;

/**
 * @author yanmingkun
 * @date 2018-11-26 13:45
 */
public abstract class WyattDefaultBeanFactory implements WyattBeanFactory {
    /**
     * 容器
     */
    private HashMap<String, WyattBeanDefinition> map = new HashMap<>();

    /**
     * 根据bean的名称获取bean， 如果没有，则抛出异常 如果有， 则从bean定义对象获取bean实例
     */
    @Override
    public Object getBean(String name) throws Exception {
        WyattBeanDefinition beandefinition = map.get(name);
        if (beandefinition == null) {
            throw new IllegalArgumentException("No bean named " + name + " is defined");
        }
        Object bean = beandefinition.getBean();
        if (bean == null) {
            bean = doCreate(beandefinition);
        }
        return bean;
    }

    /**
     * 注册 bean定义 的抽象方法实现，这是一个模板方法， 调用子类方法doCreate，
     */
    @Override
    public void registerBeanDefinition(String name, WyattBeanDefinition beandefinition) throws Exception {
        Object bean = doCreate(beandefinition);
        beandefinition.setBean(bean);
        map.put(name, beandefinition);
    }

    /**
     * 减少一个bean
     */
    abstract Object doCreate(WyattBeanDefinition beandefinition) throws Exception;
}
