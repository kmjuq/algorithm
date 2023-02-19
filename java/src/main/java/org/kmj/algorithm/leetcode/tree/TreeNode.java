package org.kmj.algorithm.leetcode.tree;

import java.util.Arrays;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/5/18 15:12
 */
public class TreeNode {

    Integer val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode() {
    }

    public int maxDepth() {
        return maxDepthRecursive(this);
    }

    /**
     * 求最大深度，递归
     */
    public int maxDepthRecursive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepthRecursive(root.left);
        int right = maxDepthRecursive(root.right);
        return Math.max(
                left,
                right
        ) + 1;
    }

    /**
     * 根据数组初始化树
     */
    public static TreeNode createTree(int[] nums) {
        int length = nums.length;
        if (length <= 0) {
            return null;
        }
        TreeNode tn = new TreeNode(nums[length / 2]);
        tn.left = createTree(
                Arrays.copyOfRange(
                        nums,
                        0,
                        length / 2
                )
        );
        tn.right = createTree(
                Arrays.copyOfRange(
                        nums,
                        length / 2 + 1,
                        length
                )
        );
        return tn;
    }

    /**
     * 前序遍历日志
     */
    public String log() {
        StringBuilder log = new StringBuilder();
        log(
                log,
                this
        );
        return log.toString();
    }

    private void log(StringBuilder sb,
                     TreeNode tn) {
        if (tn == null) {
            return;
        }
        sb
                .append(tn.val)
                .append(" ");
        log(
                sb,
                tn.left
        );
        log(
                sb,
                tn.right
        );
    }
}
