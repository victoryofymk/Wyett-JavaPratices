package reflect.proxy.cglib;

/**
 * System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\class");  --该设置用于输出cglib动态代理产生的类
 * System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");   --该设置用于输出jdk动态代理产生的类
 * ---------------------
 *
 * @author yanmingkun
 * @date 2018-12-25 10:42
 */
public class HelloConcrete {
    public void sayHello() {
        System.out.println("HelloConcrete: ");
    }
}
