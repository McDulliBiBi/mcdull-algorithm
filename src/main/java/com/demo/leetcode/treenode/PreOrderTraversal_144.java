package com.demo.leetcode.treenode;

import java.util.ArrayList;
import java.util.List;

/**
 * 前序遍历二叉树
 * 中左右
 *
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
}
