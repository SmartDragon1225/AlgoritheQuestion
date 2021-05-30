package 剑职offer经典算笔试编程题.包含main函数的栈;

import java.util.Stack;

public class MainStack {
    public static void main(String[] args) {

    }

    Stack<Integer> A, B;
    public MainStack() {
        A = new Stack<>();
        B = new Stack<>();
    }
    public void push(int x) {
        A.add(x);
        if(B.empty() || B.peek() >= x)
            B.add(x);
    }
    public void pop() {
        if(A.pop().equals(B.peek()))
            B.pop();
    }
    public int top() {
        return A.peek();
    }
    public int min() {
        return B.peek();
    }

}
