package org.kmj.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *
 * </p>
 *
 * @author kemengjian@126.com 2021/8/12 23:42
 */

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public String toString() {
        List<Integer> result = new ArrayList<>();
        ListNode that = this;
        do {
            result.add(that.val);
            that = that.next;
        } while (that != null);
        return String.format("[%s]", result.stream().map(String::valueOf).collect(Collectors.joining(",")));
    }

    public static void main(String[] args) {
        final ListNode l1 = new ListNode(1);
        final ListNode l2 = new ListNode(2);
        final ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        System.out.println(l1);
    }
}
