package com.rau.leetcode.easy;

public class DeleteNodeInALinkedList {

//237:Delete Node in a Linked List
    public static void main(String[] args) {

        ListNode listNode0 = new ListNode(4);
        ListNode listNode1 = new ListNode(5);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(9);
        listNode0.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        deleteNode(listNode0, listNode1);
        ListNode curr= listNode0;
        while (curr!=null){
            System.out.println(curr.val);
            curr= curr.next;
        }
    }
    public static void deleteNode(ListNode head, ListNode node) {
        ListNode curr= head, next;
        while (curr!=null){
            next = curr.next;
            if(next==node){
                ListNode temp = next.next;
                curr.next=temp;
                break;
            }
            curr= next;
        }
    }
}
