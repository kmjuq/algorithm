package org.kmj.algorithm.leetcode.stack;

import java.util.Stack;

/**
 * <p>
 * 实现一个MyQueue类，该类用两个栈来实现一个队列。
 * <p>
 * 示例：
 * <p>
 * MyQueue queue = new MyQueue();
 * <p>
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // 返回 1
 * queue.pop();   // 返回 1
 * queue.empty(); // 返回 false
 * <p>
 * 说明：
 * <p>
 * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/4/13 15:30
 */
public class ImplementQueueUsingStacksLcci {
    class MyQueue {

        private final Stack<Integer> stack;
        private final Stack<Integer> stackHelp;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            stack = new Stack<>();
            stackHelp = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            stackHelp.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            peek();
            return stack.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (stack.isEmpty()) {
                while (!stackHelp.isEmpty()) {
                    stack.push(stackHelp.pop());
                }
            }
            return stack.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return stack.isEmpty() && stackHelp.isEmpty();
        }
    }
}


