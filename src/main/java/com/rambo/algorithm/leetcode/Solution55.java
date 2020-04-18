package com.rambo.algorithm.leetcode;

import java.util.BitSet;

public class Solution55 {
    public boolean canJump(int[] nums) {
        boolean flag = true;
        if (nums.length <= 1){
            return true;
        }
        for ( int i = 0; i < nums.length; i++){
            if (nums[i] != 0){
                continue;
            }

            if (skipable(nums, i)){
                continue;
            }else {
                flag = false;
                break;
            }
        }

        return flag;
    }

    public boolean skipable(int[] nums, int index){
        boolean flag = false;
        for (int i = index - 1; i >= 0; i--){
            if (index == nums.length - 1){
                flag = nums[i] + i >= index ? true : false;
            }else {
                flag = nums[i] + i > index ? true : false;
            }
            if (flag){
                break;
            }
        }

        return flag;
    }

    public static void main(String[] args) {
        Solution55 solution55 = new Solution55();
        int[] nums = {2,0,0};
        boolean ret = solution55.canJump(nums);

        System.out.println(ret);

    }
}
