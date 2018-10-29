package me.sigh.leetcode.sort.insertinterval;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Interval {

    public int start;
    public int end;

    public Interval() {
    }

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override public String toString() {
        return "[" + this.start + "," + this.end + "]";
    }

    public List<Interval> insert(List<Interval> input, Interval newInterval) {

        if (input == null || input.isEmpty()) {
            return new ArrayList<>();
        }
        int size = input.size();

        List<Interval> result = new ArrayList<>();

        //position
        int start = 0;
        int end = 0;

        Interval virtual = null;
        for (int i = 0; i < size && end != 0; i++) {
            Interval node = input.get(i);

            if(node.start >newInterval.start){

            }
        }

        Interval nodeStart = input.get(start);
        Interval nodeEnd = input.get(end);

        result = input.subList(0, start).stream().collect(Collectors.toList());


        return result;
    }
}
