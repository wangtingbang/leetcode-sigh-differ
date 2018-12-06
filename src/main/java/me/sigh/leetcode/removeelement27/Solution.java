package me.sigh.leetcode.removeelement27;


class Solution {

    /*
    //me
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int result[] = new int[nums.length];

        int j = 0;
        for(int i = 0; i< nums.length; i++){
            if(val != (nums[i])){
                result[j] = nums[i];
                j++;
            }
        }
        for(int i=0; i<j; i++){
            nums[i] = result[i];
        }
        return j;
    }
    //*/

    // good example

    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int l = 0, r = 0;
        for(; r< nums.length; r++){
            if(nums[r] != val){
                nums[l] = nums[r];
                l++;
            }
        }

        return l;
    }
}

