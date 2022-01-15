package com.rau.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println("removeNthFromEnd "+removeNthFromEnd(head,2));//[1,2,3,5]

         head = new ListNode(1);
        System.out.println("removeNthFromEnd "+removeNthFromEnd(head,1));//[]

        head = new ListNode(1);
        head.next = new ListNode(2);
        System.out.println("removeNthFromEnd "+removeNthFromEnd(head,1));//[1]
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList<>();
        ListNode curr=head,prev=null;
        while (curr!=null){
            list.add(curr);
            curr = curr.next;
        }
        int indexToBeRemoved = list.size()-n;
        prev = indexToBeRemoved-1>=0?list.get(indexToBeRemoved-1):null;
        if(prev==null)
            return list.get(0).next;
        prev.next = list.get(indexToBeRemoved).next;
        return head;
    }

}
