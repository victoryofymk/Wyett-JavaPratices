package com.it.ymk.learning.vm.oom;

/**
 * @author yanmingkun
 * @date 2018-06-19 10:04
 */
public class JavaVMStackOOM {

    public void dontStop() {
        while(true){

        }
    }

    public void stackLeakByThread(){
        while(true){
            Thread thread=new Thread(new Runnable() {
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();

    }
}
