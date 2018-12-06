package me.sigh.leetcode.searchinsertposition;

public class SearchInsertPosition {


    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.printf("%d => %d\n", 2, solution.searchInsert(new int[] {1, 3, 5, 6}, 5));
        System.out.printf("%d => %d\n", 1, solution.searchInsert(new int[] {1, 3, 5, 6}, 2));
        System.out.printf("%d => %d\n", 4, solution.searchInsert(new int[] {1, 3, 5, 6}, 7));
        System.out.printf("%d => %d\n", 0, solution.searchInsert(new int[] {1, 3, 5, 6}, 0));
        System.out.printf("%d => %d\n", 1, solution.searchInsert(new int[] {1}, 2));
        System.out.printf("%d => %d\n", 0, solution.searchInsert(new int[] {1, 2, 3}, 1));
        System.out.printf("%d => %d\n", 1, solution.searchInsert(new int[] {1, 3}, 3));
    }

}
