package me.sigh.leetcode.singlenumber;

public class Example0ms {

    public int singleNumber(int[] nums) {
        int ret = nums[0];
        int len = nums.length;
        int i;
        for (i = 1; i < len; i++) {
            int before = ret;
            ret = ret ^ nums[i];
            System.out.printf("ret: %d -> %d, num[%d]: %d\n", before, ret, i , nums[i]);
        }
        return ret;
    }


    public static void main(String[] args) {
        Example0ms example = new Example0ms();

//        System.out.println("exp: 1, actual: " + example.singleNumber(new int[] {2, 2, 1}));
        System.out
            .println("exp: 4, actual: " + example.singleNumber(new int[] {1, 1, 2, 2, 4 }));
    }
}
