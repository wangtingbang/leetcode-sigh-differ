package me.sigh.leetcode.trappingrainwater;

import com.alibaba.fastjson.JSONObject;

public class Sample0 {

    public int trap(int[] height) {
        if (height == null || height.length == 0)
            return 0;

        int water = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = height[left] > leftMax ? height[left] : leftMax;
            rightMax = height[right] > rightMax ? height[right] : rightMax;
            if (leftMax < rightMax) {
                water += leftMax - height[left++];
//                System.out.printf("water: %d, leftMax: %d, rightMax: %d, height:%d\n", water, leftMax, rightMax, height[left-1]);
            }
            else {
                water += rightMax - height[right--];
//                System.out
//                    .printf("water: %d, leftMax: %d, rightMax: %d, height:%d\n", water, leftMax,
//                        rightMax, height[right + 1]);
            }
        }
        return water;
    }

    public static void test(Sample0 t, int exp, int[] input) {

        int result = t.trap(input);
        System.out.printf("%5c     |%12d | %12d | %s \n", exp == result ? 'Y' : 'N', exp, result,
            JSONObject.toJSONString(input));
        System.out.println("----------|-------------|--------------|---------------------");
    }

    public static void main(String[] args) {

        Sample0 t = new Sample0();

        System.out.println("  passed  |\texpected    |  \tactual\t   |\tinput");
        System.out.println("==========|=============|==============|=====================");

        test(t, 6, new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        test(t, 0, new int[] {});
        test(t, 2, new int[] {5, 3, 7, 7});
        test(t, 1, new int[] {5, 4, 1, 2});
        test(t, 11, new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1, 3});
        test(t, 1, new int[] {1, 0, 2, 3});
    }

}
