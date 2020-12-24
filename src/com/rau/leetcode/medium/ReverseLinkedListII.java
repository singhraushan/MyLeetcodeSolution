package com.rau.leetcode.medium;

public class ReverseLinkedListII {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
	    node.next = node2;
	    node2.next = node3;
	    node3.next = node4;
	    node4.next = node5;
        ListNode curr = reverseBetween(node, 2, 4);
        while(curr != null) {
            System.out.print(curr.val+"->");
            curr = curr.next;
        }
    }
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode curr=head, prev = null;
        int currPos = 1;
        while (currPos++ != m) {
            ListNode next = curr.next;
            prev = curr;
            curr = next;
        }
        if (prev != null){
            prev.next = reverse(curr, n-m);
        } else {
            return reverse(curr, n-m);
        }
        return head;
    }
    private static ListNode  reverse(ListNode currHead, int len)  {
        ListNode curr=currHead, prev=null;
        while (len-- > -1) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        currHead.next = curr;
        return prev;
    }
}
