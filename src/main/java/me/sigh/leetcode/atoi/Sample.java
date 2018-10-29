package me.sigh.leetcode.atoi;

public class Sample {

    public int myAtoi(String str) {
        if (str == null) return 0;

        str = str.trim();

        if (str.length() == 0) return 0;

        char[] chArray = str.toCharArray();
        int sign = 1;
        int i = 0;
        if (chArray[0] == '+') {
            sign = 1;
            i++;
        } else if (chArray[0] == '-') {
            sign = -1;
            i++;
        }

        int result = 0;
        while (i < chArray.length) {
            int digit = chArray[i] - '0';
            if (digit < 0 || digit > 9) {
                return sign * result;
            }
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && Integer.MAX_VALUE % 10 < digit)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + digit;
            i++;
        }

        return sign * result;
    }

    public static void test( Sample atoi, int exp, String input) {

        int result = atoi.myAtoi(input);
        System.out.printf("%5c     |%12d | %12d |\t[%s]\n", exp==result?'Y':'N', exp, result, input);
        System.out.println("----------|-------------|--------------|---------------------");
    }

    public static void main(String[] args) {

        Sample atoi = new Sample();

        System.out.println("  passed  |\texpected    |  \tactual\t   |\tinput");
        System.out.println("==========|=============|==============|=====================");
        //*
        test(atoi, 42, "42");
        test(atoi, -42, "   -42");
        test(atoi, 4193,"4193 with words");
        test(atoi, 0, "words and 987");
        test(atoi, Integer.MIN_VALUE, "-91283472332");
        test(atoi, 83, "83.14159");
        test(atoi, 1, "+1");
        test(atoi, 0, "+-1");
        test(atoi, -12, " -0012a42");
        test(atoi, 0, " +0 123");
        test(atoi, 0, "- 234");
        test(atoi, 0, "0-1");
        test(atoi, -13, "-13+8");
        test(atoi, 123, "123-");
        test(atoi, 0, " ++1"); //*/
        test(atoi, 0, " --2");
    }
}
