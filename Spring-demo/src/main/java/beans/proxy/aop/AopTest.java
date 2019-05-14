package beans.proxy.aop;

import beans.proxy.Dao;
import beans.proxy.DaoNoImpl;
import org.junit.Test;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yanmingkun
 * @date 2019-03-12 10:52
 */
public class AopTest {
    @Test
    @SuppressWarnings("resource")
    public void testAop() {
        /**
         *
         */
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/yanmingkun/Downloads/");
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        ApplicationContext ac = new ClassPathXmlApplicationContext("aop.xml");

        Dao dao = (Dao) ac.getBean("daoImpl");
        dao.insert();
        System.out.println("----------分割线----------");
        dao.delete();
        System.out.println("----------分割线----------");
        dao.update();

        //cglib
        /*DaoNoImpl dao1 = (DaoNoImpl) ac.getBean("daoNoImpl");
        dao1.insert();
        System.out.println("----------分割线----------");
        dao1.delete();
        System.out.println("----------分割线----------");
        dao1.update();*/
    }
}
