//给定一个链表数组，每个链表都已经按升序排列。 
//
// 请将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 
//输入：lists = [[1,4,5],[1,3,4],[2,6]]
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
// 
//输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：lists = [[]]
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
//
// 
//
// 
// 注意：本题与主站 23 题相同： https://leetcode-cn.com/problems/merge-k-sorted-lists/ 
//
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 60 👎 0


package com.leetcode.editor.cn;

import com.leetcode.editor.cn.struct.ListNode;

//Java：合并排序链表
public class PvvXgSWVvXgSW {
    public static void main(String[] args) {
        Solution solution = new PvvXgSWVvXgSW().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val; this.next = next; } }
     */
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode node = null;
            for (ListNode list : lists) {
                node = merge(list, node);
            }
            return node;
        }

        private ListNode merge(ListNode head1, ListNode head2) {
            ListNode pre = new ListNode();
            ListNode cur = pre;
            ListNode cur1 = head1;
            ListNode cur2 = head2;
            while (cur1 != null && cur2 != null) {
                if (cur1.val <= cur2.val) {
                    cur.next = cur1;
                    cur1 = cur1.next;
                } else {
                    cur.next = cur2;
                    cur2 = cur2.next;
                }
                cur = cur.next;
            }
            if (cur1 != null) {
                cur.next = cur1;
            }
            if (cur2 != null) {
                cur.next = cur2;
            }
            return pre.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}