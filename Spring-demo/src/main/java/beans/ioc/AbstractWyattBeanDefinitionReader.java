package beans.ioc;

import beans.ioc.io.WyattResourceLoader;
import org.springframework.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yanmingkun
 * @date 2018-11-26 15:12
 */
public abstract class AbstractWyattBeanDefinitionReader implements WyattBeanDefinitionReader {
    /**
     * 注册bean容器
     */
    private Map<String, WyattBeanDefinition> registry;

    /**
     * 资源加载器
     */
    private WyattResourceLoader resourceLoader;

    /**
     * 构造器器必须有一个资源加载器， 默认插件创建一个map容器
     *
     * @param resourceLoader 资源加载器
     */
    protected AbstractWyattBeanDefinitionReader(WyattResourceLoader resourceLoader) {
        this.registry = new HashMap<String, WyattBeanDefinition>();
        this.resourceLoader = resourceLoader;
    }

    /**
     * 获取容器
     */
    public Map<String, WyattBeanDefinition> getRegistry() {
        return registry;
    }

    /**
     * 获取资源加载器
     */
    public WyattResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
