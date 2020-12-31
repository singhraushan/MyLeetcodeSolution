package com.rau.leetcode.medium;

public class PartitionList {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        ListNode res = partition(head, 3);
        pirint(res);//1->2->2->4->3->5->
        System.out.println("-----------------");
        head = new ListNode(5);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);

        res = partition(head, 3);
        pirint(res);//1->2->5->

        System.out.println("-----------------");
        head = new ListNode(3);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);

        res = partition(head, 3);
        pirint(res);//1->2->3->

    }

    public static ListNode partition(ListNode head, int x) {
        ListNode curr = head, curr2,prev=null;
        while (curr!=null) {

            if(curr.val>=x){
                curr2 = curr;
                while (curr2!=null){

                    if(curr2.next!=null && curr2.next.val<x){
                        ListNode temp = curr2.next;
                        curr2.next = curr2.next.next;
                        if (curr==head){
                            head = temp;
                            temp.next = curr;
                            prev = temp;
                            System.out.println("1");
                        }else {
                            prev.next= temp;
                            temp.next = curr;
                            prev=temp;
                            System.out.println("2");
                        }

                    }else {
                        curr2 = curr2.next;
                    }
                }
                break;
            }
            prev = curr;
            curr = curr.next;
        }
        return head;
    }

    private static void pirint(ListNode res){
        ListNode curr = res;
        while (curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
        System.out.println();
    }
}
