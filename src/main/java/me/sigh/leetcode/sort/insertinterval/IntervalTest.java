package me.sigh.leetcode.sort.insertinterval;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class IntervalTest {


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

    public static void test(Interval t, List<Interval> exp, List<Interval> input, Interval newInt) {

        List<Interval> result = t.insert(input, newInt);
        System.out.printf("%5c     | %-30s | %-30s | %-30s \n", isEqual(exp, result) ? 'Y' : 'N',
            convertString(exp), convertString(result),
            "[" + newInt.start + "," + newInt.end + "] -> " + convertString(input));
        System.out.println(
            "----------|--------------------------------|--------------------------------|----------------------------------");
    }

    public static void main(String[] args) {

        Interval t = new Interval();

        System.out.println(
            "= passed =|========== expected ============|========== actual ==============|=============== input ==================");

        //*
        test(t,                             //
            Lists.newArrayList(             //
                new Interval(1, 5),         //
                new Interval(6, 9)        //
            ),                              //
            Lists.newArrayList(             //
                new Interval(1, 3),         //
                new Interval(6, 9)),      //
            new Interval(2, 5));

        test(t,                             //
            Lists.newArrayList(             //
                new Interval(1, 2),        //
                new Interval(3, 10),        //
                new Interval(12, 16)        //
            ),                              //
            Lists.newArrayList(             //
                new Interval(1, 2),         //
                new Interval(3, 5),         //
                new Interval(6, 7),         //
                new Interval(8, 10),        //
                new Interval(12, 16)         //
            ),        //
            new Interval(4, 8)               //
        ); //*/

    }

}
