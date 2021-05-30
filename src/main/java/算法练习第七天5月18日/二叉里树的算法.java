package 算法练习第七天5月18日;

import javax.swing.tree.TreeNode;
import java.util.*;

public class 二叉里树的算法 {

    //二叉树的层次遍历
    public ArrayList<ArrayList<Integer>> levelOrder(BinaryTree root){
        if(root == null){
            return new ArrayList<>();
        }
        Queue<BinaryTree> queue = new LinkedList<>();//利用队列来解决
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();//函数返回值结果集
        queue.add(root);
        while (!queue.isEmpty()){
            ArrayList<Integer> cen = new ArrayList<>();//每层的节点数
            for (int i = 0; i < queue.size(); i++) {
                BinaryTree node = queue.poll();
                cen.add(node.value);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            result.add(cen);
        }
        return result;
    }
    //二叉树的层次遍历
    public static int [] levelOrder11(BinaryTree root){
        if(root == null){
            return new int[0];
        }
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (!queue.isEmpty()){
            BinaryTree node = queue.poll();
            arrayList.add(node.value);
            if(root.left != null){
                queue.add(node.left);
            }
            if(root.right != null){
                queue.add(node.right);
            }
        }
        int []result = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            result[i] = arrayList.get(i);
        }
        return result;
    }
    //先序遍历
    public ArrayList<ArrayList<Integer>> preOrder(BinaryTree root){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(root.value);
        if(root.left != null){
            list.add(root.left.value);
        }
        if(root.right != null){
            list.add(root.right.value);
        }
        result.add(list);
        return result;
    }
    //后序遍历
    public void preorder(BinaryTree root, ArrayList<Integer> list) {
        Stack<BinaryTree> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTree curr = stack.pop();
            list.add(0, curr.value);
            if(curr.left != null) {
                stack.push(curr.left);
            }
            if(curr.right != null) {
                stack.push(curr.right);
            }
        }
    }
    //后序遍历
    public void midorder(BinaryTree root, List<Integer> list) {
        Stack<BinaryTree> stack = new Stack<>();
        BinaryTree curr = root;
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
    //后序遍历
    public void postorder(BinaryTree root, List<Integer> list) {
        Stack<BinaryTree> stack = new Stack<>();
        BinaryTree curr = root;
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                list.add(0, curr.value);
                if (curr.left != null) {
                    stack.push(curr.left);
                }
                curr = curr.right;
            } else {
                curr = stack.pop();
            }
        }
    }

    //先序遍历
    public static void preOreder(BinaryTree root,ArrayList<BinaryTree> list){
        if(root != null){
            list.add(root);
            preOreder(root.left,list);
            preOreder(root.right,list);
        }
    }
    //中序遍历
    public static void midOreder(BinaryTree root,ArrayList<BinaryTree> list){
        if(root != null){
            preOreder(root.left,list);
            list.add(root);
            preOreder(root.right,list);
        }
    }
    //先序遍历
    public static void postOreder(BinaryTree root,ArrayList<BinaryTree> list){
        if(root != null){
            preOreder(root.left,list);
            preOreder(root.right,list);
            list.add(root);
        }
    }
    //层次遍历
    public static ArrayList<ArrayList<BinaryTree>> levelOrder1(BinaryTree root){
        ArrayList<ArrayList<BinaryTree>> result = new ArrayList<>();
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            ArrayList<BinaryTree> list = new ArrayList<>();
            BinaryTree node = queue.poll();
            list.add(node);
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
            result.add(list);
        }
        return result;
    }

    //二叉树的之字形层次遍历
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder (BinaryTree root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<BinaryTree> queue = new LinkedList<>();

        if(root!=null){
            queue.add(root);
        }

        while(!queue.isEmpty()){
            ArrayList<Integer> tmp = new ArrayList<>();     //存储每一层节点
            for(int i= queue.size();i>0;i--){               //遍历当前层的节点
                BinaryTree node = queue.poll();               //弹出队列中的节点

                if((res.size()+1)%2!=0){     //res.size()+1：当前的层数，从1开始
                    tmp.add(node.value);       // 奇数层 -> 尾插
                }else{
                    tmp.add(0,node.value);     // 偶数层 -> 头插
                }

                if(node.left!=null){         //如果左子节点不为空，则将其加入到队列中
                    queue.add(node.left);
                }
                if(node.right!=null){         //如果左子节点不为空，则将其加入到队列中
                    queue.add(node.right);
                }
            }
            res.add(tmp);               //将这一层的节点加入到res中
        }
        return res;
    }

    //求二叉树的深度
    public static int deepNum(BinaryTree root){
        if(root == null){
            return 0;
        }
        return Math.max(deepNum(root.left),deepNum(root.right))+1;
    }

}

class BinaryTree{
    public int value = 0;
    public BinaryTree left = null;
    public BinaryTree right = null;

    public int getValue() {
        return value;
    }

    public BinaryTree getLeft() {
        return left;
    }

    public BinaryTree getRight() {
        return right;
    }

}
