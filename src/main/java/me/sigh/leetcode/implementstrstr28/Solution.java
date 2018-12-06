package me.sigh.leetcode.implementstrstr28;

public class Solution {

    public int strStr(String haystack, String needle) {
        if (haystack == null || haystack.length() == 0) {
            return -1;
        }
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }

        if(haystack.equals(needle)){
            return 0;
        }

        char[] arr0 = haystack.toCharArray();
        char[] arr1 = needle.toCharArray();
        int offset = arr1.length;

        for (int i = 0; i < arr0.length; i++) {
            if (i + offset > arr0.length) {
                return -1;
            }

            boolean found = true;
            for (int j = 0; j < offset; j++) {
                if (arr0[i+j] != arr1[j]) {
                    found = false;
                    break;
                }
            }

            if (found) {
                return i;
            }
        }

        return -1;
    }
}
