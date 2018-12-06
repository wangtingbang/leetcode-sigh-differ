package me.sigh.leetcode.searchinsertposition;

public class Solution {

    /*
    public int searchInsert(int[] nums, int target) {

//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == target) {
//                return i;
//            }
//        }
//
//        return nums.length - 1;



        return 0;
    }
    //*/

    // [1]
    // 2
    // 1
    public int searchInsert(int nums[], int target) {

        if (nums.length == 0) {
            return 0;
        }

        int left = 0, right = nums.length - 1;

        if (nums[left] > target) {
            return left;
        }
        if (nums[right] < target) {
            return right + 1;
        }

        int mid = 0;
        while (left < right) {
            mid = (right - left) / 2 + left;

            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid;
            }
            if (nums[mid] > target) {
                right = mid;
            }

            if (left + 1 == right) {
                return nums[left] == target ? left : nums[right] == target ? right : left + 1;
            }
        }
        return mid;
    }
}
