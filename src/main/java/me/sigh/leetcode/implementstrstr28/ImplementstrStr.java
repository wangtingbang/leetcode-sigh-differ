package me.sigh.leetcode.implementstrstr28;

import com.alibaba.fastjson.JSONObject;

public class ImplementstrStr {


    public static boolean isEqual(int exp, int result) {
        return exp == result;
    }


    public static void test(Solution t, int exp, String input, String val) {


        int result = t.strStr(input, val);
        System.out.printf("%5c     | %-30s | %-30s | %-30s \n",
                isEqual(exp, result) ? 'Y' : 'N',
                exp,
                result,
                input + ", " + val);
        System.out.println(
                "----------|--------------------------------|--------------------------------|----------------------------------");
    }

    public static void main(String[] args) {

        Solution t = new Solution();

        System.out.println(
                "= passed =|========== expected ============|========== actual ==============|=============== input ==================");

        String haystack = "hello", needle = "ll";
        int exp =2;
//        test(t, exp, haystack, needle);
//
//        haystack = "aaaaa";
//        needle = "bba";
//        exp = -1;
//        test(t, exp, haystack, needle);
//
//        haystack = "";
//        needle = "";
//        exp = 0;
//        test(t, exp, haystack, needle);

//        haystack = "a";
//        needle = "a";
//        exp = 0;
//        test(t, exp, haystack, needle);

//        haystack = "mississippi";
//        needle = "mississippi";
//        exp = 0;
//        test(t, exp, haystack, needle);
        haystack = "mississippi";
        needle = "issi";
        exp = 1;
        test(t, exp, haystack, needle);
    }

}
