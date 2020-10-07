package com.rau.leetcode.hard;

public class MergeKSortedLists {
    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];

        ListNode l1 = new ListNode(1);
        ListNode l12 = new ListNode(4);
        ListNode l123 = new ListNode(5);
        l1.next=l12;
        l12.next=l123;
        lists[0]=l1;

        ListNode l2 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l223 = new ListNode(4);
        l2.next=l22;
        l22.next=l223;
        lists[1]=l2;

        ListNode l3 = new ListNode(2);
        l3.next=new ListNode(6);
        lists[2]=l3;

        ListNode res = mergeKLists(lists);
        ListNode curr= res;
        while (curr!=null){
            System.out.print(curr.val+", ");
            curr = curr.next;
        }
        System.out.println();

        lists = new ListNode[1];
        res = mergeKLists(lists);
        curr= res;
        while (curr!=null){
            System.out.print(curr.val+", ");
            curr = curr.next;
        }
        System.out.println();

        lists = new ListNode[2];
        res = mergeKLists(lists);
        curr= res;
        while (curr!=null){
            System.out.print(curr.val+", ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0)
            return null;
        if (len == 1)
            return lists[0];

        ListNode head = null, curr = null, curr1 = lists[0], curr2;
        for (int i = 1; i < len; i++) {
            curr2 = lists[i];

            while (curr1 != null && curr2 != null) {
                if (curr1.val >= curr2.val) {
                    if (head == null) {
                        head = curr = curr2;
                    } else {
                        curr.next = curr2;
                        curr = curr2;
                    }
                    curr2 = curr2.next;
                } else {
                    if (head == null) {
                        head = curr = curr1;
                    } else {
                        curr.next = curr1;
                        curr = curr1;
                    }
                    curr1 = curr1.next;
                }
            }

            while (curr2 != null) {
                    if (head == null) {
                        head = curr = curr2;
                    } else {
                        curr.next = curr2;
                        curr = curr2;
                    }
                    curr2 = curr2.next;
            }

            while (curr1 != null) {
                if (head == null) {
                    head = curr = curr1;
                } else {
                    curr.next = curr1;
                    curr = curr1;
                }
                curr1 = curr1.next;
            }
            curr1=head;
            if(i != len-1){
                head = null;
            }
        }
        return head;
    }
}

//  Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
