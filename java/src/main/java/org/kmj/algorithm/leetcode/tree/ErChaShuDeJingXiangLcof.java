package org.kmj.algorithm.leetcode.tree;

import java.util.Stack;

/**
 * <p>
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * <p>
 * 例如输入：
 * <p>
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 * <p>
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 1000
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/5/18 15:11
 */
public class ErChaShuDeJingXiangLcof {

    class Solution {
        public TreeNode mirrorTree1(TreeNode root) {
            if (root == null) {
                return null;
            }
            swap(root);
            mirrorTree1(root.right);
            mirrorTree1(root.left);
            return root;
        }

        public TreeNode mirrorTree2(TreeNode root) {
            if (root == null) {
                return null;
            }
            final Stack<TreeNode> tns = new Stack<TreeNode>() {{
                add(root);
            }};
            while (!tns.empty()) {
                final TreeNode pop = tns.pop();
                if (pop.left != null) {
                    tns.push(pop.left);
                }
                if (pop.right != null) {
                    tns.push(pop.right);
                }
                swap(pop);
            }
            return root;
        }

        public void swap(TreeNode root) {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
        }
    }

}
