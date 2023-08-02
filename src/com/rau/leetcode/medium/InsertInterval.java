package com.rau.leetcode.medium;

import java.util.Arrays;
import java.util.stream.Collectors;

public class InsertInterval {
    public static void main(String[] args) {
        int res[][] = merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        for (int i = 0; i < res.length; i++) {
            System.out.println("res: " + Arrays.stream(res[i]).boxed().collect(Collectors.toList()));
        }

        System.out.println("-------------");
        int res1[][] = merge(new int[][]{{1, 4}, {4, 5}});
        for (int i = 0; i < res1.length; i++) {
            System.out.println("res: " + Arrays.stream(res1[i]).boxed().collect(Collectors.toList()));
        }

        System.out.println("-------------");
        int res2[][] = merge(new int[][]{{2,3},{4,5},{6,7},{8,9},{1,10}});
        for (int i = 0; i < res2.length; i++) {
            System.out.println("res: " + Arrays.stream(res2[i]).boxed().collect(Collectors.toList()));
        }

    }

    public static int[][] merge(int[][] intervals) {
        int len = intervals.length, sizeCount = 0;
        if (len <= 1)
            return intervals;
        for (int i = 0; i < len - 1; i++) {
            if (intervals[i] != null) {
                sizeCount++;
                int s1 = intervals[i][0], e1 = intervals[i][1];
                for (int j = i + 1; j < len; j++) {
                    if (intervals[j] != null) {
                        int s2 = intervals[j][0], e2 = intervals[j][1];
                        if (!(s2 > e1 || e2 < s1)) {
                            if (s1 == s2 && e1 == e2) {
                                intervals[j] = null;
                            } else if (s2 <= s1) {
                                intervals[i][0] = s1 = s2;
                                intervals[j] = null;
                                if (e2 >= e1)
                                    intervals[i][1] = e1 = e2;
                            } else {
                                if (e2 >= e1)
                                    intervals[i][1] = e1 = e2;
                                intervals[j] = null;
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < len - 1; i++) {
            if (intervals[i] != null) {
                int s1 = intervals[i][0], e1 = intervals[i][1];
                for (int j = i + 1; j < len; j++) {
                    if (intervals[j] != null) {
                        int s2 = intervals[j][0], e2 = intervals[j][1];
                        if (!(s2 > e1 || e2 < s1)) {
                            if (s1 == s2 && e1 == e2) {
                                intervals[j] = null;
                            } else if (s2 <= s1) {
                                intervals[i][0] = s1 = s2;
                                intervals[j] = null;
                                if (e2 >= e1)
                                    intervals[i][1] = e1 = e2;
                            } else {
                                if (e2 >= e1)
                                    intervals[i][1] = e1 = e2;
                                intervals[j] = null;
                            }
                            sizeCount--;
                        }
                    }
                }
            }
        }

        if (intervals[len - 1] != null)
            sizeCount++;
        if (sizeCount > 0) {
            int[][] res = new int[sizeCount][2];
            int i = 0, j = 0;
            while (i < sizeCount && j < len) {
                if (intervals[j] != null)
                    res[i++] = intervals[j];
                j++;
            }
            return res;
        }
        return null;
    }
}
