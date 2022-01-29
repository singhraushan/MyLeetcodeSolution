package com.rau.leetcode.easy;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);//1,2,2,1
        head.next=new ListNode(2);
        head.next.next=new ListNode(2);
        head.next.next.next=new ListNode(1);
        System.out.println(isPalindrome(head));//true

        head=new ListNode(1);//1,2,2,1
        head.next=new ListNode(2);
        System.out.println(isPalindrome(head));//false
    }
    public static boolean isPalindrome(ListNode head) {
        if(head.next==null){
            return true;
        }
        ListNode oneStepPointer=head,twoStepPointer=head.next.next;

        while (twoStepPointer!=null){
            oneStepPointer = oneStepPointer.next;
            if(twoStepPointer.next!=null)
                twoStepPointer=twoStepPointer.next.next;
            else
                break;//odd size
        }
        ListNode next = oneStepPointer.next;
        oneStepPointer.next = null;
        oneStepPointer = next;

        //reverse 2nd half
        ListNode prev=null,curr=oneStepPointer;
        while (curr!=null){
            next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        //prev is head of 2nd half

        ListNode left=head,right=prev;
        while (right!=null){
            if(left.val!=right.val)
                return false;
            left=left.next;
            right=right.next;
        }

        return true;
    }
}
