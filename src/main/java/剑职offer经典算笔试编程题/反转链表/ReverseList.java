package 剑职offer经典算笔试编程题.反转链表;

public class ReverseList {
    public static void main(String[] args) {

    }

    /**
     * 递归反转链表
     * @param head
     * @return
     */
    public static Node reverseList(Node head){
        if(head ==null || head.next ==null){
            return head;
        }
        Node newNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return head;
    }

    /**
     * 迭代反转链表
     * @param head
     * @return
     */
    public static Node reverseList1(Node head){
        Node pre = null;
        Node cur = head;
        while (cur !=null){
             Node next = cur.next;
             cur.next = pre;
             pre = cur;
             cur = next;
        }
        return pre;
    }

}


class Node{
    Node next;
    int val;
    Node(int val){
        this.val = val;
    }
}