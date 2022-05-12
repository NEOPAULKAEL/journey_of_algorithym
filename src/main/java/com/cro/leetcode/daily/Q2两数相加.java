package com.cro.leetcode.daily;

import lombok.val;

/**
 * @author cro
 * @description https://leetcode.cn/problems/add-two-numbers/
 */
public class Q2两数相加 {

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            // 进位标志
            int carry = 0;
            ListNode prev = new ListNode(0), cur = prev;
            while (l1!=null || l2!=null){
                int x = l1 == null ? 0 : l1. val;
                int y = l2 == null ? 0 : l2. val;
                int sum = x + y + carry;
                carry = sum / 10;
                sum = sum % 10;
                cur.next = new ListNode(sum);
                cur = cur.next;
                l1 = l1==null ? null :l1.next;
                l2 = l2==null ? null :l2.next;
            }
            // 最后如果还要进位
            if (carry == 1) cur.next = new ListNode(carry);
            return prev.next;
        }
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
