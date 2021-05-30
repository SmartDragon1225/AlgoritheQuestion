package 剑职offer经典算笔试编程题.重建二叉树;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字
 */

import javax.swing.tree.TreeNode;
import java.util.*;

public class BinaryTree {
    public static void main(String[] args) {
        int preorder[] = {3,9,20,15,7};
        int inorder[] = {9,3,15,20,7};
        Tree tree = new BinaryTree().buildTree2(preorder, inorder);
        Tree binaryTree = new Tree();
    }

    /**
     * 迭代建二叉树
     * @param preorder 先序遍历的结果
     * @param inorder  中序遍历的结果
     * @return
     */
    public Tree buildTree2(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        Tree root = new Tree(preorder[0]);//根节点
        Deque<Tree> stack = new LinkedList<Tree>();
        stack.push(root);//根入队
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            Tree node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new Tree(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new Tree(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }

    /*public Tree buildTree1(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0){
            return null;
        }
        Tree root = new Tree(preorder[0]);
        Deque<Tree> stack = new LinkedList<>();
        stack.push(root);
        for (int i = 0; i < preorder.length; i++) {
            int pre = preorder[i];
            Tree node = stack.peek();
            if(node.left)
        }
    }*/



    private Map<Integer, Integer> indexMap;
    public Tree myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);

        // 先把根节点建立出来
        Tree root = new Tree(preorder[preorder_root]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }
    public Tree buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }
}

class Tree {
    int val;
    Tree left;
    Tree right;
    Tree(){}
    Tree(int x) { val = x; }

    @Override
    public String toString() {
        return "Tree{" +
                "val=" + val +
                '}';
    }
    //层次遍历
    public ArrayList<ArrayList<Tree>> levelOrder1(Tree root){
        ArrayList<ArrayList<Tree>> result = new ArrayList<>();
        Queue<Tree> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            ArrayList<Tree> list = new ArrayList<>();
            Tree node = queue.poll();
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
}