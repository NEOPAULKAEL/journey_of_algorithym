package com.cro.leetcode.daily.蓄水池抽样;

import java.util.Random;

/**
 * @author cro
 * @description https://leetcode-cn.com/problems/linked-list-random-node/
 */
public class Q382随机选择链表节点 {

    class Solution {
        ListNode head;
        Random random;

        public Solution(ListNode head) {
            this.head = head;
            random = new Random();
        }

        public int getRandom() {
            int i = 0, res = 0;
            ListNode p = head;
            // 遍历链表
            while (p != null) {
                i++;
                // 生成一个[0,i]区间的随机数, 这个数为0的概率是1/i
                if (random.nextInt(i) == 0) {
                    res = p.val;
                }
                p = p.next;
            }
            return res;
        }
    }

    /**
     * Definition for singly-linked list.
     */
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
