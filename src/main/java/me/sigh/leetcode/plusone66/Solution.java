package me.sigh.leetcode.plusone66;

public class Solution {

    public int[] plusOne(int[] digits) {

        int carray = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += i == digits.length - 1 ? 1 : carray;
            if (digits[i] >= 10) {
                carray = digits[i] / 10;
                digits[i] = digits[i] % 10;
            } else {
                carray = 0;
            }
        }

        if (carray == 0) {
            return digits;
        } else {
            int result[] = new int[digits.length + 1];

            result[0] = carray;
            for (int i = 0; i < digits.length; i++) {
                result[i + 1] = digits[i];
            }
            return result;
        }
    }
}
