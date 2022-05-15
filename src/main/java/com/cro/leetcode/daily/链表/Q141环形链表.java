package com.cro.leetcode.daily.链表;

/**
 * @author cro
 * @description https://leetcode.cn/problems/linked-list-cycle/
 */
public class Q141环形链表 {
    public class Solution {
        public boolean hasCycle(ListNode head) {
            //快慢指针
            ListNode slow = head, fast = head;
            while (fast!=null && fast.next!=null){
                slow = head.next;
                fast = head.next.next;
                if (slow == fast){
                    return true;
                }
            }
            return false;
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
