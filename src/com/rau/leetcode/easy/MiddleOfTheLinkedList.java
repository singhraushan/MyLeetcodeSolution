package com.rau.leetcode.easy;


import java.util.ArrayList;
import java.util.List;

public class MiddleOfTheLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println("middleNode "+middleNode(head).val);//[3]

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println("middleNode "+middleNode(head).val);//[4]
    }

    public static ListNode middleNode(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode curr = head;
        while (curr!=null){
            list.add(curr);
            curr = curr.next;
        }
        return list.get(list.size()/2);
    }

}
