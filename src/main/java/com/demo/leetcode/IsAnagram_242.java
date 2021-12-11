package com.demo.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 */
public class IsAnagram_242 {
    public static boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        HashMap<Character, Integer> str1Map = new HashMap<Character, Integer>(str1.length());
        HashMap<Character, Integer> str2Map = new HashMap<Character, Integer>(str2.length());

        for (int i = 0; i < str1.length(); i++) {
            char str1Char = str1.charAt(i);
            int str1Times = str1Map.containsKey(str1Char) ? str1Map.get(str1Char) : 0;
            str1Map.put(str1.charAt(i), ++str1Times);

            char str2Char = str2.charAt(i);
            int str2Times = str2Map.containsKey(str2Char) ? str2Map.get(str2Char) : 0;
            str2Map.put(str2.charAt(i), ++str2Times);
        }

        Iterator iterator = str1Map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            Character key = (Character) entry.getKey();
            Integer value = (Integer) entry.getValue();

            if (!str2Map.containsKey(key)) {
                return false;
            }

            if (!((Integer) str2Map.get(key)).equals(value)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagramV3("aacc", "ccac"));
    }

    /**
     * 官方解法1
     * 思路：两个字符串中的字符排序，然后再比较新字符串是否相等即可
     * 看了官方答案，再看自己的，简直太多此一举了。。
     */
    public static boolean isAnagramV1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();

        Arrays.sort(schars);
        Arrays.sort(tchars);

        return Arrays.equals(schars, tchars);
    }

    /**
     * 官方解法2
     * 思路：两个字符串中出现的字符种类和数量相同，所以维护一个长度为26的频次数组，数组中保存每个字符出现的次数
     */
    public static boolean isAnagramV2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 官方解法3 针对进阶，如果字符中包括unicode字符的情况
     * 比较意外和我最初想的差不多，但是比我的第一版简洁很多
     * 思路：维护HashMap，key是每个字符，value是这个字符出现的次数
     * <p>
     * 时间复杂度：
     * 空间复杂度：O(S) ,S为字符串的长度
     */
    public static boolean isAnagramV3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<Character, Integer>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            map.put(key, map.getOrDefault(key, 0) + 1);  //这里之前不知道有这种用法。。
        }

        for (int i = 0; i < t.length(); i++) {
            char key = t.charAt(i);
            map.put(key, map.getOrDefault(key, 0) - 1);
            if (map.get(key) < 0) {
                return false;
            }
        }

        return true;
    }
}
