package 算法练习第六天5月17日.二叉树的复习;

import java.util.*;

public class 二叉树 {
    public static void main(String[] args) {
        Node root = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        //建立二叉树
        root.setLeft(node1);
        root.setRight(node2);
        node1.setLeft(node3);
        node2.setRight(node4);
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.setRoot(root);//建立二叉树！
        //测试
        binaryTree.preOrder();
        ArrayList list = new ArrayList();
        binaryTree.preOrderByTree(root,list);
        System.out.println(list);
        /*binaryTree.midOrderByTree();
        binaryTree.postOrderByTree();
        binaryTree.levelOrder();*/
    }
}

class Node{
    public int value;
    private Node left;
    private Node right;

    public Node(int v){
        value = v;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    //前序遍历
    public void preOrder(){
        System.out.print(this+"=>");
        if(this.left != null){
            this.left.preOrder();
        }
        if(this.right != null){
            this.right.preOrder();
        }
    }
    //前序遍历
    public void preOrder11(Node root){
        ArrayList<Node> pre = new ArrayList<>();
        pre.add(root);
        if(root.left!=null){
            preOrder11(root.left);
        }
        if(root.right != null){
            preOrder11(root.right);
        }
    }
    //中序遍历
    public void midOrder11(Node root){
        //mid.add(root);
        ArrayList<Node> mid = new ArrayList<>();
        if(root.left!=null){
            midOrder11(root.left);
        }
        mid.add(root);
        if(root.right != null){
            midOrder11(root.right);
        }
    }

    //前序遍历
    public void postOrder11(Node root,ArrayList pre){
        //pre.add(root);
        ArrayList<Node> post = new ArrayList<>();
        if(root.left!=null){
            post.add(root.left);
        }
        if(root.right != null){
            post.add(root.right);
        }
        pre.add(root);
    }

    //后序遍历
    public void postOrder(Node root,ArrayList list){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            if(node.left != null){
                stack.push(node.left);
            }
            if(node.right != null){
                stack.push(node.right);
            }
        }
    }
    //中序遍历
    public void midorder(Node root, List<Integer> list) {
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                list.add(0, curr.value);
                curr = curr.right;
            } else {
                curr = stack.pop();
                curr = curr.left;
            }
        }
    }

    //中序遍历
    public void midOreder(){
        if(this.left != null){
            this.left.preOrder();
        }
        System.out.println(this);
        if(this.right != null){
            this.right.preOrder();
        }
    }

    //后序遍历
    public void postOrder(){
        if(this.left != null){
            this.left.preOrder();
        }
        if(this.right != null){
            this.right.preOrder();
        }
        System.out.println(this);
    }

    //二叉树的BFS层次遍历（队列结局）
    public ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        //边界条件判断
        if (root == null)
            return new ArrayList<>();
        //队列
        Queue<Node> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        //根节点入队
        queue.add(root);
        //如果队列不为空就继续循环
        while (!queue.isEmpty()) {
            //BFS打印，levelNum表示的是每层的结点数
            int levelNum = queue.size();
            //subList存储的是每层的结点值
            ArrayList<Integer> subList = new ArrayList<>();
            for (int i = 0; i < levelNum; i++) {
                //出队
                Node node = queue.poll();
                subList.add(node.value);
                //左右子节点如果不为空就加入到队列中
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            //把每层的结点值存储在res中，
            res.add(subList);
        }
        return res;
    }

    public ArrayList<ArrayList<Integer>> levelOrder1 (Node root) {
        // write code here
        if(root == null){
            return new ArrayList<>();
        }
        Queue<Node> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();//结果集合
        queue.add(root);
        while (!queue.isEmpty()){
            int num = queue.size();
            ArrayList<Integer> list = new ArrayList<>();//每个层次节点的个数
            for (int i = 0; i < num; i++) {
                Node node = queue.poll();
                list.add(node.value);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }

    public ArrayList<ArrayList<Integer>> levelOrder2(Node root){
        if(root == null){
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();//结果集
        Queue<Node> queue = new LinkedList<>();//队列
        while (!queue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();//每一层的节点数
            for (int i = 0; i < queue.size(); i++) {
                Node node = queue.poll();
                list.add(node.value);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }

    //先序遍历
    public ArrayList<ArrayList<Integer>> preOrder(Node root){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(root.value);
        if(root.left != null){
            list.add(root.left.value);
            preOrder(root.left);
        }
        if(root.right != null){
            list.add(root.right.value);
            preOrder(root.right);
        }
        result.add(list);
        return result;
    }

    //求数的深度
    public static int TreeDead(Node root){
        if(root == null){
            return 0;
        }//空数
        if(root.right ==null && root.left==null){
            return 1;
        }//只有一个根节点
        return (1 + Math.max(TreeDead(root.left),TreeDead(root.right)));
    }
    //判断是否是平衡二叉树
    public boolean IsBalanced_Solution(Node root) {
        if(root == null){
            return true;
        }
        if(Math.abs(TreeDead(root.left) - TreeDead(root.right)) > 1){
            return false;
        }
        return IsBalanced_Solution(root.right) && IsBalanced_Solution(root.left);
    }
}

class BinaryTree{

    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    //前序遍历
    public void preOrderByTree(Node root,ArrayList list){
        System.out.println("前序遍历结果为：");
        if(root != null){
            this.root.midorder(root,list);
        }else {
            System.out.println("空树！");
        }
    }

    //中序遍历
    public void midOrderByTree(){
        System.out.println("中序遍历结果为：");
        if(this.root != null){
            this.root.midOreder();
        }else {
            System.out.println("空树！");
        }
    }

    //后续遍历
    public void postOrderByTree(){
        System.out.println("后序遍历结果为：");
        if(this.root != null){
            this.root.postOrder();
        }else {
            System.out.println("空树！");
        }
    }

    //层次遍历
    public void levelOrder(){
        System.out.println(this.root.levelOrder1(root));
    }
    //层次遍历
    public void preOrder(){
        this.root.preOrder();
    }
}