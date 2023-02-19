package org.kmj.algorithm.leetcode.stack;

import java.util.Stack;

/**
 * <p>
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * <p>
 * 示例 1：
 * <p>
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 * <p>
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * 示例 3：
 * <p>
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * 示例 4：
 * <p>
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 * <p>
 * 提示：
 * <p>
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S 和 T 只含有小写字母以及字符 '#'。
 * <p>
 * 进阶：
 * 你可以用 O(N) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/6/6 14:12
 */
public class BackspaceStringCompare {

    static class Solution {
        public boolean backspaceCompare(String S,
                                        String T) {

            //            return deal(S).equals(deal(T));
            return compare(
                    S,
                    T
            );
        }

        public String deal(String str) {
            final char[] chars = str.toCharArray();
            final Stack<Character> container = new Stack<>();
            for (char abc : chars) {
                if (abc == '#') {
                    if (!container.isEmpty()) {
                        container.pop();
                    }
                } else {
                    container.push(abc);
                }
            }
            return container.toString();
        }

        public boolean compare(String s,
                               String t) {
            // "b#cc#a","cc#a"
            int sIndex = s.length() - 1, tIndex = t.length() - 1;
            int sCharCount = 0, tCharCount = 0;
            while (sIndex >= 0 || tIndex >= 0) {
                while (sIndex >= 0) {
                    if (s.charAt(sIndex) == '#') {
                        sCharCount++;
                    } else {
                        if (sCharCount > 0) {
                            sCharCount--;
                        } else {
                            break;
                        }
                    }
                    sIndex--;
                }
                while (tIndex >= 0) {
                    if (t.charAt(tIndex) == '#') {
                        tCharCount++;
                    } else {
                        if (tCharCount > 0) {
                            tCharCount--;
                        } else {
                            break;
                        }
                    }
                    tIndex--;
                }
                if (sIndex >= 0 && tIndex >= 0) {
                    // 都找到了字母
                    if (s.charAt(sIndex) != t.charAt(tIndex)) {
                        return false;
                    } else {
                        sIndex--;
                        tIndex--;
                    }
                } else {
                    // 都没找到字母
                    // 其中一个找到了字母，另一个没找到
                    return sIndex < 0 && tIndex < 0;
                }

            }
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().backspaceCompare(
                //                "acb#", "ad#c"
                "b#cc#a",
                "cc#a"
                //                "ab##", "c#d#"
        ));
    }

}
