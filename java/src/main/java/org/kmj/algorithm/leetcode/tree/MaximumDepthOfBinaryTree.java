package org.kmj.algorithm.leetcode.tree;

/**
 * <p>
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 * <p>
 * 例如：
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 * 提示：
 * <p>
 * 节点总数 <= 10000
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/5/20 10:59
 */
public class MaximumDepthOfBinaryTree {

    class Solution {
        public int maxDepth(TreeNode root) {
            return 0;
        }

        public void maxDepth(Integer num,
                             TreeNode root) {
            if (root == null) return;
            num = num + 1;
            maxDepth(num, root.left);
            maxDepth(num, root.right);
        }
    }

}
