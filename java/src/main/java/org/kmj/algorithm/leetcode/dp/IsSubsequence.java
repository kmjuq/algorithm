package org.kmj.algorithm.leetcode.dp;

import org.junit.jupiter.api.Test;

/**
 * <p>
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * <p>
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 * <p>
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * <p>
 * 示例 1:
 * s = "abc", t = "ahbgdc"
 * <p>
 * 返回 true.
 * <p>
 * 示例 2:
 * s = "axc", t = "ahbgdc"
 * <p>
 * 返回 false.
 * <p>
 * 后续挑战 :
 * <p>
 * 如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/7/3 16:36
 */
public class IsSubsequence {

    class Solution {
        public boolean isSubsequence(String s,
                                     String t) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                final int i1 = t.indexOf(c);
                if (i1 == -1) {
                    return false;
                } else {
                    t = t.substring(t.indexOf(c) + 1);
                }
            }
            return true;
        }

        public boolean isSubsequence1(String s,
                                      String t) {
            int i = 0;
            for (char ch : s.toCharArray()) {
                while (i < t.length() && t.charAt(i) != ch) {
                    i++;
                }
                i++;
            }
            return i <= t.length();
        }

        public boolean isSubsequence2(String s, String t) {
            int sLen = s.length(), tLen = t.length();
            boolean[][] dp = new boolean[sLen + 1][tLen + 1];
            //初始化
            for (int j = 0; j < tLen; j++) {
                dp[0][j] = true;
            }
            //dp
            for (int i = 1; i <= sLen; i++) {
                for (int j = 1; j <= tLen; j++) {
                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
            return dp[sLen][tLen];
        }
    }

    @Test
    public void demo1() {
        System.out.println(new Solution().isSubsequence1(
                "aaa",
                "abbbbbbb"
        ));
    }

}
