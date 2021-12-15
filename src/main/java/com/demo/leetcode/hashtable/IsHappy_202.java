package com.demo.leetcode.hashtable;

import java.util.*;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * <p>
 * 「快乐数」定义为：
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果 可以变为 1，那么这个数就是快乐数。
 * 如果 n 是快乐数就返回 true ；不是，则返回 false 。
 * <p>
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */
public class IsHappy_202 {
    public static boolean isHappyV1(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);

        while (n != 1) {
            n = getNextSum(n);
            if (!set.add(n)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 获取下一个值
     */
    private static int getNextSum(int n) {
        int sum = 0;
        List<Integer> numList = getIntegerList(n);
        //计算平方和
        for (int i : numList) {
            sum += Math.pow(i, 2);
        }

        return sum;
    }

    /**
     * 将n中的每个数字转换成list
     */
    private static List<Integer> getIntegerList(int n) {
        List<Integer> numList = new ArrayList<>();
        char[] list = String.valueOf(n).toCharArray();
        for (char c : list) {
            numList.add(Integer.valueOf(String.valueOf(c)));
        }
        return numList;
    }

    public static void main(String[] args) {
        System.out.println(isHappyV2(19));
    }

    /**
     * 算法分为两部分：
     * 1、给定一个数字，计算他的下一个数字是什么
     * 2、判断下一个数字是否之前出现过
     * <p>
     * 数据结构可以优先使用HashSet，因为用HashSet查找某个元素是否存在的时间复杂度是O(1);
     * 而其他数据结构，比如列表，数组或者向量的时间复杂度是O(n)
     */
    public static boolean isHappyV2(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);

        while (n != 1) {
            n = getNextNumV2(n);
            if (!set.add(n)) {
                return false;
            }
        }
        return true;
    }

    public static int getNextNumV2(int n) {
        int sum = 0;
        while (n > 0) {
            int t = n % 10;
            sum += t * t;

            n = n / 10;
        }
        return sum;
    }
}
