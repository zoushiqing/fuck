package com.fuck.binarytree;

import java.util.Stack;

/**
 * desc:
 */
public class BinaryTree {
    
    public TreeNode root = null;
    
    public BinaryTree() {
        root = new TreeNode(1, "A");
    }
    
    /**
     * 构建一个二叉树
     * A
     * B      C
     * D     E        F
     */
    public void crateBinaryTree() {
        TreeNode treeNodeB = new TreeNode(2, "B");
        TreeNode treeNodeC = new TreeNode(3, "C");
        TreeNode treeNodeD = new TreeNode(4, "D");
        TreeNode treeNodeE = new TreeNode(5, "E");
        TreeNode treeNodeF = new TreeNode(6, "F");
        root.leftChild = treeNodeB;
        root.rightChild = treeNodeC;
        treeNodeB.leftChild = treeNodeD;
        treeNodeB.rightChild = treeNodeE;
        treeNodeC.rightChild = treeNodeF;
    }
    
    /**
     * 求二叉树的高度
     */
    public int getHeight() {
        return getHeight(root);
    }
    
    public int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int i = getHeight(node.leftChild);
            int j = getHeight(node.rightChild);
            return (i < j) ? j + 1 : i + 1;
        }
    }
    
    /**
     * 获取二叉树的节点数
     */
    public int getSize(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + getSize(root.leftChild) + getSize(root.rightChild);
        }
    }
    
    /**
     * 前序遍历-----迭代
     */
    public void preOder(TreeNode node) {
        if (node == null) {
            return;
        } else {
            System.out.println("preOder data = " + node.data);
            preOder(node.leftChild);
            preOder(node.rightChild);
        }
    }
    
    /**
     * 前序遍历非迭代
     */
    public void nonRecOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode n = stack.pop();
            System.out.println("nonRecOrder  data = " + n.getData());
            /*
            1.一上来就是至少提前一个月
            2.发邮件给人事和陈方
            2.人事和陈方看到邮件是否同意，同意再发给沈总争取意见
            3.沈总同意之后再填年假表
            4.年假表领导签，老总签字同意
            5.修完年假还签字
            6.然后又给我说一大堆无用的 
            7.fuck全家
             */
            if (n.rightChild != null) {
                stack.push(n.rightChild);
            }
            if (n.leftChild != null) {
                stack.push(n.leftChild);
            }
        }
    }
    
    public void nonMidOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        if (node.rightChild != null) {
            stack.push(node.rightChild);
        }
        stack.push(node);
        if (node.leftChild != null) {
            stack.push(node.leftChild);
        }
        while (!stack.isEmpty()) {
            TreeNode n = stack.pop();
            if (n.leftChild==null) {
                System.out.println("n = " + n);
            }else {
                stack.push(n.leftChild);
            }
            
        }
    }
    
    /**
     * 中序遍历-----迭代
     */
    public void midOder(TreeNode node) {
        if (node == null) {
            return;
        } else {
            midOder(node.leftChild);
            System.out.println("midOder data = " + node.data);
            midOder(node.rightChild);
        }
    }
    
    /**
     * 后遍历-----迭代
     */
    public void postOder(TreeNode node) {
        if (node == null) {
            return;
        } else {
            postOder(node.leftChild);
            postOder(node.rightChild);
            System.out.println("postOder data = " + node.data);
        }
    }
    
    public class TreeNode {
        private int index;
        private String data;
        private TreeNode leftChild;
        private TreeNode rightChild;
        
        public int getIndex() {
            return index;
        }
        
        public String getData() {
            return data;
        }
        
        public TreeNode(int index, String data) {
            this.index = index;
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
        }
    }
    
}
