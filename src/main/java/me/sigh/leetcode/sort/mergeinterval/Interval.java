package me.sigh.leetcode.sort.mergeinterval;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class Interval {

    private int start;
    private int end;

    public Interval() {
    }

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override public String toString() {
        return "[" + this.start + "," + this.end + "]";
    }

    public List<Interval> merge(List<Interval> input) {

        if (input == null || input.isEmpty()) {
            return new ArrayList<>();
        }
        int size = input.size();

        // sort
        Interval[] intervals = new Interval[size];
        input.toArray(intervals);
        intervals[0]=input.get(0);
        for(int i = 1; i< input.size(); i++){

            for( int j = 0; j < i; j++){
                if(intervals[i].start<intervals[j].start){
                    Interval tmp = intervals[i];
                    intervals[i] = intervals[j];
                    intervals[j] = tmp;
                }
            }
        }

        // merge
        List<Interval> result = new ArrayList<>();
        result.add(intervals[0]);
        Interval tail = result.get(0);
        for (int i = 1; i < size; i++) {

            Interval node = intervals[i];

            if(tail.start > node.end){
                result.remove(result.size()-1);
                result.add(node);
                result.add(tail);
                continue;
            }
            if (tail.start > node.start) {
                tail.start = node.start;
            }
            if (tail.end > node.end) {
                continue;
            }
            if (tail.end >= node.start) {
                tail.end = node.end;
            } else {
                tail = new Interval(node.start, node.end);
                result.add(tail);
            }
        }

        return result;
    }

    private static boolean isEqual(List<Interval> i1, List<Interval> i2) {

        if (i1 == null && i2 == null) {
            return true;
        }

        if (i1.size() != i2.size())
            return false;

        for (int i = 0; i < i1.size(); i++) {
            Interval in1 = i1.get(i);
            Interval in2 = i2.get(i);

            if (in1.start != in2.start)
                return false;

            if (in1.end != in2.end)
                return false;
        }

        return true;
    }

    private static String convertString(List<Interval> input) {

        if (input == null || input.isEmpty()) {
            return "[]";
        }
        StringBuffer sb = new StringBuffer("[");
        for (int i = 0; i < input.size() - 1; i++) {
            sb.append(input.get(i).toString() + ",");
        }
        sb.append(input.get(input.size() - 1).toString());
        sb.append("]");
        return sb.toString();
    }

    public static void test(Interval t, List<Interval> exp, List<Interval> input) {

        List<Interval> result = t.merge(input);
        System.out.printf("%5c     | %30s | %30s | %30s \n", isEqual(exp, result) ? 'Y' : 'N',
            convertString(exp), convertString(result), convertString(input));
        System.out.println(
            "----------|--------------------------------|--------------------------------|----------------------------------");
    }

    public static void main(String[] args) {

        Interval t = new Interval();

//        System.out.println("  passed  |\t\t\texpected\t\t |\t\t\tactual\t\t\t|\tinput");
        System.out.println(
            "= passed =|========== expected ============|========== actual ==============|=============== input ==================");
//        System.out.println(
//            "==========|================================|================================|========================================");

        //*
        test(t,                             //
            Lists.newArrayList(             //
                new Interval(1, 6),         //
                new Interval(8, 10),        //
                new Interval(15, 18)        //
            ),                              //
            Lists.newArrayList(             //
                new Interval(1, 3),         //
                new Interval(2, 6),         //
                new Interval(8, 10),        //
                new Interval(15, 18)));

        test(t,                             //
            Lists.newArrayList(             //
                new Interval(1, 5)        //
            ),                              //
            Lists.newArrayList(             //
                new Interval(1, 4),         //
                new Interval(4, 5))); //*/

        test(t,                             //
            Lists.newArrayList(             //
                new Interval(0, 4)        //
            ),                              //
            Lists.newArrayList(             //
                new Interval(1, 4),          //
                new Interval(0, 1)));

        test(t,                             //
            Lists.newArrayList(             //
                new Interval(0,0),          //
                new Interval(1, 4)        //
            ),                              //
            Lists.newArrayList(             //
                new Interval(1, 4),          //
                new Interval(0, 0)));


        test(t,                             //
            Lists.newArrayList(             //
                new Interval(1, 10)        //
            ),                              //
            Lists.newArrayList(             //
                new Interval(2, 3),          //
                new Interval(4, 5),          //
                new Interval(6, 7),          //
                new Interval(8, 9),          //
                new Interval(1, 10)));
    }

}
