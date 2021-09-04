package com.leetcode.editor.cn;

//给定链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
//
// 
//
// 注意：本题与主站 148 题相同：https://leetcode-cn.com/problems/sort-list/ 
// Related Topics 链表 双指针 分治 排序 归并排序 👍 6 👎 0


import com.leetcode.editor.cn.list.ListNode;

public class SevenWHec2 {
    public static void main(String[] args) {
        Solution solution = new SevenWHec2().new Solution();
        System.out.println(solution.sortList(ListNode.newListNode(2,3,1,5,4)));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {} ListNode(int
     * val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val; this.next = next; } }
     */
    class Solution {
        public ListNode sortList(ListNode head) {
            return sort(head, null);
        }

        private ListNode sort(ListNode head, ListNode tail) {
            if (head == null) {
                return null;
            }
            if (head.next == tail) {
                head.next = null;
                return head;
            }
            ListNode fast = head;
            ListNode slow = head;
            while (fast != tail && fast.next != tail) {
                fast = fast.next.next;
                slow = slow.next;
            }
            ListNode left = sort(head, slow);
            ListNode right = sort(slow, tail);
            return merge(left, right);
        }

        private ListNode merge(ListNode head1, ListNode head2) {
            ListNode preHead = new ListNode();
            ListNode pre = preHead;
            ListNode cur1 = head1;
            ListNode cur2 = head2;
            while (cur1 != null && cur2 != null) {
                if (cur1.val <= cur2.val) {
                    pre.next = cur1;
                    cur1 = cur1.next;
                } else {
                    pre.next = cur2;
                    cur2 = cur2.next;
                }
                pre = pre.next;
            }
            if (cur1 != null) {
                pre.next = cur1;
            }
            if (cur2 != null) {
                pre.next = cur2;
            }
            return preHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}