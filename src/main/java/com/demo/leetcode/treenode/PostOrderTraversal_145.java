package com.demo.leetcode.treenode;

import java.util.ArrayList;
import java.util.List;

/**
 * 后序遍历二叉树
 * 左右中
 */
public class PostOrderTraversal_145 {
    public static void main(String[] args) {

    }

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
}
