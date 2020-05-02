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

        int i = 0, j = 0, k;
        for (k = 0; k < finalArray.length; k++) {
            if (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j])
                    finalArray[k] = nums1[i++];
                else
                    finalArray[k] = nums2[j++];
            } else if (i < nums1.length) {
                finalArray[k] = nums1[i++];
            } else {
                finalArray[k] = nums2[j++];
            }
        }
        k--;
        return k % 2 == 0 ? finalArray[k / 2] : (finalArray[k / 2] + finalArray[k / 2 + 1]) / 2.0;
    }
}
