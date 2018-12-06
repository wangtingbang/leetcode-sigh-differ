package me.sigh.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstringXX(String s) {

        if (s == null || s.equals("")) {
            return 0;
        }

        int max = 0;
        int count = 0;

        // <char,position>
        HashMap<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            char ch = arr[i];
            if (map.containsKey(ch)) {
                int distance = i - map.get(ch);

                if (distance > max) {
                    max = distance;
                }
                if (count > max) {
                    max = count;
                }

                map.clear();
                count = 1;
//                System.out
//                    .printf("ch: %c, i: %d, dis: %d, count: %d, max: %d\n", ch, i, distance, count,
//                        max);
            }
            System.out
                    .printf("ch: %c, i: %d, count: %d, max: %d\n", ch, i, count,
                            max);
            count++;
            map.put(ch, i);
        }

        return max > count ? max : count;

        //                return max;
    }

    public int lengthOfLongestSubstringYY(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int max = 1;
        int count = 0;

        char[] arr = s.toCharArray();
        int len = arr.length;

        // <char, set<index>>
        HashMap<Character, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {

            char ch = arr[i];
            count++;
            if (map.containsKey(ch)) {
                max = count > max ? count : max;
                count = 0;
            }
        }


        return max > count ? max : count;
    }

    public int aalengthOfLongestSubstring(String s) {

        if (s == null || s.equals("")) {
            return 0;
        }

        int max = 0;
        int count = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            char ch = arr[i];
            if (map.containsKey(ch)) {
                int distance = i - map.get(ch);

                if (distance > max) {
                    max = distance;
                }
                if (count >= max) {
                    max = count;
                    count = 0;
                }
                map.clear();
            } else {
                count++;
            }
            map.put(ch, i);
        }

        return max > count ? max : count;
    }

    static class sample {

        public int lengthOfLongestSubstring(String s) {
            int[] m = new int[256];
            Arrays.fill(m, -1);
            int res = 0, left = -1;
            for (int i = 0; i < s.length(); ++i) {
                System.out.printf("s.charAt(%d): %s\n", i, s.charAt(i));
                left = Math.max(left, m[s.charAt(i)]);
                m[s.charAt(i)] = i;
                res = Math.max(res, i - left);
            }
            return res;
        }
    }

    public int lengthOfLongestSubstring(String s) {
        int max = 0;

        char[] arr = s.toCharArray();
        int len = arr.length;
        HashMap<Character, Integer> chPos = new HashMap<>();

        int left = -1;
        int i;
        for (i = 0; i < len; i++) {
            char ch = arr[i];
            int pos = chPos.get(ch) == null ? -1: chPos.get(ch);
            left = Math.max(left, pos);
            max = Math.max(max, i - left);
            chPos.put(ch, i);
        }
        return max;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring t = new LengthOfLongestSubstring();
//*
        System.out.println(t.lengthOfLongestSubstring("abcabcbb"));
        System.out.println("Input: \"abcabcbb\"\n" + "Output: 3");
        System.out.println();
///*
        System.out.println(t.lengthOfLongestSubstring("bbbbb"));
        System.out.println("Input: \"bbbbb\"\n" + "Output: 1");
        System.out.println();
//*/
        System.out.println(t.lengthOfLongestSubstring("pwwkew"));
        System.out.println("Input: \"pwwkew\"\n" + "Output: 3\n"
                           + "Explanation: The answer is \"wke\", with the length of 3. \n"
                           + "             Note that the answer must be a substring, \"pwke\" is a subsequence and not a substring.\n");
        System.out.println();
//        System.out.println( new sample().lengthOfLongestSubstring("pwwkew"));
//*
        System.out.println(t.lengthOfLongestSubstring(" "));
        System.out.println("Input: \" \"\n" + "Output: 1");
        System.out.println();

        System.out.println(t.lengthOfLongestSubstring("aab"));
        System.out.println("Input: \"aab\"\n" + "Output: 2");
        System.out.println();

        System.out.println(t.lengthOfLongestSubstring("dvdf"));
        System.out.println("Input: \"dvdf\"\n" + "Output: 3");
        System.out.println();

        System.out.println(t.lengthOfLongestSubstring("abba"));
        System.out.println("Input: \"abba\"\n" + "Output: 2");
        System.out.println();
//*/
    }
}
