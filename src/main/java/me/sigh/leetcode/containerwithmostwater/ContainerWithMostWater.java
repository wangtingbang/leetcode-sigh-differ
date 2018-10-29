package me.sigh.leetcode.containerwithmostwater;

import com.alibaba.fastjson.JSONObject;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {

        int iLeft = 0;
        int iRight = height.length - 1;

        int max =0;
        while (iLeft<iRight){


            int curr = Math.min(height[iLeft], height[iRight]) * (iRight - iLeft );
            max = curr>max?curr:max;
            if(height[iLeft] > height[iRight]){
                iRight --;
            }else {
                iLeft++;
            }
        }

        return max;
    }


    public static void test(ContainerWithMostWater t, int exp, int[] input) {

        int result = t.maxArea(input);
        System.out.printf("%5c     |%12d | %12d | %s \n", exp == result ? 'Y' : 'N', exp, result,
            JSONObject.toJSONString(input));
        System.out.println("----------|-------------|--------------|---------------------");
    }

    public static void main(String[] args) {

        ContainerWithMostWater t = new ContainerWithMostWater();

        System.out.println("  passed  |\texpected    |  \tactual\t   |\tinput");
        System.out.println("==========|=============|==============|=====================");

        test(t, 49, new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7});
        test(t, 99, new int[] {99, 99, 6, 2, 5, 4, 8, 3, 7});
    }

}
