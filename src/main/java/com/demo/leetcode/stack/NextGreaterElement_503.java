package com.demo.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement_503 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1,2,3,4,5,6,5,4,5,1,2,3})));
    }

    public static int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];

        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        int length = nums.length;
        for (int i = 1; i < length * 2; i++) {
            //还是要用一个逐渐递增的单调栈
            if (nums[i % length] < nums[stack.peek()]) {
                //栈中存的是元素的下标
                stack.push(i % length);

            } else if (nums[i % length] == nums[stack.peek()]) {
                stack.push(i % length);

            } else if (nums[i % length] > nums[stack.peek()]) {
                //栈顶的元素比较小，不能直接入栈了
                while (!stack.isEmpty() && nums[i % length] > nums[stack.peek()]) {
                    result[stack.peek()] = nums[i % length];
                    stack.pop();
                }
                stack.push(i % length);
            }
        }
        return result;
    }

    public static int[] nextGreaterElementsV2(int[] nums) {
        int[] result = new int[nums.length];

        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        int length = nums.length;
        for (int i = 1; i < length * 2; i++) {//栈顶的元素比较小，不能直接入栈了
            while (!stack.isEmpty() && nums[i % length] > nums[stack.peek()]) {
                result[stack.peek()] = nums[i % length];
                stack.pop();
            }
            stack.push(i % length);
        }
        return result;
    }
}
