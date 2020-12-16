package com.rau.leetcode.medium;

public class RotateList {
    public static void main(String[] args) {
        /*ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        ListNode newHead= rotateRight(head, 4);*/

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode newHead= rotateRight(head, 2);
        ListNode curr = newHead;
        while (curr!=null){
            System.out.print(curr.val+"->");
            curr = curr.next;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null | k==0) {//size 0 || 1
            return head;
        }
        ListNode lastNode, currNode = head;
        int size, currCount = 1;

        //calculating total size & finding last node
        while (currNode != null) {
            if (currNode.next != null) {
                if (currNode.next.next != null) {
                    currCount += 2;
                    currNode = currNode.next.next;
                } else {
                    currCount += 1;
                    currNode = currNode.next;
                }
            }else {
                break;
            }
        }
        if (k%currCount==0){
            return head;
        }

        lastNode = currNode;
        size = currCount;

        int breakSize = currCount-k%size;
        currNode = head;
        //traversing to breaking Node, joining with head and getting new head
        while (--breakSize>0) currNode = currNode.next;
        ListNode newHead = currNode.next;
        currNode.next = null;
        lastNode.next = head;
        return newHead;
    }

}
