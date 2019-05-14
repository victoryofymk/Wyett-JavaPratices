package reflect.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * jdk动态代理
 *
 * @author yanmingkun
 * @date 2018-12-25 10:23
 */
public class LogInvocationHandler implements InvocationHandler {
    private UserService userService;

    public LogInvocationHandler(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("sayHello".equals(method.getName())) {
            System.out.println("You said: " + Arrays.toString(args));
        }
        return method.invoke(userService, args);
    }

    public static void main(String[] args) {
        UserService userService = (UserService) Proxy.newProxyInstance(
                LogInvocationHandler.class.getClassLoader(), // 1. 类加载器
                new Class<?>[]{UserService.class}, // 2. 代理需要实现的接口，可以有多个
                new LogInvocationHandler(new UserServiceImpl()));// 3. 方法调用的实际处理者

        userService.save();
    }
}
