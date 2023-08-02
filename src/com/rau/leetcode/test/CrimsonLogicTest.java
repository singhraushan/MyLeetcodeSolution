package com.rau.leetcode.test;

import java.util.HashSet;
import java.util.Set;

public class CrimsonLogicTest {
    public static void main(String[] args) {
        //System.out.println(solution2(new int[]{1,2,1}));//2
        //System.out.println(solution2(new int[]{2,1,4,4}));//1
        System.out.println(solution2(new int[]{6,2,3,5,6,3}));//4
    }
    public static int solution2(int[] A) {
        int max = A.length, move = 0;
        Set<Integer> seen = new HashSet<>();

        for(int v: A){
            if(seen.contains(v)) {//need to move
                boolean isFound = false;
                //try up
                int currMove=1;
                for(int i=v+1;i<=max;i++){
                    if(seen.contains(i)){
                        currMove++;
                    }else {
                        move += currMove;
                        seen.add(i);
                        isFound = true;
                        break;
                    }
                }
                //try down
                if(!isFound){
                    currMove=1;
                    for(int i=v-1;i>0;i--){
                        if(seen.contains(i)){
                            currMove++;
                        }else {
                            move += currMove;
                            seen.add(i);
                            break;
                        }
                    }
                }

            }else {
                seen.add(v);
            }
        }

       return (move>1000000000)?-1:move;
    }
}
