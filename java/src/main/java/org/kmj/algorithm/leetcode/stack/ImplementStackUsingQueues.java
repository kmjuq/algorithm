package org.kmj.algorithm.leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>
 * 使用队列实现栈的下列操作：
 * <p>
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 注意:
 * <p>
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/4/16 01:01
 */
public class ImplementStackUsingQueues {
    class MyStack {

        private final Queue<Integer> left;
        private final Queue<Integer> right;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            left = new LinkedList<>();
            right = new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            if (left.isEmpty()) {
                right.offer(x);
            } else {
                left.offer(x);
            }
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            if (left.isEmpty()) {
                while (right.size() > 1) {
                    left.offer(right.poll());
                }
                return right.poll();
            } else {
                while (left.size() > 1) {
                    right.offer(left.poll());
                }
                return left.poll();
            }
        }

        /**
         * Get the top element.
         */
        public int top() {
            Integer result = null;
            if (left.isEmpty()) {
                while (right.size() > 1) {
                    left.offer(right.poll());
                }
                result = right.peek();
                left.offer(right.poll());
            } else {
                while (left.size() > 1) {
                    right.offer(left.poll());
                }
                result = left.peek();
                right.offer(left.poll());
            }
            return result;
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return left.isEmpty() && right.isEmpty();
        }
    }

}
