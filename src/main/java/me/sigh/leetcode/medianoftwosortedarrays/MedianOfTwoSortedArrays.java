package me.sigh.leetcode.medianoftwosortedarrays;

// TODO
public class MedianOfTwoSortedArrays {

    public void traverse(int n[], int m[]) {

        for (int i = 0, j = 0; ; ) {
            System.out.printf("%d -> [%d]  %d -> [%d] \n", i, n[i], j, m[j]);
            //            System.out.printf("%d %d\n", i, j);
            if (n[i] >= m[j]) {
                double t = (n[i] + m[j]) / 2;
                System.out.println(t);
                break;
            }
            if (i >= n.length - 1 && j >= m.length - 1) {
                break;
            }
            if (i < n.length - 1)
                i++;
            if (j < m.length - 1)
                j++;
        }
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays t = new MedianOfTwoSortedArrays();
        //                System.out.println(t.findMedianSortedArrays(new int[] {1, 2}, new int[] {3}));
        t.traverse(new int[] {1, 3}, new int[] {2});
        t.traverse(new int[] {1, 2}, new int[] {3, 4});

        //        System.out.println(t.findMedianSortedArrays(new int[] {1, 2}, new int[] {3, 4}));
    }
}
