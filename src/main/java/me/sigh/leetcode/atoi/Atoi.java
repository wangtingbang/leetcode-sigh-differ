package me.sigh.leetcode.atoi;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 */
public class Atoi {

    public int myAtoi(String str) {

        if(str==null || str.equals("")) return 0;

        char[] chars = str.toCharArray();
        int len = chars.length;

        char c0 = chars[0];
        if (!isNumber(c0) && c0 != '-' && c0 != ' ' && c0!='+')
            return 0;

        int count = 0;
        long data = 0;
        boolean hasSpace = false;
        boolean negative = false;
        boolean tooPlus = false;
        for (int i = len - 1; i >= 0; i--) {
            char c = chars[i];
            if (isNumber(c)) {
                if(negative){
                    data = 0;
                    count = 0;
                    negative = false;
                }
                else if(hasSpace && data > 10) {
                    data = 0;
                    count = 0;
                    hasSpace = false;
                }else if(hasSpace && data > 0 ){
                    count = 1;
                    hasSpace = false;
                } else if (tooPlus) {
                    data = 0;
                    tooPlus = false;
                    negative = false;
                    hasSpace = false;
                    count = 0;
                }
                int num = toNum(c);
                data += Math.pow(10, count) * num;
                count++;
            }
            if(c == ' '){
                hasSpace = true;
            }
            if(c == '.' || isChar(c)){
                data = 0;
                count = 0;
            }
            if (c == '-') {
                if(tooPlus){
                    data = 0;
                    count = 0;
                    tooPlus = false;
                }
                else if(negative){
                    data = 0;
                    count = 0;
                    negative = false;
                }
                else if(hasSpace && data > 10) {
                    data = 0;
                    count = 0;
                    hasSpace = false;
                }else if(hasSpace && data > 0 ){
                    count = 1;
                    hasSpace = false;
                }else{
                    negative = true;
                }
            }
            if(c == '+'){
                if(tooPlus){
                    data = 0;
                    count = 0;
                    tooPlus = false;
                }
                else if(negative){
                    data = 0;
                    count = 0;
                    negative = false;
                }
                else if(hasSpace && data > 10) {
                    data = 0;
                    count = 0;
                    hasSpace = false;
                }else if(hasSpace && data > 0 ){
                    count = 1;
                    hasSpace = false;
                }else {
                    tooPlus = true;
                }
            }
        }

        if( tooPlus && negative){
            return 0;
        }

        if (negative) {
            data = 0 - data;
        }

        if (data >= Integer.MAX_VALUE ){
            return Integer.MAX_VALUE;
        }
        if(data <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int)data;
    }

    private boolean isNumber(char ch) {
        return ch <= '9' && ch >= '0';
    }

    private int toNum(char c) {
        return (int) c - 48;
    }

    private boolean isChar(char ch){
        return ( ch >= 'a' && ch <='z') || ( ch >= 'A' && ch <='Z');
    }

    public static void test( Atoi atoi, int exp, String input) {

        int result = atoi.myAtoi(input);
        System.out.printf("%5c     |%12d | %12d |\t[%s]\n", exp==result?'Y':'N', exp, result, input);
        System.out.println("----------|-------------|--------------|---------------------");
    }

    public static void main(String[] args) {

        Atoi atoi = new Atoi();

        System.out.println("  passed  |\texpected    |  \tactual\t   |\tinput");
        System.out.println("==========|=============|==============|=====================");
        /*
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
