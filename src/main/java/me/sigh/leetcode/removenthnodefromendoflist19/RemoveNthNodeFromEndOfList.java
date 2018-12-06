package me.sigh.leetcode.removenthnodefromendoflist19;

public class RemoveNthNodeFromEndOfList {

    static ListNode build(int... nums) {
        ListNode head = new ListNode(nums[0]);
        ListNode current = head;
        for (int i = 1; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            current.next = node;
            current = current.next;
        }
        return head;
    }

    static void retrieve(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.printf(" -> %d", current.val);
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode list = build(1, 2, 3, 4, 5);
        retrieve(list);
        ListNode removed = solution.removeNthFromEnd(list, 2);
        retrieve(removed);


        list = build(1);
        retrieve(list);
        removed = solution.removeNthFromEnd(list, 1);
        retrieve(removed);

        list = build(1, 2);
        retrieve(list);
        removed = solution.removeNthFromEnd(list, 2);
        retrieve(removed);

    }
}
