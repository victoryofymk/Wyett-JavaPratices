package com.it.ymk.learning.vm.gc;

/**
 * GC日志分析实例,-XX:+UseParNewGC  -XX:+UseConcMarkSweepGC
 *
 * @author yanmingkun
 * @date 2018-12-05 11:12
 */
public class GcAnalysis {
    public static void main(String[] args) {
        byte[] b1 = new byte[4 * 1024 * 1024];
        byte[] b2 = new byte[4 * 1024 * 1024];
        byte[] b3 = new byte[4 * 1024 * 1024];
        byte[] b4 = new byte[4 * 1024 * 1024];
    }
}
