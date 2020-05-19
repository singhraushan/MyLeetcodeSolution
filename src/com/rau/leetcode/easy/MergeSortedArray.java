package com.rau.leetcode.easy;

import java.util.Arrays;
import java.util.Collections;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 4, 5};
        merge(nums1, 3, nums2, 3);
        Arrays.stream(nums1).forEach(System.out::println);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2.length == 0)
            return;
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        int len = nums1.length;
        if (nums1[m - 1] <= nums2[0]) {
            for (int i = 0; i < n; i++) {
                nums1[m + i] = nums2[i];
            }
            return;
        } else if (nums2[n - 1] <= nums1[0]) {
            int k = 0;
            for (int i = m; i < len; i++) {
                nums1[i] = nums1[k];
                nums1[k] = nums2[k];
                k++;
            }
            return;
        } else {
            int j = 0;
            for (int i = 0; i < len && j < n; i++) {
                if (nums1[i] > nums2[j]) {
                    int prev = nums1[i];
                    for (int k = i + 1; k < len; k++) {
                        int temp = nums1[k];
                        nums1[k] = prev;
                        prev = temp;
                    }
                    nums1[i] = nums2[j];
                    j++;
                } else if (i >= m + j) {
                    nums1[i] = nums2[j];
                    j++;
                }
            }
        }

    }
}
