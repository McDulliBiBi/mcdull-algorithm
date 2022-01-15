package com.demo.leetcode.treenode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 后序遍历二叉树
 * 左右中
 */
public class PostOrderTraversal_145 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.right = node2;
        node2.left = node3;

        List<Integer> result = postorderTraversal(node1);
        System.out.println(result);
    }

    /**
     * 递归法
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }

    public static void traversal(TreeNode treeNode, List<Integer> list) {
        if (treeNode == null) {
            return;
        }

        //后序遍历，左右中
        traversal(treeNode.left, list);
        traversal(treeNode.right, list);
        list.add(treeNode.val);
    }

    /**
     * 迭代法
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversalV2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);

            if (root.left != null) {
                stack.push(root.left);
            }

            if (root.right != null) {
                stack.push(root.right);
            }
        }


        return result;
    }
}
