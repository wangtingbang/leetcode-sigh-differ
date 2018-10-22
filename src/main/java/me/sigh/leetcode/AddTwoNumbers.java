package me.sigh.leetcode;

/**
 * https://leetcode.com/problems/add-two-numbers/
 * # 2
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l0, ListNode l1) {

        ListNode node0 = l0;
        ListNode node1 = l1;
        ListNode result = null;
        ListNode head = null;
        int carry = 0;

        if (node0.next == null && node0.val == 0) {
            return node1;
        }
        if (node1.next == null && node1.val == 0) {
            return node0;
        }

        do {
            int addend0 = node0 == null ? 0 : node0.val;
            int addend1 = node1 == null ? 0 : node1.val;
            int sum = addend0 + addend1 + carry;
            int left = 0;
            if (sum >= 10) {
                left = sum % 10;
                carry = sum / 10;
            } else {
                left = sum;
            }

            ListNode tmp = null;
            if (carry > 0) {
                tmp = new ListNode(left);
                carry = 0;
            } else {
                tmp = new ListNode(left);

            }

            carry = sum >= 10 ? sum / 10 : 0;

            if (result == null) {
                result = tmp;
                head = result;
            } else {
                result.next = tmp;
                result = result.next;
            }

            node0 = node0 == null ? null : node0.next;
            node1 = node1 == null ? null : node1.next;
        } while (node0 != null || node1 != null);

        if (carry > 0) {
            result.next = new ListNode(carry);
        }

        return head;
    }


    public static void traverse(ListNode l) {
        System.out.println();
        ListNode node1 = l;
        do {
            System.out.printf("%d  ", node1.val);
            node1 = node1.next;
        } while (node1 != null);
        System.out.println();
    }

    public static ListNode build(int... args) {

        ListNode result = null;
        ListNode head = null;
        for (int i : args) {
            if (result != null) {
                ListNode tmp = new ListNode(i);
                result.next = tmp;
                result = result.next;
            } else {
                result = new ListNode(i);
                head = result;
            }
        }

        return head;
    }

    public static void main(String[] args) {

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

                traverse(
                    addTwoNumbers.addTwoNumbers(build(new int[] {2, 4, 3}), build(new int[] {5, 6, 4})));
                System.out.println("Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)\n" + "Output: 7 -> 0 -> 8");

        //        traverse(
        //            addTwoNumbers.addTwoNumbers(build(new int[] {2, 4, 3}), build(new int[] {5, 6, 1})));
        //        System.out.println("Input: (2 -> 4 -> 3) + (5 -> 6 -> 1)\n" + "Output: 4 -> 0 -> 8");


                traverse(addTwoNumbers.addTwoNumbers(build(new int[] {9, 8}), build(new int[] {1})));
                System.out.println("Input: (9 -> 8) + (1)\n" + "Output: 0 -> 9");

                traverse(addTwoNumbers.addTwoNumbers(build(new int[] {5}), build(new int[] {5})));
                System.out.println("Input: (5) + (5)\n" + "Output: 0 -> 1");

        traverse(addTwoNumbers.addTwoNumbers(build(new int[] {1}), build(new int[] {9, 9})));
        System.out.println("Input: (1) + (9 -> 9)\n" + "Output: 0 -> 0 -> 1");
    }

}
