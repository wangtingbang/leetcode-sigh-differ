package me.sigh.leetcode.singlenumber;

import com.alibaba.fastjson.JSONObject;

public class ExampleIII0ms {


    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        diff &= -diff;
        int[] res = {0, 0};
        for (int num : nums) {
            if ((num & diff) == 0)
                res[0] ^= num;
            else
                res[1] ^= num;
        }

        return res;
    }

    public static void main(String[] args) {
        ExampleIII0ms singleNumber = new ExampleIII0ms();

        System.out.println("exp: 1, actual: " + JSONObject
            .toJSONString(singleNumber.singleNumber(new int[] {2, 2, 1})));
        System.out
            .println("exp: 4, actual: " + JSONObject.toJSONString(singleNumber.singleNumber(new int[] {4, 1, 2, 1, 2})));

        System.out.println("exp: 3, actual: " +JSONObject.toJSONString( singleNumber.singleNumber(new int[] {2, 2, 3, 2})));
        System.out.println(
            "exp: 99, actual: " + JSONObject.toJSONString(singleNumber.singleNumber(new int[] {0, 1, 0, 1, 0, 1, 99})));
        System.out.println(
            "exp: [3,5], actual: " + JSONObject.toJSONString(singleNumber.singleNumber(new int[] {1,2,1,3,2,5})));

        System.out.println(~4);
    }
}
