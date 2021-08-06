package com.rau.leetcode.hard;

public class ReverseNodesInKGroup {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode curr = reverseKGroup(head,1);

        while (curr!=null){
            System.out.print(curr.val+"->");
            curr = curr.next;
        }

    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head,prev=null;
        int count=1;
        while (curr!=null) {
            ListNode next = curr.next;
            if (count % k == 0) {

                curr.next = null;
                if (prev == null) {
                    ListNode reverseHead = reverse(head);
                    head.next = next;
                    prev = head;
                    head = reverseHead;
                } else {
                    ListNode reverseHead = reverse(prev.next);
                    ListNode tempPrev = prev.next;
                    if(tempPrev!=null) tempPrev.next= next;
                    prev.next = reverseHead;
                    prev = tempPrev;
                }
            }
            curr = next;
            count++;
        }
        return head;
    }

    private static ListNode reverse(ListNode head) {
        ListNode curr = head,prev=null;
        while (curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
