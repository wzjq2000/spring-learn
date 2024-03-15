package org.example;

public class AsyncStackTraceLearn {
    public static void main(String args[]) throws InterruptedException {
//        Thread inner1 = new Thread(() -> {
//            Thread inner2 = new Thread(() -> {
//                System.out.println("hello");
//            });
//            inner2.setName("inner2");
//            inner2.start();
//            try {
//                inner2.join();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        });
//        inner1.setName("inner1");
//        inner1.start();
//        inner1.join();;

        Object arr = new int[]{1, 2, 3, 4, 5}; // 假设我们不知道arr的具体类型

        System.out.println(arr instanceof int[]);
    }
}
