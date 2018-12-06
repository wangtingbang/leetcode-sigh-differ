package me.sigh.leetcode.mergetwosortedlists21;

class Solution {

    //*
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode i1 = l1.val <= l2.val ? l1 : l2, i2 = l1.val <= l2.val ? l2 : l1;
        ListNode head = i1, last = null;
        while (i1 != null && i2 != null) {

            if (i1.val <= i2.val) {
                ListNode next1 = null;
                while (i1.next != null && i1.next.val < i2.val) {
                    i1 = i1.next;
                }
                next1 = i1.next;
                ListNode next2 = i2.next;
                i1.next = i2;
                i2.next = next1;
                i1 = i2.next;
                if(i1 == null){
                    last = i2;
                }

                i2 = next2;
            } else {
                i1 = i1.next;
            }
        }

        if (last !=null && i2 != null) {
            last.next = i2;
        }

        return head;
    }
    /*/

    /*
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head = null;
        if (l1.val <= l2.val) {
            head = new ListNode(l1.val);
            l1 = l1.next;
        } else {
            head = new ListNode(l2.val);
            l2 = l2.next;
        }

        ListNode i1 = l1, i2 = l2, pre = head;

        ListNode node = null;
        while (i1 != null && i2 != null) {
            if (i1.val <= i2.val) {
                node = new ListNode(i1.val);
                i1 = i1.next;
            } else {
                node = new ListNode(i2.val);
                i2 = i2.next;
            }
            pre.next = node;
            pre = pre.next;
        }

        if (i1 != null) {
            pre.next = i1;
        }
        if (i2 != null) {
            pre.next = i2;
        }
        return head;
    }
    */

    /*
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode dummy = new ListNode(0);

        if (l1.val < l2.val) {
            dummy.next = l1;
            l1 = l1.next;
        } else {
            dummy.next = l2;
            l2 = l2.next;
        }

        ListNode cur = dummy.next;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }

        if (l1 != null) {
            cur.next = l1;
        }

        if (l2 != null) {
            cur.next = l2;
        }

        return dummy.next;
    }
    */
}

