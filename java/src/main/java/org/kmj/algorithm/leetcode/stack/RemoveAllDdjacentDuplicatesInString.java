package org.kmj.algorithm.leetcode.stack;

import java.util.Stack;

/**
 * <p>
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * <p>
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * <p>
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * <p>
 * 示例：
 * <p>
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。
 * 之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/4/13 23:30
 */
public class RemoveAllDdjacentDuplicatesInString {
    static class Solution {

        public String removeDuplicates(String S) {
            Stack<Character> stack = new Stack<>();
            for (char c : S.toCharArray()) {
                if (stack.isEmpty() || c != stack.peek()) {
                    stack.push(c);
                } else {
                    stack.pop();
                }
            }
            StringBuilder str = new StringBuilder();
            for (Character c : stack) {
                str.append(c);
            }
            return str.toString();
        }

        public static void main(String[] args) {
            String S = "abbaca";
            StringBuilder sb = new StringBuilder();
            int sbLength = 0;
            for (char c : S.toCharArray()) {
                if (sbLength != 0 && c == sb.charAt(sbLength - 1)) {
                    sb.deleteCharAt(sbLength-- - 1);
                } else {
                    sb.append(c);
                    sbLength++;
                }
            }
        }
    }
}
