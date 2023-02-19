package org.kmj.algorithm.leetcode.temp;


import org.kmj.algorithm.leetcode.ListNode;

/**
 * <p>
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * <p>
 * 你不需要 保留 每个分区中各节点的初始相对位置。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author kemengjian@126.com 2021/8/12 23:41
 */
public class PartitionListLcci {

    public static void main(String[] args) {
//        final ListNode l1 = new ListNode(1);
//        final ListNode l2 = new ListNode(4);
//        final ListNode l3 = new ListNode(3);
//        final ListNode l4 = new ListNode(2);
//        final ListNode l5 = new ListNode(5);
//        final ListNode l6 = new ListNode(2);
//        l1.next=l2;
//        l2.next=l3;
//        l3.next=l4;
//        l4.next=l5;
//        l5.next=l6;
//        System.out.println(Solution.partition(l1, 3));

        final ListNode l1 = new ListNode(3);
        final ListNode l2 = new ListNode(1);
        l1.next = l2;
        System.out.println(Solution.partition(l1, 2));
    }

    static class Solution {
        public static ListNode partition(ListNode head, int x) {
            boolean flag = false;
            ListNode tmp = new ListNode(x);
            tmp.next = head;

            ListNode last = tmp;
            ListNode index = head;
            do {
                if (x == index.val) {
                    flag = true;
                    last = index;
                    index = index.next;
                    continue;
                }
                if (flag) {
                    if (x > index.val) {
                        last.next = index.next;
                        index.next = tmp.next;
                        tmp.next = index;

                        index = last.next;
                        continue;
                    }
                }
                last = index;
                index = index.next;
            } while (index != null);
            return tmp.next;
        }
    }

}
