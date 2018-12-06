package me.sigh.leetcode.removeduplicates;

import com.alibaba.fastjson.JSONObject;
import java.util.HashSet;

class Solution {

    public int removeDuplicates(int[] nums) {

        HashSet set = new HashSet();
        int i = 1, j = 0;
        for (; i<nums.length;i++) {
            if(nums[j]!=nums[i]){
                nums[j+1] = nums[i];
                j++;
            }
        }
        return j+1;
    }
}

