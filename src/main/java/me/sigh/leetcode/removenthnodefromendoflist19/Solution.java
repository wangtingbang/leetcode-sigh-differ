package me.sigh.leetcode.removenthnodefromendoflist19;


//TODO
public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode left = head, right = head.next;
        int window = 0;
        while (right != null) {

            if (window < n) {
                window++;
            } else {
                left = left.next;
            }
            right = right.next;
        }

        left.next = left.next == null ? null : left.next.next;


        if(left.next==null&&window==0){
            head =null;
        }
        if(left == head&&window == n){
            head = head.next;
        }


        return head;
    }
}
