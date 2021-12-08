package com.demo.leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * <p>
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 */

public class TwoSum_001 {

    /**
     * 时间复杂度：O(N^2), 其中 NN 是数组中的元素数量。最坏情况下数组中任意两个数都要被匹配一次。
     * <p>
     * 空间复杂度：O(1)
     */
    public static int[] twoSumV1(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    /**
     * 时间复杂度：O(N)，其中 NN 是数组中的元素数量。对于每一个元素 x，我们可以 O(1) 地寻找 target - x。
     * <p>
     * 空间复杂度：O(N)，其中 NN 是数组中的元素数量。主要为哈希表的开销。
     */
    public static int[] twoSumV2(int[] nums, int target) {
        int[] result = new int[2];

        Map<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = i;
                result[1] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result = twoSumV1(new int[]{3, 3, 1}, 6);
        System.out.println(result[0] + ", " + result[1]);
    }
}
