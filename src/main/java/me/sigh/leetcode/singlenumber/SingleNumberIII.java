package me.sigh.leetcode.singlenumber;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

public class SingleNumberIII {

    public int[] singleNumber(int[] nums) {

        List<Integer> tmp = new LinkedList();
        int len = nums.length;
        Set<Integer> check = new HashSet<>(len / 2 + 1);
        Set<Integer> other = new HashSet<>(len / 2 + 1);

        for (int i = 0; i < len; i++) {
            int num = nums[i];
            if (check.contains(num)) {
                other.add(num);
            } else {
                check.add(num);
            }
        }

        Iterator<Integer> itr = check.iterator();
        while (itr.hasNext()) {
            int num = itr.next();
            if (!other.contains(num)) {
                tmp.add(num);
            }
        }

        int[] a = new int[tmp.size()];
        int i=0;
        for(int t: tmp){
            a[i++] = t;
        }
        return a;
    }

    public static void main(String[] args) {
        SingleNumberIII singleNumber = new SingleNumberIII();

        System.out.println("exp: 1, actual: " + JSONObject.toJSONString(singleNumber.singleNumber(new int[] {2, 2, 1})));
        System.out
            .println("exp: 4, actual: " + JSONObject.toJSONString(singleNumber.singleNumber(new int[] {4, 1, 2, 1, 2})));

        System.out.println("exp: 3, actual: " +JSONObject.toJSONString( singleNumber.singleNumber(new int[] {2, 2, 3, 2})));
        System.out.println(
            "exp: 99, actual: " + JSONObject.toJSONString(singleNumber.singleNumber(new int[] {0, 1, 0, 1, 0, 1, 99})));
        System.out.println(
            "exp: [3,5], actual: " + JSONObject.toJSONString(singleNumber.singleNumber(new int[] {1,2,1,3,2,5})));
    }
}
