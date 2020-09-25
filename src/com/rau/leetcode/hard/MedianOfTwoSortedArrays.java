package com.rau.leetcode.hard;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        System.out.println("The Median is: " + findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

    /*if the number of the elements are even,
        so there are two middle elements,
        take the average between the two. if odd then mid element would be median :*/
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] finalArray = new int[nums1.length + nums2.length];
        int len = finalArray.length, len1 = nums1.length, len2 = nums2.length;
        int i = 0, j = 0, k;

        for (k = 0; k < len; k++) {
            if (i < len1 && j < len2) {
                if (nums1[i] < nums2[j])
                    finalArray[k] = nums1[i++];
                else
                    finalArray[k] = nums2[j++];
            } else if (i < len1) {
                finalArray[k] = nums1[i++];
            } else {
                finalArray[k] = nums2[j++];
            }
        }
        k--;
        return k % 2 == 0 ? finalArray[k / 2] : (finalArray[k / 2] + finalArray[k / 2 + 1]) / 2.0;
    }
}
