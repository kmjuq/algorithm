package org.kmj.algorithm.leetcode.stack;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 * <p>
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 *
 * @author mengjian.ke@hand-china.com 2020/4/13 15:30
 */
public class YongLiangGeZhanShiXianDuiLieLcof {

    class CQueue {

        private final Stack<Integer> head;
        private final Stack<Integer> tail;

        public CQueue() {
            head = new Stack<>();
            tail = new Stack<>();
        }

        public void appendTail(int value) {
            tail.push(value);
        }

        public int deleteHead() {
            if (head.empty()) {
                while (!tail.empty()) {
                    head.push(tail.pop());
                }
            }
            if (head.empty()) {
                return -1;
            }
            return head.pop();
        }

    }

}
