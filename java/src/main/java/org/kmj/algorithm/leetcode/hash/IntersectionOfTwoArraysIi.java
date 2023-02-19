package org.kmj.algorithm.leetcode.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/8/16 21:43
 */
public class IntersectionOfTwoArraysIi {

    static class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            if (nums1.length > nums2.length) {
                intersect(nums2, nums1);
            }
            Map<Integer, Integer> hash = new HashMap<>();
            for (int num : nums1) {
                hash.put(num, hash.getOrDefault(num, 0) + 1);
            }
            int numCount = 0;
            int[] result = new int[nums1.length];
            for (int num : nums2) {
                int count = hash.getOrDefault(num, 0);
                if (count > 0) {
                    hash.put(num, --count);
                    result[numCount] = num;
                    numCount++;
                }
            }
            return Arrays.copyOfRange(result, 0, numCount);
        }
    }

    public static void main(String[] args) {
        new Solution().intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2});
    }

}
