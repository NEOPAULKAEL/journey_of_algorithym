package com.cro.leetcode.daily.链表;

/**
 * @author cro
 * @description https://leetcode.cn/problems/linked-list-cycle-ii/
 */
public class Q142环形链表II {
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            // 双指针
            ListNode s = head,f=head;
            // 构建第一轮相遇
            while (f!=null && f.next!=null){
                s = s.next;
                f = f.next.next;
                if (s == f){
                    break;
                }
            }
            // 如果当前节点没有下一个节点 或者为空（.next.next之后）
            if (f==null || f.next == null) return f;
            f=head;
            // 使得fast指针重新指向head
            while (s!=f){
                s = s.next;
                f = f.next;
                if (s == f){
                    break;
                }
            }
            return f;
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
