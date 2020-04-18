package com.rambo.algorithm.leetcode;

import java.util.BitSet;

public class Solution56 {
    public int[][] merge(int[][] intervals) {
        BitSet bitSet = new BitSet();
        int max = 0;
        for (int[] interval : intervals) {
            bitSet.set(interval[0], interval[1], true);
            bitSet.set(interval[1], true);
            max = interval[1] >= max ? interval[1] : max;
        }

        int index = 0, count = 0;
        while (index < max) {
            int start = bitSet.nextSetBit(index);
            int end = bitSet.nextClearBit(start);

            int[] item = {start, end};
            intervals[count++] = item;

            index = end;
        }
        int[][] ret = new int[count][2];
        for (int i = 0; i < count; i++) {
            ret[i] = intervals[i];
        }

        return ret;
    }

    public static void main(String[] args) {
        Solution56 solution56 = new Solution56();
        int[][] intervals = {{1, 4}, {0, 0}};
        int[][] ret = solution56.merge(intervals);

        System.out.println("{");
        for (int[] ints : ret) {
            System.out.printf(" {");
            for (int i : ints) {
                System.out.printf(i + ",");
            }
            System.out.printf("}");
            System.out.println("");
        }
        System.out.printf("}");
    }
}
