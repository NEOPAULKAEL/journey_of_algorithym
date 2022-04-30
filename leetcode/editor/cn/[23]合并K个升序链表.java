//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 1914 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        // 虚拟头结点
        ListNode dummy = new ListNode(-1), p = dummy;
        // 优先级队列 最小堆
        // 最小的元素会被放在优先队列队头！！重要
        PriorityQueue<ListNode> pq = new PriorityQueue(lists.length,
                (a, b) -> (a.val - b.val));
        // k个链表的头结点加入最小堆
        for (ListNode head : lists) {
            if (head != null) pq.add(head);
        }
        // 遍历队列
        while (!pq.isEmpty()) {
            // 从队列中取出当前最小值
            ListNode node = pq.poll();
            // 把最小的接到结果队列末尾
            p.next = node;
            // 如果该节点后还有元素 则把下一个元素加入优先队列中
            if (node.next != null) {
                pq.add(node.next);
            }
            // 移动指针
            p = p.next;
        }
        return dummy.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
