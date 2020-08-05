package com.rau.leetcode.easy;

public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = new ListNode(2);
        l1.next.next.next.next.next = new ListNode(2);
        ListNode result = deleteDuplicates(l1);
        while (result!=null){
            System.out.print(result.val+"->");
            result = result.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode curr=head;
        while (curr!=null){
            ListNode next =curr.next;
            if(next!= null){
                if(curr.val==next.val){
                    curr.next = next.next;
                    if(next.next!=null && next.next.val==curr.val){
                        //not increment
                    }else {
                        //increment
                        curr = curr.next;
                    }
                }else {
                    curr = curr.next;
                }
            }else curr=null;
        }
        return head;
    }
}
