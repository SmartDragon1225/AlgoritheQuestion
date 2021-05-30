package 剑职offer经典算笔试编程题.从头到尾打印链表;


import java.util.*;

public class LinkedNode {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
        hashMap.put("1",new ArrayList<>());
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new String(String.valueOf(i)));
        }
        hashMap.put("Map",list);
    }

    /**从尾到头打印链表
     * 利用栈的特性(先入栈，再出栈)。
     * @param head
     * @return
     */
    public int[] reversePrint(Node head) {
        Stack<Node> stack = new Stack<Node>();
        Node temp = head;
        while (temp != null){
             stack.push(temp);
             temp = temp.next;
        }
        int arr[] = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            arr[i] = stack.pop().value;
        }
        return arr;
    }

    /** 利用队列的特性
     * 从头到尾打印链表
     * @param head
     */

    public int[] Print(Node head) {
        Queue<Node> queue = new LinkedList<>();
        Node temp = head;
        while (temp != null){
            queue.add(temp);
            temp = temp.next;
        }
        int arr[] = new int[queue.size()];
        for (int i = 0; i < queue.size(); i++) {
            arr[i] = queue.poll().value;
        }
        return arr;
    }

    /**
     *
     * @param head
     */
    public static void printList(Node head){
        if(head != null){
            if(head.next != null){
                printList(head.next);
            }
            System.out.println(head);
        }
    }
}

class Node{
    int value;
    public Node next;
    public Node(int x){
        value = x;
    }
}