package reflect.proxy.jdk;

/**
 * @author yanmingkun
 * @date 2018-12-20 15:36
 */
public class UserServiceImpl implements UserService {
    @Override
    public void save() {
        System.out.println("保存用户...");
    }
}
