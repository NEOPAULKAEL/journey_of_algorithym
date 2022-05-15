package com.cro.leetcode.daily.链表;

/**
 *
 * @author cro
 * @description https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 */
public class Q19删除链表的倒数第N个节点 {

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            // 建立一个虚拟头结点
            ListNode dummy = new ListNode(-1),p1 = dummy;
            dummy.next = head;
            // 先让链表走n步(第一个是虚拟节点，所以多走一次)
            for (int i = 0; i <= n; i++) {
                p1 = p1.next;
            }
            // 这时链表剩下的长度就是 head.length - n
            // 用第二个指针再次指向头结点
            ListNode p2 = dummy;
            while (p1!=null){
                p1 = p1.next;
                p2 = p2.next;
            }
            // 停下来的时候 p2 就在倒数第n个节点位置
            p2.next = p2.next.next;
            return dummy.next;
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
