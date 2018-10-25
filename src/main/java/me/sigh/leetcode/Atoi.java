package me.sigh.leetcode;

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
        boolean negative = false;
        boolean tooPlus = false;
        for (int i = len - 1; i >= 0; i--) {
            char c = chars[i];
            if (isNumber(c)) {
                int num = toNum(c);
//                System.out.printf("%d\n", num);

                //                int mul = 10;
                //                for(int j=10; j<count;j++){
                //                    mul *=mul;
                //                }

                data += Math.pow(10, count) * num;
//                System.out.println("data: " + data);
                count++;
            }
            if(c == '.'){
                data = 0;
                count = 0;
            }
            if (c == '-') {
                negative = true;
            }
            if(c == '+'){
                tooPlus = true;
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

//        System.out.printf("---------\n");

        return (int)data;
    }

    private boolean isNumber(char ch) {
        return ch <= '9' && ch >= '0';
    }

    private int toNum(char c) {
        return (int) c - 48;
    }


    public static void main(String[] args) {

        Atoi atoi = new Atoi();

        System.out.println(atoi.myAtoi("42"));
        System.out.println(atoi.myAtoi("   -42"));
        System.out.println(atoi.myAtoi("4193 with words"));
        System.out.println(atoi.myAtoi("words and 987"));
        System.out.println(atoi.myAtoi("-91283472332"));
        System.out.println(atoi.myAtoi("83.14159"));
        System.out.println(atoi.myAtoi("+1"));
        System.out.println(atoi.myAtoi("+-1"));

        int a[] = new int[] {-1};
    }
}
