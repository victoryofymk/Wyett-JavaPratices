package beans.ioc;

import beans.ioc.factory.AutowireWyattBeanFactory;
import beans.ioc.factory.WyattBeanFactory;
import beans.ioc.io.WyattResourceLoader;
import beans.ioc.xml.XmlBeanDefinitionReader;
import org.junit.Test;

import java.util.Map;

/**
 * @author yanmingkun
 * @date 2018-11-26 15:44
 */
public class XmlBeanDefinitionReaderTest {
    @Test
    public void test() throws Exception {
        // 创建一个XML解析器，携带一个资源加载器
        XmlBeanDefinitionReader xml = new XmlBeanDefinitionReader(new WyattResourceLoader());
        // 解析该文件
        xml.readerXML("myspring.xml");

        // 创建一个自动注入bean工厂
        WyattBeanFactory beanfactory = new AutowireWyattBeanFactory();
        // 循环xml中的所有bean
        for (Map.Entry<String, WyattBeanDefinition> beanDefinitionEntry : xml.getRegistry().entrySet()) {
            // 将XML容器中的bean注册到bean工厂
            beanfactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }
        // 获取持有另一个bean对象的bean（也是从容器中取得的）
        ReferenceBean hello = (ReferenceBean) beanfactory.getBean("ReferenceBean");

        // 调用对象方法
        hello.say();


    }
}
