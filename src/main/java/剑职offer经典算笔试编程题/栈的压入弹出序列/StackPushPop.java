package 剑职offer经典算笔试编程题.栈的压入弹出序列;

import java.util.Stack;

public class StackPushPop {
    public static void main(String[] args) {

    }

    /**
     * 判断入栈和出栈的顺序是否一致
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for(int num : pushed) {
            stack.push(num); // num 入栈       peek() 返回栈顶元素，但不在堆栈中删除它。
            while(!stack.isEmpty() && stack.peek() == popped[i]) { // 循环判断与出栈
                stack.pop();                 //pop() 返回栈顶元素，并在进程中删除它
                i++;
            }
        }
        return stack.isEmpty();
    }
}
