package org.kmj.algorithm.leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


/**
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/6/9 10:42
 */
public class ValidParentheses {

    public final static char A_L = '(';
    public final static char A_R = ')';
    public final static char B_L = '[';
    public final static char B_R = ']';
    public final static char C_L = '{';
    public final static char C_R = '}';

    public final static Map<Character, Character> maps = new HashMap<Character, Character>() {{
        put(A_L,
                A_R);
        put(B_L,
                B_R);
        put(C_L,
                C_R);
    }};

    static class Solution {
        public boolean isValid(String s) {
            final Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                final char c = s.charAt(i);
                if (stack.isEmpty()) {
                    stack.push(c);
                } else {
                    final Character peek = stack.peek();
                    if (maps.get(peek) != null) {
                        if (c == maps.get(peek)) {
                            stack.pop();
                        } else {
                            stack.push(c);
                        }
                    } else {
                        stack.push(c);
                    }
                }
            }
            return stack.isEmpty();
        }


    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("()"));
    }

}
