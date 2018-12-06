package me.sigh.leetcode.removeelement27;

import com.alibaba.fastjson.JSONObject;

public class RemoveElement {


    public static boolean isEqual(int exp, int result) {
        return exp == result;
    }


    public static void test(Solution t, int exp, int[] input, int val) {


        int result = t.removeElement(input, val);
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

        test(t, 2, new int[] {3, 2, 2, 3}, 3);
        test(t, 5, new int[] {0, 1, 2, 2, 3, 0, 4, 2}, 2);
        test(t, 1, new int[] {2}, 3);

    }

}
