package com.rau.leetcode.test;

public class ReverseLinkedList {

    public static void main(String[] args) {
        LinkedList head = new LinkedList(1);
        head.next = new LinkedList(4);//1 - 4> -> 2 -> 8 -> 7 -> 3 -> 5 -> 6 -> 9->null
        head.next.next = new LinkedList(2);
        head.next.next.next = new LinkedList(8);
        head.next.next.next.next = new LinkedList(7);
        head.next.next.next.next.next = new LinkedList(3);
        head.next.next.next.next.next.next = new LinkedList(5);
        head.next.next.next.next.next.next.next = new LinkedList(6);
        head.next.next.next.next.next.next.next.next = new LinkedList(9);

        LinkedList res = reverse(head);
        LinkedList curr = res;
        while (curr != null) {
            System.out.print(curr.value + "->");
            curr = curr.next;
        }
    }

    public static LinkedList reverse(LinkedList head) {
        LinkedList curr = head, prev = null;
        while (curr != null) {
            LinkedList next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void deleteNode(LinkedList node) {//7 -> 7 -> 3 -> 5 -> 6 -> 9->null
        LinkedList modified = node.next;
        node.value = modified.value;
        LinkedList nextToNext = modified.next;
        node.next = nextToNext;
    }
//Numbers | 7   |
//| 23  |
//| 6   |
//| 5   |
//| 4   |
//| 6   |
    //select s1.* from Numbers s1 where 1=(select count(s2.*) from Numbers s2 where s1.num>s2.num)
//select s2.* from Numbers s1
//inner join Numbers s2 on s1.num>s2.num
    // select s0.* from Numbers s0 where s0.Num  (select s2.* from Numbers s1 inner join Numbers s2 on s1.num>s2.num)

}

class LinkedList {
    int value;
    LinkedList next;

    LinkedList(int value) {
        this.value = value;
    }
}