package com.rau.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public static void main(String[] args) {
        System.out.println("res:"+generate(6));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list= new ArrayList<>();
        for(int row=0;row<numRows;row++){
            List<Integer> subList = new ArrayList<>(row+1);
            subList.add(1);
            if(row>=1){
                for(int col=1;col<row+1;col++){
                    if(list.get(row-1).size()>col){
                        subList.add(list.get(row-1).get(col-1)+list.get(row-1).get(col));
                    }else {
                        subList.add(1);
                    }

                }
            }
            list.add(subList);
        }
        return list;
    }

}
