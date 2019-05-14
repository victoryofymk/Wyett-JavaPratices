package beans.ioc;

/**
 * @author yanmingkun
 * @date 2018-11-26 15:44
 */
public class ReferenceBean {
    private HelloWorld hello;

    public void say() {
        hello.say();
    }

    public void setHello(HelloWorld hello) {
        this.hello = hello;
    }
}
