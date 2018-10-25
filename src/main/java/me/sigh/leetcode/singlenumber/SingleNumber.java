package me.sigh.leetcode.singlenumber;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SingleNumber {

    public int singleNumber(int[] nums) {

        int len = nums.length;
        Set<Integer> check = new HashSet<>(len / 2 + 1);
        Set<Integer> other = new HashSet<>(len / 2 + 1);

        for(int i=0;i< len; i++){
            int num = nums[i];
            if(check.contains(num)){
                other.add(num);
            }else {
                check.add(num);
            }
        }

        Iterator<Integer> itr = check.iterator();
        while (itr.hasNext()){
            int num = itr.next();
            if(!other.contains(num)){
                return num;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();

        System.out.println("exp: 1, actual: " + singleNumber.singleNumber(new int[] {2, 2, 1}));
        System.out
            .println("exp: 4, actual: " + singleNumber.singleNumber(new int[] {4, 1, 2, 1, 2}));

        System.out.println("exp: 3, actual: " + singleNumber.singleNumber(new int[] {2,2,3,2}));
        System.out.println("exp: 99, actual: " + singleNumber.singleNumber(new int[] {0,1,0,1,0,1,99}));
    }
}
