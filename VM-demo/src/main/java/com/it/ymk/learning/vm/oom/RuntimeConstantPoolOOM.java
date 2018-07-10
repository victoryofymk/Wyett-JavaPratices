package com.it.ymk.learning.vm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yanmingkun
 * @date 2018-06-19 11:26
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
