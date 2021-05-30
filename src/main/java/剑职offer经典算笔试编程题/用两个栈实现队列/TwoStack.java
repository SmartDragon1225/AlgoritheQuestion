package 剑职offer经典算笔试编程题.用两个栈实现队列;

import java.util.Deque;
import java.util.LinkedList;

public class TwoStack {
    public static void main(String[] args) {

    }


}

class StackQueue{
    Deque<Integer> stack1;
    Deque<Integer> stack2;
    public StackQueue(){
        stack1 = new LinkedList<Integer>();
        stack2 = new LinkedList<Integer>();
    }

    public void add(int value){
        stack1.push(value); //直接入栈即可
    }

    public int delete(int value){
        //判断
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if(stack2.isEmpty()){
            return -1;
        }else {
            int deletenum = stack1.pop();
            return deletenum;
        }
    }
}
