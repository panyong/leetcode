package com.rambo.algorithm.leetcode;

import java.util.BitSet;

public class Solution11 {
    public int removeDuplicates(int[] nums) {
        //游标
        int index = 0;
        for (int i = 0; i < nums.length; i++){
            i = getLast(nums, i);
            nums[index++] = nums[i];
        }

        return index ;
    }

    public int getLast(int[] nums, int index) {

        for (; index < nums.length; index++){
            if (index == nums.length - 1){
                break;
            }
            if (nums[index] == nums[index + 1]){
                continue;
            }else {
                break;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
        int[] nums = {1, 1, 2};
        int index = solution11.removeDuplicates(nums);
        for (int i = 0; i < index; i++) {
            System.out.println(nums[i]);
        }
    }
}
