package me.sigh.leetcode.minstack;



//wrong
public class MinStackArray {


    private int data;
    private int min;
    private static int pos;
    private static MinStackArray[] array = new MinStackArray[100];


    public MinStackArray() {
        min = 0;
        data = 0;
    }

    public void push(int x) {

        MinStackArray node = new MinStackArray();
        node.data = x;
        if (pos == 0) {
            node.min = x;
        } else {
            node.min = x < array[pos-1].min ? x : array[pos-1].min;
        }
        array[pos] = node;
        pos++;
    }

    public void pop() {
        array[pos] = null;
        pos--;
    }

    public int top() {
        return array[pos-1].data;
    }

    public int getMin() {
        return array[pos-1].min;
    }

    public void traverse() {
        for (int i = 0; i < pos; i++) {
//            System.out.printf(" ->i: %d %2d (%2d  )", i, array[i].data, array[i].min);
        }
//        System.out.println();
    }

    public static void main(String[] args) {

        System.out.println("=============================");
        System.out.println("*****************************");
        int min, top;

        MinStackArray minStack = new MinStackArray();
        minStack.push(-1);
//        minStack.push(0);
//        minStack.push(-3);
//        min = minStack.getMin();  // --> Returns -3.
//        System.out.println("min: " + min);
//        minStack.pop();

        top = minStack.top();     // --> Returns 0.

        System.out.println("top: " + top);
        min = minStack.getMin();   //--> Returns -2.
        System.out.println("min: " + min);
        System.out.println("*****************************");
        System.out.println("=============================");
    }
}
