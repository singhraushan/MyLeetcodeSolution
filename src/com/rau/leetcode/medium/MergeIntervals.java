package com.rau.leetcode.medium;

import java.util.Arrays;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] res = merge(new int[][]{{27, 32}, {127, 134}, {375, 380}, {72, 78}, {333, 340}, {421, 422}, {116, 121}, {457, 465}, {178, 185}, {449, 454}, {481, 485}, {391, 391}, {186, 194}, {180, 184}, {116, 124}, {345, 350}, {156, 158}, {232, 235}, {307, 314}, {250, 252}, {354, 355}, {465, 467}, {208, 212}, {482, 488}, {112, 114}, {463, 468}, {488, 494}, {335, 342}, {45, 52}, {491, 494}, {76, 82}, {360, 362}, {160, 164}, {115, 124}, {101, 106}, {311, 318}, {388, 396}, {130, 138}, {403, 407}, {335, 340}, {396, 396}, {312, 319}, {357, 357}, {264, 268}, {367, 372}, {119, 122}, {443, 452}, {27, 30}, {423, 428}, {422, 427}, {212, 217}, {332, 335}, {213, 217}, {401, 407}, {279, 287}, {483, 490}, {239, 247}, {116, 122}, {148, 148}, {202, 207}, {487, 488}, {459, 459}, {300, 308}, {385, 388}, {333, 342}, {100, 106}, {96, 101}, {351, 353}, {451, 453}, {130, 132}, {341, 347}, {462, 462}, {114, 122}, {28, 30}, {459, 459}, {277, 285}, {51, 59}, {229, 232}, {427, 433}, {278, 280}, {478, 487}, {10, 14}, {16, 17}, {236, 243}, {114, 121}, {50, 57}, {333, 335}, {239, 248}, {442, 449}, {61, 62}, {349, 357}, {200, 202}, {279, 280}, {307, 315}, {99, 104}, {170, 177}, {316, 317}, {152, 154}, {42, 42}, {300, 308}, {459, 461}, {167, 169}, {66, 72}, {443, 451}, {25, 29}, {262, 268}, {195, 197}, {478, 482}, {95, 102}}); //
        for(int i=0;i<res.length;i++){
            System.out.println("["+res[i][0]+" "+res[i][1]+"]");
        }
    }
    public static int[][] merge(int[][] intervals) {
        int start= intervals[0][0], end=intervals[0][1], len =intervals.length,k=0;
        if (len<=1)
            return intervals;

        int[][] res= new int[len][2];
        Arrays.sort(intervals,(i1,i2)->Integer.compare(i1[0],i2[0]));
        for (int i = 1; i < len; i++) {
            for (int j = i; j < len; j++ ){
                if (intervals[j][0] != -1) {
                    if (intervals[j][1] < start || intervals[j][0] > end ){ //Not overalp
                        res[k][0] = start;
                        res[k][1] = end;
                        k++;
                        start = intervals[j][0];
                        end = intervals[j][1];
                        intervals[j][0] = -1;
                    } else { //overlap
                        if (intervals[j][0] > start && intervals[j][1] < end) { //new is fully inside
                            intervals[j][0] = -1;
                        } else if (intervals[j][0] <= start && intervals[j][1] >= end ){ //new start & end both outside
                            start = intervals[j][0];
                            end = intervals[j][1];
                            intervals[j][0] = -1;
                        } else if (intervals[j][0] <= start) { //new start is only outside
                            start = intervals[j][0];
                            intervals[j][0] = -1;
                        } else if (intervals[j][1] >= end) { //new end is only outside
                            end = intervals[j][1];
                            intervals[j][0] = -1;
                        }
                    }
                }
            }
        }
        res[k][0] = start;
        res[k][1] = end;
        k++;

        return res;
    }
}
