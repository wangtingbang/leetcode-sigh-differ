package me.sigh.leetcode.removeduplicates;

import com.alibaba.fastjson.JSONObject;

public class RemoveDuplicatesMain {


    public static boolean isEqual(int exp, int result) {
        return exp == result;
    }


    public static void test(Solution t, int exp, int[] input) {


        int result = t.removeDuplicates(input);
        System.out.printf("%5c     | %-30s | %-30s | %-30s \n",
                isEqual(exp, result) ? 'Y' : 'N',
                exp,
                result,
                JSONObject.toJSONString(input));
        System.out.println(
                "----------|--------------------------------|--------------------------------|----------------------------------");
    }

    public static void main(String[] args) {

        Solution t = new Solution();

        System.out.println(
                "= passed =|========== expected ============|========== actual ==============|=============== input ==================");

        test(t, 2, new int[] {1, 1, 2});
        test(t, 5, new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4});

    }

}
