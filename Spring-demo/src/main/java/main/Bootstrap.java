package main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yanmingkun
 * @date 2018-08-17 18:08
 */
public class Bootstrap {
    private static final Logger LOGGER = LoggerFactory.getLogger(Bootstrap.class);

    private static ApplicationContext context;

    public static void main(String[] args) {
        System.out.println("初始化文件处理系统**************starting********************");
        try {
            context = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
            System.out.println("初始化classpath*:applicationContext.xml结束，获取context=" + context);
//            BeanLocator.setApplicationContext(context);
//            new InitContext().init();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        System.out.println("初始化文件处理系统***************ending**********************");
    }
}
