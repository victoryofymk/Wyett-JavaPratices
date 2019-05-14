package reflect.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * jdk动态代理，必须实现接口
 *
 * @author yanmingkun
 * @date 2018-12-20 15:24
 */
public class BeanFacoty {
    /**
     * 获取jdk动态代理对象
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> T getBean(T t) {
        T result = (T)
                Proxy.newProxyInstance(t.getClass().getClassLoader(), t.getClass().getInterfaces(), (proxy, method, args) -> {
                            System.out.println("开启事务...");
                            Object ret = method.invoke(t, args);
                            System.out.println("提交事务...");
                            return ret;
                        }
                );
        return result;
    }

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        UserService userService = new UserServiceImpl();

        UserService userServiceProxy = BeanFacoty.getBean(userService);

        userServiceProxy.save();
    }
}

