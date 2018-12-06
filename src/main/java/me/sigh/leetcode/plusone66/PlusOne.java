package me.sigh.leetcode.plusone66;

import com.alibaba.fastjson.JSONObject;

public class PlusOne {

    public static void main(String[] args) {
        Solution solution = new Solution();

//        System.out.printf("exp: %s => result: %s\n",
//                JSONObject.toJSONString(new int[] {1, 2, 4}),
//                JSONObject.toJSONString(solution.plusOne(new int[] {1, 2, 3})));
//
//
//        System.out.printf("exp: %s => result: %s\n",
//                JSONObject.toJSONString(new int[] {4, 3, 2, 2}),
//                JSONObject.toJSONString(solution.plusOne(new int[] {4, 3, 2, 1})));
//
        System.out.printf("exp: %s => result: %s\n",
                JSONObject.toJSONString(new int[] {9, 0, 0, 0}),
                JSONObject.toJSONString(solution.plusOne(new int[] {8, 9, 9, 9})));
    }
}
