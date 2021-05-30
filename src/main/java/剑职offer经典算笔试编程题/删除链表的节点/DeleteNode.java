package 剑职offer经典算笔试编程题.删除链表的节点;


public class DeleteNode {
    public static void main(String[] args) {

    }

    /**
     * 删除链表节点，双指针法
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode(ListNode head, int val) {
        if(head.val == val)
            return head.next;
        ListNode pre = head, cur = head.next;
        while(cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if(cur != null)  //找到要删除的位置
            pre.next = cur.next; //删除核心代码
        return head;
    }

    public ListNode delete(ListNode head,int val){
        if(head == null){
            return null;
        }
        ListNode temp = head;
        while (temp.next!=null && head.next.val != val){
            temp = temp.next;
        }
        if(temp.next != null){
            temp.next = temp.next.next;
        }
        return head;
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
