package 算法练习第一天5月12日;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 * 输入{1,2,3}
 * 输出{3,2,1}
 */
public class Day_01 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(3);
        System.out.println(resever(listNode));

    }

    //将单链表原地逆转(栈方法)
    public static void reservse(ListNode head){
        if(head.next == null){
            return;
        }
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode cur = head.next;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        while (stack.size() > 0){
            System.out.println(stack.pop());
        }
    }


    public static ListNode resever(ListNode head){
        Stack<ListNode> stack = new Stack<>();
        //入栈
        while (head != null){
            stack.push(head);
            head = head.next;
        }
        //出栈
        ListNode node = stack.pop();
        ListNode temp = node;
        while (!stack.isEmpty()){
            ListNode listNode = stack.pop();
            node.next = listNode;
            node = node.next;
        }
        return temp;
    }

    public static ListNode reseverList(ListNode head){
        Stack<ListNode> stack = new Stack<>();
        while (head != null){
            stack.push(head);
            head = head.next;
        }
        ListNode node = stack.pop();
        ListNode temp = node;//反转后的链表信息
        while (!stack.isEmpty()){
            ListNode listNode = stack.pop();
            node.next = listNode;
            node = node.next;
        }
        return temp;
    }

    /**
     * 输入两个无环的单链表，找出它们的第一个公共结点。
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2==null){
            return null;
        }
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2){
            p1 = p1 == null ? pHead2 : p1.next;
            p2 = p2 == null ? pHead1 : p2.next;
        }
        return p1;
    }

    /**
     * 对于一个给定的链表，返回环的入口节点，如果没有环，返回null
     * 拓展：
     * 你能给出不利用额外空间的解法么？
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){                 //利用快慢指针找相遇点
                ListNode slow2 = head;    //设置以相同速度的新指针从起始位置出发
                while(slow2 != slow){      //未相遇循环。
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }

    /**
     * 判断链表是否含有环？
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        //快慢两个指针
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            //慢指针每次走一步
            slow = slow.next;
            //快指针每次走两步
            fast = fast.next.next;
            //如果相遇，说明有环，直接返回true
            if (slow == fast)
                return true;
        }
        //否则就是没环
        return false;
    }

    /**
     * 链表中倒数第k个节点
     * @param pHead
     * @param k
     * @return
     */
    public ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here
        ListNode first = pHead;
        for(int  i= 0;i<k;i++){
            if(first == null) {
                return first;
            }
            first = first.next;
        }
        ListNode last = pHead;
        while(first!=null){
            first = first.next;
            last = last.next;
        }
        return last;
    }

    /**
     * 合并有序链表
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        //先处理头
        ListNode head = (l1.val <= l2.val)? l1:l2;
        ListNode tail = head;
        l1 = (head == l1)? l1.next:l1;
        l2 = (head == l2)? l2.next:l2;
        while(l1 != null && l2 != null)
        {
            if(l1.val <= l2.val){
                tail.next = l1;
                l1 = l1.next;
            }else{
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = (l1 == null)? l2 : l1;
        return head;
    }
}


class ListNode{
    public int val;
    public ListNode next = null;
    public ListNode(int val){
        this.val = val;
    }
}
