package me.sigh.leetcode.reverse;

public class ReverseInteger {

    public int reverse(int x) {

        char[] arr = ("" + x).toCharArray();
        long sum = 0;
        int len = arr.length;
        int rate = 0;
        boolean nav = false;
        for (int i = 0; i < len; i++) {

            char ch = arr[i];
            if( '-' == ch){
                nav = true;
                continue;
            }
            sum+= Math.pow(10, rate)*(ch-48);
            rate++;

        }

        if(sum > Integer.MAX_VALUE){
            return 0;
        }

        return nav? (int)(0-sum):(int)sum;
    }

    private static boolean isEqual(int i1, int i2) {
        return i1 == i2;
    }


    public static void test(int exp, int input) {
        ReverseInteger t = new ReverseInteger();
        int result = t.reverse(input);
        System.out.printf("%5c     | %30s | %30s | %30s \n", isEqual(exp, result) ? 'Y' : 'N',
                exp, result, input);
        System.out.println(
                "----------|--------------------------------|--------------------------------|----------------------------------");
    }

    public static void main(String[] args) {

        ReverseInteger t = new ReverseInteger();

        System.out.println(
                "= passed =|========== expected ============|========== actual ==============|=============== input ==================");

        test(123, 321);
        test(-123, -321);
        test(21, 120);
        test(0, 1534236469);
        test(0, 1534236469);
        System.out.printf("%d, %d\n", Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
}
