package com.example.algo101.ds.stack;

// Array based stack
class MStack {
    private int top = -1;
    private int size;
    private int[] memory;

    public MStack(int size) {
        this.size = size;
        this.memory = new int[size];
    }

    public int top() throws Exception {
        if (this.top != -1) return memory[top];
        throw new Exception("Stack is empty");
    }

    public void push(int data) throws Exception {
        if (top == this.size - 1) {
            throw new Exception("Stack is full");
        }
        memory[++top] = data;
    }

    public void pop() throws Exception {
        if (top == -1) throw new Exception("Stack is empty");
        --top;
    }

    public boolean isFull() {
        if (top == this.size - 1) return true;
        return false;
    }


    public boolean isEmpty() {
        if (top == -1) return true;
        return false;
    }

}


public class DemoStack {

    public static void main(String[] args) {

        MStack stack = new MStack(5);

        System.out.println(stack.isEmpty());
        System.out.println(stack.isFull());

        try {
            stack.push(1);
            stack.push(2);
            stack.push(3);
            stack.push(4);
            stack.push(5);

            stack.pop();
            stack.pop();
            System.out.println("After 2 pops, " + stack.top());
        } catch (Exception e) {
            System.out.println(e.toString());
        }


    }
}
