package org.example;

public class ThreadLocalLearn {
    public ThreadLocal<String> stringThreadLocal;

    public static void main(String[] args) {
        ThreadLocalLearn threadLocalLearn = new ThreadLocalLearn();

        threadLocalLearn.stringThreadLocal = ThreadLocal.withInitial(()->"这是ThreadLocal中所装的文字");
        ThreadLocal<String> threadLocal = threadLocalLearn.stringThreadLocal;
        System.out.println(threadLocal.get());


    }
}
