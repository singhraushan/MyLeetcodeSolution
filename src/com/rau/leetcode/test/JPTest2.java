package com.rau.leetcode.test;

public class JPTest2{
    public static void main(String[] args) {
        DoublyLinkedList linked = new DoublyLinkedList();
        linked.add("abc");
        linked.add("cbd");
        linked.add("def");
        System.out.println("isRemoved: "+linked.remove("123"));
        Node node = linked.head;
        while(node!=null){
            System.out.println("v: "+node.obj);
            node = node.next;
        }
    }
}

class DoublyLinkedList {
    Node head;//1st value
    Node curr;
    public DoublyLinkedList(){

    }
    public void add(Object obj){
        Node node = new Node(obj);
        if(head==null){
            head = node;
        }else{
           //set prev & next
            curr.next = node;
            node.prev = curr;
        }
        curr =  node;
    }

    public boolean remove(Object obj){
        Node st = head;
        while(st!=null){
            if(st.obj.equals(obj)){
                //remove & change prev and next
                if(st.prev==null){
                    head = st.next;
                    head.prev = null;
                }else{;
                    st.prev.next = st.next;
                    st.next.prev = st.prev;
                }
                return true;
            }
            st = st.next;
        }
        return  false;
    }
}
class Node {
    public Node next,prev;
    public Object obj;
    public Node(Object obj){
        this.obj = obj;
    }
}
