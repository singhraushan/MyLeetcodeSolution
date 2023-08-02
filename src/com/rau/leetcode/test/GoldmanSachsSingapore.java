package com.rau.leetcode.test;

import java.util.*;

public class GoldmanSachsSingapore {
    public static void main(String[] args) {
        //printAllAnagram
        String[] input = new String[]{"cat", "dog", "tac", "god", "act"};//cat tac act dog god
        printAllAnagram(input);
    }

    public static void printAllAnagram(String[] input) {

        Map<String, List<Integer>> map = new TreeMap<>();

        for (int i = 0; i < input.length; i++) {
            char[] chars = input[i].toCharArray();
            mergeSort(chars, 0, input[i].length() - 1);//sorting

            List<Integer> list = map.get(String.valueOf(chars));
            if (list != null) {
                list.add(i);
            } else {
                list = new ArrayList<>();
                list.add(i);
                map.put(String.valueOf(chars), list);
            }
        }

        //print
        for (String key : map.keySet()) {
            for (int index : map.get(key)) {
                System.out.print(input[index] + " ");
            }
        }

    }

    public static void mergeSort(char[] input, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int mid = (startIndex + endIndex) / 2;
            mergeSort(input, startIndex, mid);
            mergeSort(input, mid + 1, endIndex);
            sort(input, startIndex, mid, endIndex);
        }
    }

    public static void sort(char[] input, int startIndex, int mid, int endIndex) {
        char[] leftArr = new char[mid - startIndex + 1], rightArr = new char[endIndex - mid];

        for (int i = 0; i < leftArr.length; i++) {
            leftArr[i] = input[startIndex + i];
        }
        for (int i = 0; i < rightArr.length; i++) {
            rightArr[i] = input[mid + 1 + i];
        }

        int i = 0, j = 0, k = startIndex;
        while (i < leftArr.length && j < rightArr.length) {
            input[k++] = leftArr[i] <= rightArr[j] ? leftArr[i++] : rightArr[j++];
        }

        while (i < leftArr.length) {
            input[k++] = leftArr[i++];
        }
        while (j < rightArr.length) {
            input[k++] = rightArr[j++];
        }
    }


}

class Entry<K, V> {

    private K key;
    private V value;
    Entry<K, V> next;

    public Entry(K key, V value, Entry<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public void setNext(Entry<K, V> next) {
        this.next = next;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public Entry<K, V> getNext() {
        return next;
    }
}

class MyHashMap<K, V> {
    private int capacity = 16;//default
    Entry[] table;

    public MyHashMap() {
        table = new Entry[capacity];
    }

    public MyHashMap(int capacity) {
        table = new Entry[this.capacity = capacity];
    }

    public void put(K key, V value) {
        int index = index(key);
        Entry<K, V> newEntry = new Entry(key, value, null);
        if (table[index] == null) {
            table[index] = newEntry;
        } else {
            Entry current = table[index], prev = null;
            while (current != null) {
                if (current.getKey().equals(key)) {
                    current.setValue(value);
                    return;
                }
                prev = current;
                current = prev;
            }
            if (prev != null) {
                prev.setNext(newEntry);
            }
        }
    }

    public Object get(K key) {
        int index = index(key);
        Entry current = table[index];
        while (current != null) {
            if (current.getKey().equals(key)) {
                return current.getValue();
            }
            current = current.next;
        }
        return null;
    }

    public Object remove(K key) {
           int index = index(key);
           Entry entry = table[index],prev = null;

           while (entry!=null){
               if(entry.getKey().equals(key)){
                   if(prev!=null){
                       prev.setNext(entry.getNext());
                   }
                   return entry.getValue();
               }
               prev = entry;
               entry = entry.next;
           }
           return null;
    }

    public void display() {
        for (int i=0;i<capacity;i++) {
            Entry currentEntry = table[i];
            if(currentEntry!=null){
                Entry entry = currentEntry;
                while (entry==null){
                    System.out.println("key:"+entry.getKey()+",value:"+entry.getValue());
                    entry= entry.getNext();
                }
            }
        }
    }

    public int index(K key) {
        if (key == null)
            return 0;
        return Math.abs(key.hashCode() % capacity);
    }

}

class MyArraylist<T> {

    private int capacity = 10;//default capacity 10
    private int currIndex;
    private Object[] array;

    public MyArraylist() {
        array = new Object[capacity];
    }

    public MyArraylist(int capacity) {
        array = new Object[this.capacity = capacity];
    }

    public boolean add(T t) {
        if (!(array.length > currIndex)) {
            capacity *= 2;
            Object[] tempArray = new Object[capacity];
            int len = array.length;
            for (int i = 0; i < len; i++) {
                tempArray[i] = array[i];
            }
            array = tempArray;
        }
        array[currIndex++] = t;
        return true;
    }

    public T get(int index) {
        if (index < 0 || index > currIndex) {
            return null;
        }
        return (T) array[index];
    }
}

class LRU {
    Node front, rear;

    public LRU(){
        front = new Node(0);
        rear = new Node(0);
        rear.next=front;
        front.prev=rear;
    }



    class Node{
        Node next;
        Node prev;
        Object value;
        Node(Object value){
            this.value = value;
        }
    }
}