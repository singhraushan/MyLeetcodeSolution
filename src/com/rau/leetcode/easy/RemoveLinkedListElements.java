package com.rau.leetcode.easy;

public class RemoveLinkedListElements {
    public static void main(String[] args) {

        /*ListNode head= new ListNode(1);
        head.next= new ListNode(2);
        head.next.next= new ListNode(6);
        head.next.next.next= new ListNode(3);
        head.next.next.next.next= new ListNode(4);
        head.next.next.next.next.next= new ListNode(5);
        head.next.next.next.next.next.next= new ListNode(6);

        ListNode result = removeElements( head, 6);*/

        ListNode head= new ListNode(1);
        head.next= new ListNode(2);

        ListNode result = removeElements( head, 1);
        while (result!=null){
            System.out.print(result.val+"->");
            result = result.next;
        }
        System.out.println("End!");
    }
    public static ListNode removeElements(ListNode head, int val) {
        ListNode prev =null,curr = head, next, resHead=null;

        while (curr!=null){
            next = curr.next;
            if(curr.val==val){
                if(prev!=null)
                    prev.next=null;
            }else {
                if(resHead==null)
                    resHead = curr;
                if(prev!=null)
                    prev.next=curr;

                prev = curr;
            }
            curr = next;
        }
        return resHead;
    }
}
