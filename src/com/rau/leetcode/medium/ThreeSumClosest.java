package com.rau.leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSumClosest {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        //[13,2,0,-14,-20,19,8,-5,-13,-3,20,15,20,5,13,14,-17,-7,12,-6,0,20,-19,-1,-15,-2,8,-2,-9,13,0,-3,-18,-9,-9,-19,17,-14,-19,-4,-16,2,0,9,5,-7,-4,20,18,9,0,12,-1,10,-17,-11,16,-13,-14,-3,0,2,-18,2,8,20,-15,3,-13,-12,-2,-19,11,11,-10,1,1,-10,-2,12,0,17,-19,-7,8,-19,-17,5,-5,-10,8,0,-12,4,19,2,0,12,14,-9,15,7,0,-16,-5,16,-12,0,2,-16,14,18,12,13,5,0,5,6]
        //-59
       // System.out.println("threeSumClosest is :" + threeSumClosest(new int[]{-4,-7,-2,2,5,-2,1,9,3,9,4,9,-9,-3,7,4,1,0,8,5,-7,-7}, 29));
        System.out.println("threeSumClosest is :" + threeSumClosest(new int[]{-4,-7,-2,2,5,-2,1,9,3,9,4,9,-9,-3,7,4,1,0,8,5,-7,-7}));
        //System.out.println("threeSumClosest is :" + threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        System.out.println("total time: "+(System.currentTimeMillis()-startTime));
    }
    public static int threeSumClosest(int[] nums) {
        int sum = nums[0]+nums[1]+nums[2], len = nums.length;

        for(int i=1;i<len;i++){
            if(i+2<len){
                sum = getClosest(nums[i]+nums[i+1]+nums[i+2], sum, 29);
            }
        }

        return sum;
    }

    public static int threeSumClosest(int[] nums, int target) {
        int sum = 0, len = nums.length;
        if (len <= 3) {
            for (int num : nums)
                sum += num;
        } else {
            HashSet<Integer> set = new HashSet<>();
            ArrayList<Integer> list = new ArrayList<>();
            subSet(nums, 0, list, set);
            int i = 0;
            for (int r : set) {
                if (i == 0) {
                    sum = r;
                    i++;
                } else {
                    sum = getClosest(sum, r, target);
                }
            }
        }
        return sum;
    }

    public static void subSet(int[] input, int index, ArrayList<Integer> result, Set<Integer> sumSet) {
        if (input.length == index) {
            List<Integer> result2 = result.stream().filter(Objects::nonNull).collect(Collectors.toList());
            if (result2.size() == 3) {
                int sum = 0;
                for (Integer r : result2) {
                    sum += r;
                }
                sumSet.add(sum);
            }
        } else {
            if (result.size() > index)
                result.set(index, null);
            else
                result.add(index, null);
            subSet(input, index + 1, result, sumSet);
            if (result.size() > index)
                result.set(index, input[index]);
            else
                result.add(index, input[index]);
            subSet(input, index + 1, result, sumSet);
        }
    }

    public static int getClosest(int num1, int num2, int target) {
        return Math.abs(target - num1) < Math.abs(target - num2) ? num1 : num2;
    }
}
