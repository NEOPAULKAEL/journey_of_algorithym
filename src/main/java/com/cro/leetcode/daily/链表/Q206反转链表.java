package com.cro.leetcode.daily.链表;

import jdk.javadoc.internal.doclets.formats.html.markup.Head;

/**
 * @author cro
 * @description https://leetcode.cn/problems/reverse-linked-list/
 */
public class Q206反转链表 {


    class Solution {
        public ListNode reverseList(ListNode head) {
            return reverse(head);
        }
        public ListNode reverse(ListNode head){
            // base case
            if (head == null || head.next == null) return head;
            ListNode node = reverse(head.next);
            // 4.next.next = 4 --> 5.next = 4
            head.next.next = head;
            head.next = null;
            return node;
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
