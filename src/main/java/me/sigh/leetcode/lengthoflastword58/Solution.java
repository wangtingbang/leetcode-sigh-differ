package me.sigh.leetcode.lengthoflastword58;

public class Solution {

    public int lengthOfLastWord(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        int count = 0;
        char[] arr = s.toCharArray();
        for(int i = arr.length-1; i>=0; i--){
            if(' '!= arr[i]){
                count++;
            }else if(count>0){

                break;
            }
        }

        return count;
    }
}
