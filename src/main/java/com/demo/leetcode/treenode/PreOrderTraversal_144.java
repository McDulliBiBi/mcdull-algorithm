package com.demo.leetcode.treenode;

import java.util.*;

/**
 * 前序遍历二叉树
 * 中左右
 * <p>
 * 遍历另一种叫法：序列化。即把一棵平面的二叉树序列化为一维的数组
 */
public class PreOrderTraversal_144 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.right = node2;
        node2.left = node3;

        List<Integer> result = preorderTraversal(node1);
        System.out.println(result);
    }

    /**
     * 方法一：递归
     *
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }

    public static void traversal(TreeNode treeNode, List<Integer> list) {
        if (treeNode == null) {
            return;
        }

        //前序遍历，中左右
        list.add(treeNode.val);
        traversal(treeNode.left, list);
        traversal(treeNode.right, list);
    }

    /**
     * 迭代遍历
     * 因为递归遍历是隐式的维护了一个栈，所以可以显示的自己写一个栈维护要遍历的节点，实现遍历
     * @param root
     * @return
     */
    public static List<Integer> preOrderTraversalV2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        //stack栈: 先进后出
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return result;
    }
}
