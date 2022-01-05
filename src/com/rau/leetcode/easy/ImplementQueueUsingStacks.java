package com.rau.leetcode.easy;

import java.util.Stack;

public class ImplementQueueUsingStacks {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println("peek:"+myQueue.peek()); // return 1
        System.out.println("pop:"+myQueue.pop()); // return 1, queue is [2]
        System.out.println("empty:"+myQueue.empty()); // return false
        myQueue.push(3);//queue is: [2,3] (leftmost is front of the queue)
        System.out.println("peek:"+myQueue.peek()); // return 2
        System.out.println("pop:"+myQueue.pop()); // return 2, queue is [3]
    }
}
class MyQueue {
    private Stack<Integer> push;
    private Stack<Integer> pop;
    public MyQueue() {
        push = new Stack<>();
        pop = new Stack<>();
    }

    public void push(int x) {
        push.push(x);
    }

    public int pop() {//remove also
        load();
        return pop.pop();
    }

    public int peek() {
        load();
        return pop.peek();
    }

    public boolean empty() {
        return pop.size()+push.size()==0;
    }

    private void load() {
        if(pop.isEmpty()){
            while (!push.isEmpty()){
                pop.add(push.pop());
            }
        }
    }
}

