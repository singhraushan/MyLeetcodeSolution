package com.rau.leetcode.test;

public class InterThreadCommunication {
    public static void main(String[] args) {

        Shared shared = new Shared();
        //producer
        new Thread(new Runnable() {
            @Override
            public void run() {
                int data = 0;
                while (true){
                    shared.produce(data++);
                }
            }
        }).start();

        //consumer
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (;true;){
                    shared.consume();
                }
            }
        }).start();

    }
}

class Shared {
    int data;
    boolean isProduced = false;

    synchronized void produce(int data){
        if(data==10) Thread.currentThread().stop();
        if(isProduced){
            try {
                wait();
            }catch (InterruptedException ex){

            }
        }
        System.out.println("producing: " + data);
        this.data = data;
        isProduced = true;

        notify();
    }

    synchronized int consume() {
        if(data==10) Thread.currentThread().stop();
        if (!isProduced){
            try {
                wait();
            }catch (InterruptedException ex){

            }
        }
        System.out.println("Consuming: " + data);
        isProduced = false;
        notify();
        return data;
    }
}

