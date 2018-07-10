package com.it.ymk.learning.vm.oom;

/**
 * @author yanmingkun
 * @date 2018-06-19 10:04
 */
public class JavaVMStackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("Stack length:" + oom.stackLength);
            throw e;
        }
    }
}
