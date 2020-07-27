package com.rau.leetcode.easy;

public class RemoveElement {

    public static void main(String[] args) {

        System.out.println("Length : "+removeElement(new int[]{3, 2, 2, 3}, 3));
        //System.out.println("Length : "+removeElement(new int[]{4, 5}, 4));
        //System.out.println("Length : "+removeElement(new int[]{4, 5}, 5));
        //System.out.println("Length : "+removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
    }

    public static int removeElement(int[] nums, int val) {
        int len = nums.length;
        if (len == 0)
            return 0;
        if (len == 1){
            if (nums[0] == val) {
                nums[0]=-1;
                return 0;
            }
            return 1;
        }
        int result = len;
        for (int i = 0; i < len; i++) {
            if (nums[i] == val) {
                for (int j = len-1; j > i; j--) {
                    if (nums[j] != val){
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        result--;
                        break;
                    }
                    if(i==j-1){//&& nums[j] == val
                        return i;
                    }
                }
                if(i==len-1 && result==i+1){
                    --result;
                }
            }
        }
        return result;
    }
}
