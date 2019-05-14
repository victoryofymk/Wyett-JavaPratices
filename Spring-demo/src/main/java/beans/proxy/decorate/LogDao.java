package beans.proxy.decorate;

import beans.proxy.Dao;

/**
 * 装饰器模式
 * <p>
 * 这种方式的优点为：
 * <p>
 * 透明，对调用方来说，它只知道Dao，而不知道加上了日志功能
 * 类不会无限膨胀，如果Dao的其它实现类需要输出日志，只需要向LogDao的构造函数中传入不同的Dao实现类即可
 * <p>
 * 不过这种方式同样有明显的缺点，缺点为：
 * <p>
 * 输出日志的逻辑还是无法复用
 * 输出日志的逻辑与代码有耦合，如果我要对delete()方法前后同样输出时间，需要修改LogDao
 *
 * @author yanmingkun
 * @date 2019-03-12 10:37
 */
public class LogDao implements Dao {
    private Dao dao;

    public LogDao(Dao dao) {
        this.dao = dao;
    }

    @Override
    public void insert() {
        System.out.println("insert()方法开始时间：" + System.currentTimeMillis());
        dao.insert();
        System.out.println("insert()方法结束时间：" + System.currentTimeMillis());
    }

    @Override
    public void delete() {
        dao.delete();
    }

    @Override
    public void update() {
        System.out.println("update()方法开始时间：" + System.currentTimeMillis());
        dao.update();
        System.out.println("update()方法结束时间：" + System.currentTimeMillis());
    }
}
