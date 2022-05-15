package com.cro.leetcode.daily.链表;

/**
 * @author cro
 * @description https://leetcode.cn/problems/middle-of-the-linked-list/
 */
public class Q876链表中点 {

    class Solution {
        public ListNode middleNode(ListNode head) {
            // 快慢指针
            ListNode dummy = head;
            // 快指针走两步，慢指针走一步
            ListNode slow = dummy, fast = dummy;
            // 当快指针走到底的时候，慢指针就在中点
            // 这里的条件!
            while (fast!=null && fast.next!=null){
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
