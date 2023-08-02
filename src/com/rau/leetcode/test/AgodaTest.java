package com.rau.leetcode.test;

public class AgodaTest implements Runnable{
    //AtomicInteger a = new AtomicInteger();
    int x=0;
    public void run(){
        f();
    }
    public void f() {
        for (int i = 1; i <= 5; i++){
            ++x;
            //a.incrementAndGet();
        }
        System.out.println("f:val:::::::; "+x);
    }

    public static void main(String[] args) throws Exception{
        AgodaTest a= new AgodaTest();

        System.out.println("main start:val:::::::; "+a.x);
        for (int i = 1; i <= 5; i++){
            new Thread(a).start();
            //Thread.sleep(1);
            //System.out.println("val:::::::; "+a.x);
        }
        a.f();
        System.out.println("main end:val:::::::; "+a.x);
    }
}
