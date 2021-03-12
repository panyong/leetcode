package com.rambo.algorithm.leetcode;

public class Solution189$1 {
    public void rotate(int[] nums, int k) {
        if ((k = k % nums.length) == 0){
            return ;
        }
        int count=0,index=0,step = 0;

        while (count++ < nums.length){
            int indexN = (index = index + k) % nums.length;
            if(indexN == step){
                step++;
                index = step;
                continue;
            }

            int temp = nums[step];
            nums[step] = nums[indexN];
            nums[indexN] = temp;
        }
    }

    public static void main(String[] args) {
        Solution189$1 solution189$1 = new Solution189$1();
        int[] nums = {1,2,3,4,5,6};
        solution189$1.rotate(nums,2);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
