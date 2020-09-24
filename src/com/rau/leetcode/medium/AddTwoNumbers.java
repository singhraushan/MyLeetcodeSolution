package com.rau.leetcode.medium;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode curr = addTwoNumbers(l1, l2);
        while (curr != null) {
            System.out.println(curr.val);
            curr = curr.next;
        }

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode currNode1 = l1, currNode2 = l2;
        int res1 = 0, res2 = 0;
        int mul = 1;
        while (currNode1 != null || currNode2 != null) {

            if (currNode1 != null) {
                res1 += currNode1.val * mul;
                currNode1 = currNode1.next;
            }

            if (currNode2 != null) {
                res2 += currNode2.val * mul;
                currNode2 = currNode2.next;
            }
            mul *= 10;
        }
        int sum = res1 + res2, quotient = sum / 10;
        ListNode rootNode = new ListNode(sum % 10);

        ListNode currNode = rootNode;
        while (quotient > 0) {
            ListNode temp = new ListNode(quotient % 10);
            quotient = quotient / 10;
            currNode.next = temp;
            currNode = temp;
        }
        return rootNode;
    }

    //old solution
    /*public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode rootNode = null, iterateNode = null, currNode = null;

        int sumValue = 0, divisor = 0;
        while (l1 != null || l2 != null) {
            sumValue = ((l1 != null) ? l1.val : 0) + ((l2 != null) ? l2.val : 0) + divisor;

            if (sumValue > 9) {
                divisor = sumValue / 10;
                currNode = new ListNode(sumValue % 10);
            } else {
                currNode = new ListNode(sumValue);
                divisor = 0;
            }

            if (rootNode != null) {
                iterateNode.next = currNode;
                iterateNode = iterateNode.next;

            } else {
                rootNode = currNode;
                iterateNode = rootNode;
            }
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if (divisor > 0) {
            iterateNode.next = new ListNode(1);
            iterateNode = iterateNode.next;
        }
        return rootNode;

    }*/
}
