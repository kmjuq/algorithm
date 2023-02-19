package org.kmj.algorithm.leetcode.linklist;

/**
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class ReverseLinkedList {

    class Solution {
        public ListNode reverseListForIteration(ListNode head) {
            ListNode last = null;
            while (head != null) {
                ListNode n = head;
                head = head.next;
                n.next = last;
                last = n;
            }
            return last;
        }

        public ListNode reverseListForRecursion(ListNode head) {
            if (head.next == null) {
                return head;
            } else {
                ListNode last = reverseListForRecursion(head.next);
                ListNode newHead = head.next;
                newHead.next = head;
                head.next = null;
                return last;
            }
        }
    }

    public static ListNode newListNode(int val) {
        return new ReverseLinkedList().new ListNode(val);
    }

    public static ListNode reverseListForIteration(ListNode ln) {
        return new ReverseLinkedList().new Solution().reverseListForIteration(ln);
    }

    public static ListNode reverseListForRecursion(ListNode ln) {
        return new ReverseLinkedList().new Solution().reverseListForRecursion(ln);
    }

    public static void main(String[] args) {
        ListNode ln = newListNode(1);
        ln.next(newListNode(2)).next(newListNode(3)).next(newListNode(4));
        System.out.println(ln);
        ln = reverseListForIteration(ln);
        System.out.println(ln.toString());
        ln = reverseListForRecursion(ln);
        System.out.println(ln.toString());
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public ListNode next(ListNode next) {
            this.next = next;
            return next;
        }

        public String toString() {
            ListNode now = this;
            StringBuilder log = new StringBuilder();
            log.append(now.val);
            while (now.next != null) {
                now = now.next;
                log.append("->").append(now.val);
            }
            return log.toString();
        }
    }

}


