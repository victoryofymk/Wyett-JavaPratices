package beans.ioc;
/**
 * @author yanmingkun
 * @date 2018-11-26 15:43
 */
public class HelloWorld {
    private String text;

    void say() {
        System.out.println(text);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
