package org.kmj.algorithm.leetcode.temp;

/**
 * <p>
 * 如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 * <p>
 * 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
 * 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
 * <p>
 * 子数组 是数组中的一个连续序列。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：3
 * 解释：nums 中有三个子等差数组：[1, 2, 3]、[2, 3, 4] 和 [1,2,3,4] 自身。
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5000
 * -1000 <= nums[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/arithmetic-slices
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author kemengjian@126.com 2021/8/10 21:10
 */
public class ArithmeticSlices {

    public static void main(String[] args) {
        final int[] ints = {1, 2, 3, 4};
        new Solution().numberOfArithmeticSlices(ints);
    }

    static class Solution {
        public int numberOfArithmeticSlices(int[] nums) {
            return 0;
        }
    }

}
