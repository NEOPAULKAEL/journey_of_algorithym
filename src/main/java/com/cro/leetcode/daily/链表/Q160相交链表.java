package com.cro.leetcode.daily.链表;

/**
 * @author cro
 * @description https://leetcode.cn/problems/intersection-of-two-linked-lists/
 */
public class Q160相交链表 {


    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            // 双指针
            ListNode a = headA, b = headB;
            // 遍历两个链表
            while (a != b) {
                a = a != null ? a.next : headB;
                b = b != null ? b.next : headA;
            }
            return a;
        }
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
