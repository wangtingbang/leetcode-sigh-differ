package me.sigh.leetcode;

/**
 * https://leetcode.com/problems/two-sum/
 * # 1
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        for(int i =0 ; i< len; i++){
            for(int j = 1; j < len; j++){
                if( nums[i] + nums[j] == target && i != j){
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("None");
    }

    public static void main(String[] args) {
        int []nums = new int[]{2,5,5,11};
        int target = 10;
        TwoSum twoSum = new TwoSum();

        int result[] = twoSum.twoSum(nums, target);
        if(result != null){
            System.out.printf("%d, %d\n", result[0], result[1]);
        }
    }
}
