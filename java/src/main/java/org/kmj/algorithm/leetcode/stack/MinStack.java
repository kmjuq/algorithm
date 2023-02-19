package org.kmj.algorithm.leetcode.stack;

import java.util.Stack;

/**
 * <p>
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/4/18 16:07
 */
public class MinStack {

    private final Stack<Integer> stack;
    private final Stack<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) { // 6,3,4,5,2
        if (this.top() == Integer.MIN_VALUE) {
            stack.push(x);
            minStack.push(x);
        } else {
            int min = Math.min(getMin(), x);
            stack.push(x);
            minStack.push(min);
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        if (stack.isEmpty()) {
            return Integer.MIN_VALUE;
        } else {
            return stack.peek();
        }
    }

    public int getMin() {
        return minStack.peek();
    }

}
