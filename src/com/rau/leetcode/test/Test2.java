package com.rau.leetcode.test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test2 {
    public static void main(String[] args) {
        //int []arr = new int[]{-1,1,2,5,0};
        int []arr = new int[]{-1,2,0,-2};
        mergeSort(arr,0,3);
        System.out.println("final: "+Arrays.stream(arr).boxed().collect(Collectors.toList()));
    }
    public static void mergeSort(int[] input,int start, int end) {
        if(start<end) {
            int mid = (start+end)/2;
            mergeSort(input,start,mid);
            mergeSort(input,mid+1,end);
            sort(input, start, mid, mid+1, end);
            System.out.println("end: "+Arrays.stream(input).boxed().collect(Collectors.toList()));
        }
    }
    public static void sort(int[] input,int arr1Start,int arr1End,int arr2Start,int arr2End) {
        System.out.println("arr1Start:"+arr1Start+",arr1End:"+arr1End+",arr2Start:"+arr2Start+",arr2End:"+arr2End);
        while(arr1Start<=arr1End && arr2Start<=arr2End){
            if(input[arr1Start]>input[arr2Start]){
                //swap and don't increment any side
                int temp = input[arr1Start];
                input[arr1Start] = input[arr2Start];
                input[arr2Start] = temp;
                ++arr1Start;
                ++arr2Start;
            }else {
                //since 1st is already smaller so increment 1st only
                ++arr1Start;
            }
        }
    }
}
/*
    CREATE TABLE `_temp_student` (
        `id` int(11) NOT NULL AUTO_INCREMENT,
        `name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
        PRIMARY KEY (`id`)
        ) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

        CREATE TABLE `_temp_score` (
        `id` int(11) NOT NULL AUTO_INCREMENT,
        `s_id` int(11) NOT NULL,
        `c_id` int(11) NOT NULL,
        `score` int(3) DEFAULT NULL,
        PRIMARY KEY (`id`)
        ) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
//find highest score of each course,
result column: student id, student name, course id, score


Select s.id,s.name,c.id, c.score
from _temp_student s
Inner join _temp_score c on s.id = c.s_id
where c.score = (Select max(c2.score) from _temp_score c2 group by c2.c_id)

find the students who attended less or equal than 1 exam,
result column: student id, student name, attended exam number

Select s.id, s.name, e.exam_number
from _temp_student s
left join exam e on s.id = e.s_id
where count(e.s_id)<2 group by having

*/
