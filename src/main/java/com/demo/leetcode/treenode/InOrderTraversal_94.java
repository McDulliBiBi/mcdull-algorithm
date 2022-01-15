package com.demo.leetcode.treenode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中序遍历
 */
public class InOrderTraversal_94 {
    public static void main(String[] args) {

    }

    /**
     * 递归方法类似前序或者后续，直接改递归调用的顺序就行
     */

    /**
     * 迭代遍历
     *
     * 中序：左中右
     * @param root
     * @return
     */
    public static List<Integer> inOrderTraversalV2(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }

        return result;
    }
}
