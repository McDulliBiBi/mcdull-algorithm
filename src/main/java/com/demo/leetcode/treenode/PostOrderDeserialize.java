package com.demo.leetcode.treenode;

import java.util.LinkedList;

/**
 * 后续遍历二叉树的反向操作
 * 把一维数组反序列化成一棵二叉树
 *
 * 左右中
 *
 * 反序列化的套路：先找到root，然后递归计算右子节点，然后递归计算左子节点
 */
public class PostOrderDeserialize {
    public static void main(String[] args) {
        String data = "#,#,#,4,2,#,#,3,1";
        TreeNode root = deserialize(data);
        System.out.println(root);
    }

    private static TreeNode deserialize(String data) {
        LinkedList nodes = new LinkedList();
        for (String d : data.split(",")) {
            nodes.add(d);
        }

        return deserialize(nodes);
    }

    private static TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }

        String last = nodes.removeLast();
        if ("#".equals(last)) {
            return null;
        }

        //后续遍历的根节点在最后，所以要先从最后取出
        TreeNode root = new TreeNode(Integer.parseInt(last));
        //后续遍历取完根节点后，接连跟着的是根节点的右子树，所以递归时要先赋值根节点的有节点指针
        root.right = deserialize(nodes);
        //然后是左节点
        root.left = deserialize(nodes);
        return root;
    }
}
