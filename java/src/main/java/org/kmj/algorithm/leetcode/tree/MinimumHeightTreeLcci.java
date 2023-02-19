package org.kmj.algorithm.leetcode.tree;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * <p>
 * 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 * <p>
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 * <p>
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/5/19 17:34
 */
public class MinimumHeightTreeLcci {

    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            int length = nums.length;
            if (length <= 0) {
                return null;
            }
            TreeNode tn = new TreeNode(nums[length / 2]);
            tn.left = sortedArrayToBST(
                    Arrays.copyOfRange(
                            nums,
                            0,
                            length / 2
                    )
            );
            tn.right = sortedArrayToBST(
                    Arrays.copyOfRange(
                            nums,
                            length / 2 + 1,
                            length
                    )
            );
            return tn;
        }

        public void sortedArrayToBST1(int[] nums) {
            final Stack<int[]> stack = new Stack<>();
            stack.push(nums);
            TreeNode tn = null;
            while (!stack.isEmpty()) {
                final int[] pop = stack.pop();
                int length = pop.length;
                tn = new TreeNode(pop[length / 2]);
                int[] left = Arrays.copyOfRange(
                        pop,
                        0,
                        pop.length / 2
                );
                int[] right = Arrays.copyOfRange(
                        pop,
                        pop.length / 2 + 1,
                        pop.length
                );
                if (left.length != 0) {
                    tn.left = new TreeNode(left[left.length / 2]);
                    stack.push(left);
                }
                if (right.length != 0) {
                    tn.right = new TreeNode(right[right.length / 2]);
                    stack.push(right);
                }
            }
        }
    }

    @Test
    public void demo1() {
        final int[] ints = {1, 2, 3, 4, 5, 6};
        System.out.println(
                Arrays.toString(
                        Arrays.copyOfRange(
                                ints,
                                0,
                                1
                        )
                )
        );
    }

}
