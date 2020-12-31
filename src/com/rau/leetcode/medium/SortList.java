package com.rau.leetcode.medium;

public class SortList {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        ListNode res = sortList(head);
        pirint(res);//1->2->3->4->
        System.out.println("-----------------");
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode prev=null,slow=head,fast = head;
        while (fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;//break

        return mergeSort(sortList(head), sortList(slow));
    }

    private static ListNode mergeSort(ListNode head1, ListNode head2) {
        ListNode start = new ListNode(0),pointer = start;

        while (head1!=null && head2!=null){
            if (head1.val<=head2.val){
                pointer.next = head1;
                head1 = head1.next;
            }else {
                pointer.next = head2;
                head2 = head2.next;
            }
            pointer = pointer.next;
        }
        while (head1!=null){//this can execute max 1
            pointer.next = head1;
            head1 = head1.next;
            pointer = pointer.next;
        }

        while (head2!=null){//this can execute max 1
            pointer.next = head2;
            head2 = head2.next;
            pointer = pointer.next;
        }

        return start.next;
    }

    private static void pirint(ListNode res) {
        ListNode curr = res;
        while (curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
        System.out.println();
    }
}
