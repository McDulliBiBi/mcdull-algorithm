package com.demo.leetcode.treenode;

import java.util.LinkedList;

/**
 * 前序遍历二叉树的反向操作
 * 把一维数组反序列化成一棵二叉树
 *
 * 中左右
 *
 * 反序列化的套路：先找到root，然后递归计算左子节点，然后递归计算右子节点
 */
public class PreOrderDeserialize {
    public static void main(String[] args) {
        String data = "1,2,#,4,#,#,3,#,#";
        TreeNode root = deserialize(data);
        System.out.println(root.val);
    }

    private static TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for (String d : data.split(",")) {
            nodes.add(d);
        }

        return deserialize(nodes);
    }

    private static TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }

        String first = nodes.removeFirst();
        if (first.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(first));

        root.left = deserialize(nodes);
        root.right = deserialize(nodes);

        return root;
    }
}
