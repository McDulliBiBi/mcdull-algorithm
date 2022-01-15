package com.demo.leetcode.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 *
 */
public class DailyTemperature_739 {
    public static void main(String[] args) {
        int[] temperature = new int[]{73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(temperature)));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        // 这里作为一个单调栈来用，
        // 且从栈头到栈尾，是从小到大排序（因为目的是要找到比当前元素大的最近的一个元素，栈中的元素是从栈头蹦出来的）

        for (int i = 1; i < temperatures.length; i++) {
            if (temperatures[i] > temperatures[stack.peek()]) {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    res[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            } else if (temperatures[i] == temperatures[stack.peek()]) {
                stack.push(i);
            } else if (temperatures[i] < temperatures[stack.peek()]) {
                //result不加，因为栈中的元素比较大，直接入栈就行
                stack.push(i);
            }
        }

        return res;
    }
}
