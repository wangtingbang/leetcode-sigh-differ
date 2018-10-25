package me.sigh.leetcode.minstack;



public class MinStackLink {


    private int data;
    private MinStackLink next;
    private int min;
    private MinStackLink head;


    public MinStackLink() {
        min = 0;
        data = 0;
        next = null;
        head = null;
    }

    public void push(int x) {

        System.out.printf("push(%2d  ): ", x);

        if (head == null) {
            head = new MinStackLink();
            head.data = x;
            head.min = x;
            this.traverse();
            return;
        }

        MinStackLink node = new MinStackLink();

        node.data = x;
        node.min = x < head.min? x: head.min;
        node.next = head;
        head = node;
    }

    public void pop(){
        MinStackLink top = head;

        System.out.printf("pop (%2d  ): ", top.data);
        head = head.next;
    }

    public int top() {

        if (head == null) {
            return 0;
        }
        return head.data;
    }

    public int getMin() {
        return head.min;
    }

    public void traverse() {
        MinStackLink node = head;
        while (node != null) {
            System.out.printf(" -> %2d (%2d  )", node.data, node.min);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        System.out.println("=============================");
        System.out.println("*****************************");
        int min, top;

        MinStackLink minStack = new MinStackLink();
        minStack.push(-1);
        minStack.traverse();
        minStack.push(-2);
        minStack.traverse();
        minStack.push(0);
        minStack.traverse();
        minStack.push(-3);
        minStack.traverse();
        min = minStack.getMin();  // --> Returns -3.
        System.out.println("min: " + min);
        minStack.pop();
        minStack.traverse();

        top = minStack.top();     // --> Returns 0.

        System.out.println("top: " + top);
        min = minStack.getMin();   //--> Returns -2.
        System.out.println("min: " + min);
        System.out.println("*****************************");
        System.out.println("=============================");
    }
}
