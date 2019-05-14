package beans.proxy;


/**
 * @author yanmingkun
 * @date 2019-03-12 10:35
 */
public class DaoImpl implements Dao {
    @Override
    public void insert() {
        System.out.println("开始:insert");
    }

    @Override
    public void delete() {
        System.out.println("开始:delete");
    }

    @Override
    public void update() {
        System.out.println("开始:update");
    }
}
