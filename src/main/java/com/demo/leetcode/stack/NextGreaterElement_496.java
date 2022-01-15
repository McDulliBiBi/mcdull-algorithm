package com.demo.leetcode.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement_496 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3, 5, 2, 4};
        int[] nums2 = new int[]{6, 5, 4, 3, 2, 1, 7};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];

        Stack<Integer> stack = new Stack<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
            result[i] = -1;
        }

        stack.push(nums2[0]);
        for (int i = 1; i < nums2.length; i++) {
            if (nums2[i] < stack.peek()) {
                stack.push(nums2[i]);
            } else if (nums2[i] == stack.peek()) {
                stack.push(nums2[i]);
            } else if (nums2[i] > stack.peek()) {
                //保证这个stack是单调递增的，把比较小的移除
                while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                    //栈顶的元素比较小，此时不能再入栈了，因为单调栈内的排序，从栈顶到栈底是从小到大的
                    //要开始处理逻辑了
                    if (map.containsKey(stack.peek())) {
                        result[map.get(stack.peek())] = nums2[i];
                    }

                    stack.pop();
                }
                stack.push(nums2[i]);
            }
        }

        return result;
    }
}
