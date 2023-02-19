package org.kmj.algorithm.leetcode.queue;

import java.util.Arrays;

/**
 * <p>
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 *  
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 * <p>
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * <p>
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/6/4 03:11
 */
public class ProductOfArrayExceptSelf { // 2,3,2,3

    static class Solution {
        public int[] productExceptSelf(int[] nums) {
            int len = nums.length;
            int[] right = new int[len];
            int[] left = new int[len];
            int[] answer = new int[len];
            right[0] = 1;
            for (int i = 1; i < nums.length; i++) {
                right[i] = nums[i - 1] * right[i - 1];
            }
            left[len - 1] = 1;
            for (int i = len - 2; i >= 0; i--) {
                left[i] = nums[i + 1] * left[i + 1];
            }
            for (int i = 0; i < answer.length; i++) {
                answer[i] = right[i] * left[i];
            }
            return answer;
        }

        public int[] productExceptSelf1(int[] nums) {
            int len = nums.length;
            int[] right = new int[len];
            int[] left = new int[len];
            int[] answer = new int[len];
            right[0] = 1;
            for (int i = 1; i < nums.length; i++) {
                right[i] = nums[i - 1] * right[i - 1];
            }
            left[len - 1] = 1;
            for (int i = len - 2; i >= 0; i--) {
                left[i] = nums[i + 1] * left[i + 1];
            }
            for (int i = 0; i < answer.length; i++) {
                answer[i] = right[i] * left[i];
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().productExceptSelf(new int[]{1, 2, 3, 4})));
    }

}
