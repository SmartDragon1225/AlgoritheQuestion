package 算法练习第三天5月14日;

public class 从头到位打印链表 {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        LinkedList linkedList = new LinkedList();
        linkedList.add(node1);
        linkedList.add(node2);
        linkedList.add(node3);
        System.out.println(linkedList);
        printList(linkedList.getHead());
    }

    /**
     * 从头到尾打印链表
     * @param node
     */
    public static void printList(Node node){
        if(node != null){
            printList(node.next);
        }
        System.out.println(node);
    }
}

class LinkedList{
    private Node head = null;

    public Node getHead() {
        return head;
    }

    public void add(Node node){
        Node temp = head;
        while (true){
            if(temp.next == null)
                break;
            temp = temp.next;
        }
        temp.next = node;
    }
    public void list(){

    }
}
class Node{
    private int value;
    public Node next;

    public Node(){}

    public Node(int value){
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}
