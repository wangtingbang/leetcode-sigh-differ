package me.sigh.leetcode.trappingrainwater;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

//TODO
public class TrappingRainWater {

    public int trap(int[] height) {


        //        List<Integer> top = new ArrayList<>();

        if (height.length < 2) {
            return 0;
        }

        int size = height.length;
        List<Integer> tops = new ArrayList();
        for (int i = 0; i < size; i++) {

            if (i == 0) {
                if (height[i] > height[i + 1]) {
                    tops.add(i);
                }
                continue;
            }

            if (i + 1 >= size) {
                break;
            }
            if (height[i - 1] < height[i] && height[i] >= height[i + 1]) {
                tops.add(i);
            }
            if (height[i] >= height[i + 1]) {
                //                tops.remove(i-1);
            }
        }

        if (height[size - 1] >= height[size - 2]) {
            tops.add(size - 1);
        }

        //        tops.remove(tops.get(0)> tops.get(tops.size()-1)?0:tops.size()-1);

        int sum = 0;
        for (int i = 1; i < tops.size(); i++) {
            int add = Math.min(height[tops.get(i - 1)], height[tops.get(i)]) * (tops.get(i) - tops
                .get(i - 1) - 1);
            //            System.out.println("add: " + add);
            sum += add;
        }

//        System.out.println("sum: " + sum + ", tops: " + JSONObject.toJSONString(tops));

        int j = 0;
        for (int i = 0; i < size; i++) {
            if (i < tops.get(0)) {
                continue;
            }
            if (i >= tops.get(tops.size() - 1)) {
                //                System.out.println("i: " + i + ", tops[j]: " + j);
                break;
            }
            if (!tops.contains(i)) {
                sum -= height[i];
                j++;
                //                System.out.printf("i: %d, sum: %d, height[i]: %d\n", i, sum, height[i] );
            }



        }

        //        System.out.println("tops: " + JSONObject.toJSONString(tops));
        //        System.out.println("sum: " + sum);
        return sum;
    }


    public static void test(TrappingRainWater t, int exp, int[] input) {

        int result = t.trap(input);
        System.out.printf("%5c     |%12d | %12d | %s \n", exp == result ? 'Y' : 'N', exp, result,
            JSONObject.toJSONString(input));
        System.out.println("----------|-------------|--------------|---------------------");
    }

    public static void main(String[] args) {

        TrappingRainWater t = new TrappingRainWater();

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
