package com.rambo.algorithm.leetcode;

public class Solution189$2 {
    public void rotate(int[] nums, int k) {
        if ((k = k % nums.length) == 0){
            return ;
        }

        int count = 0;
        rotate2(nums, k, count);
    }

    public int rotate2(int[] nums, int k, int count) {
        if (count == nums.length - 1){

        }

        return 1;
    }

    public static void main(String[] args) {
        Solution189$2 solution189$1 = new Solution189$2();
        int[] nums = {1,2,3,4,5,6};
        solution189$1.rotate(nums,2);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
