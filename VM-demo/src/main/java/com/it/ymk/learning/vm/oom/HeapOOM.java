package com.it.ymk.learning.vm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yanmingkun
 * @date 2018-06-18 23:18
 */
public class HeapOOM {
    static class OOMObject{

    }

    public static void main(String[] args) {
        List<OOMObject> list=new ArrayList<OOMObject>();

        while(true){
            list.add(new OOMObject());
        }

    }
}
