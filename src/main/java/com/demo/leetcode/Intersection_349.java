package com.demo.leetcode;

import java.util.*;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 */
public class Intersection_349 {
    /**
     * 自己想的
     * 思路：还是遍历。同时使用set保证返回的结果唯一
     */
    public static int[] intersectionV1(int[] nums1, int[] nums2) {
        Set<Integer> result = new HashSet<>();

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                result.add(nums2[i]);
            }
        }

        //set转数组int[]
        return result.stream().mapToInt(Number::intValue).toArray();
    }

    /**
     * 官方答案
     * 思路：先将两个数组排序，然后使用两个指针，遍历
     *  若两个元素相等，且与结果数组中上一个不相等，则向结果数组中插入新的元素
     *  若不相等，将值较小的指针向右移一个位置
     *
     *  遍历的过程不是很好理解，如果要完全自己想的话。。
     */
    public static int[] intersectionV2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int length1 = nums1.length, length2 = nums2.length;
        int[] result = new int[Math.min(length1, length2)];

        int index1 = 0, index2 = 0;
        int index = 0;
        while (index1 < length1 && index2 < length2) {
            int num1 = nums1[index1], num2 = nums2[index2];
            if (num1 == num2) {
                if (index == 0 || result[index - 1] != num1) { //为了确保result中的元素是唯一的，需要比较当前的元素和前一个是否相同
                    result[index] = num1;
                    index++;
                }
                index1++;
                index2++;
            } else if (num1 > num2) {
                index2++;
            } else {
                index1++;
            }
        }

        return Arrays.copyOfRange(result, 0, index);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersectionV2(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }


}
