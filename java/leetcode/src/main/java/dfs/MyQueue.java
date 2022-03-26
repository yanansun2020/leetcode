package dfs;

import java.util.Stack;

class MyQueue {
    int front;
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();

    public void push(int x) {
        if (s1.empty())
            front = x;
        while (!s1.isEmpty())
            s2.push(s1.pop());
        s2.push(x);
        while (!s2.isEmpty())
            s1.push(s2.pop());
    }

    // Removes the element from in front of queue.
    public void pop() {
        s1.pop();
        if (!s1.empty()){
            Integer tmp = s1.peek();
            front = tmp;
        }

    }

    // Get the front element.
    public int peek() {
        return front;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return s1.isEmpty();
    }
}
