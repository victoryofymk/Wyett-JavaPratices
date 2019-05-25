package interfaceuse;

/**
 * @author yanmingkun
 * @date 2019-05-23 15:36
 */
public interface ShareListener {
    int STATE_SUCC = 0;

    int STATE_FAIL = 1;

    void onCallback(int state, String msg);
}
