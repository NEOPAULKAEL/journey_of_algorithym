package com.cro.leetcode.daily.链表;

/**
 * @author cro
 * @description https://leetcode.cn/problems/reverse-linked-list-ii/
 */
public class Q92反转部分链表 {


    /**
     * 递归方式 很精妙哦
     */
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            return reversMtoN(head, left, right);
        }
        // 第1段 将反转后的链表结果 挂在head后面
        public ListNode reversMtoN(ListNode head, int m, int n){
            // base case 如果m==1 当前的点也需要反转 返回的是反转链表头结点
            if (m == 1) {
                return reverseTopN(head, n);
            }
            ListNode between = reversMtoN(head.next, m - 1, n - 1);
            // 将反转后的链表挂在head后面
            head.next = between;
            return head;
        }
        ListNode topNSuccessor = null;
        // m==1时 反转前n个节点 返回反转后的头结点
        public ListNode reverseTopN(ListNode head, int n){
            // n==1 下一个节点不用反转 之前反转后的最后一个节点要链接到下一个节点
            if (n==1){
                topNSuccessor = head.next;
                return head;
            }
            // 反转m-n
            ListNode newHead = reverseTopN(head.next, n - 1);
            head.next.next = head;
            // 每次反转的头结点下一个 指向n之后的节点（n==1时，才知道n之后的节点）
            head.next = topNSuccessor;
            return newHead;
        }
    }

    /**
     * 迭代方式
     */
    class Solution2 {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            // 先走到left-1步 到left之前的节点
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode pre = dummy;
            for (int i = 0; i < left - 1; i++) {
                pre = pre.next;
            }
            ListNode leftNode = pre.next;
            // 再走right - left +1 步 走到right节点
            ListNode rightNode = pre;
            for (int i = 0; i < right - left + 1; i++) {
                rightNode = rightNode.next;
            }
            // 将链表截断
            ListNode successor = rightNode.next;
            pre.next = null;
            rightNode.next = null;
            // 反转left - right
            reverse(leftNode);
            // 把pre接上rightNode
            pre.next = rightNode;
            // 再接上右边
            leftNode.next = successor;
            return dummy.next;
        }
        public void reverse(ListNode node){
            ListNode pre = null;
            ListNode cur = node;
            while (cur!=null){
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
        };

    }



    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
