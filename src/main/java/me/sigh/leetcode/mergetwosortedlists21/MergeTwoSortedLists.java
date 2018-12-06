package me.sigh.leetcode.mergetwosortedlists21;

import com.alibaba.fastjson.JSONObject;

public class MergeTwoSortedLists {


    public static boolean isEqual(ListNode exp, ListNode result) {

        return retrieveString(exp).equals(retrieveString(result));
    }

    public static ListNode build(int[] data) {
        ListNode head = new ListNode(data[0]);
        ListNode pre = head;
        for (int i = 1; i < data.length; i++) {
            ListNode node = new ListNode(data[i]);
            pre.next = node;
            pre = pre.next;
        }
        return head;
    }

    public static void retrieve(ListNode list){
        ListNode current = list;
        while(current!=null){
            System.out.printf( " -> %d", current.val);
            current = current.next;
        }

        System.out.println();
    }

    public static String retrieveString(ListNode list){
        ListNode current = list;
        StringBuffer sb = new StringBuffer();
        while(current!=null){
            sb.append(String.format(" -> %d", current.val));
            current = current.next;
        }
        return sb.toString();
    }



    public static void test(Solution t, ListNode exp, ListNode[] input) {


        String inputString = retrieveString(input[0]) + " and " + retrieveString(input[1]);

        ListNode result = t.mergeTwoLists(input[0], input[1]);
        System.out.printf("%5c     | %-30s | %-30s | %-30s \n",
                isEqual(exp, result) ? 'Y' : 'N',
                retrieveString(exp),
                retrieveString(result),
                inputString);
        System.out.println(
                "----------|--------------------------------|--------------------------------|----------------------------------");
    }

    public static void main(String[] args) {

        Solution t = new Solution();

        System.out.println(
                "= passed =|========== expected ============|========== actual ==============|=============== input ==================");
        test(t,
                build(new int[]{ -10,-9,-6,-5,-4,-3,0,1,7,8,8,9,9}),
                new ListNode[]{build( new int[]{-10,-9,-6,-4,1,9,9}), build(new int[]{-5,-3,0,7,8,8})});

        test(t,
                build(new int[]{-9,3,5,7}),
                new ListNode[]{build( new int[]{-9,3}), build(new int[]{5,7})});

        test(t,
                build(new int[]{1,2}),
                new ListNode[]{build( new int[]{2}), build(new int[]{1})});
        test(t,
                build(new int[]{1,1,2,3,4,4}),
                new ListNode[]{build( new int[]{1,2,4}), build(new int[]{1,3,4})});

        test(t,
                build(new int[]{1,2, 4, 5}),
                new ListNode[]{build( new int[]{5}), build(new int[]{1,2,4})});


    }

}
