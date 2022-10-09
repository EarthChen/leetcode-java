//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// Related Topics 链表 双指针 👍 2255 👎 0


package com.leetcode.editor.cn;

import com.leetcode.editor.cn.struct.ListNode;

//Java：删除链表的倒数第 N 个结点
public class P19RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new P19RemoveNthNodeFromEndOfList().new Solution();
        // ListNode listNode = ListNode.newListNode(1, 2, 3, 4, 5);
        // ListNode cur = solution.removeNthFromEnd(listNode, 2);

        ListNode listNode = ListNode.newListNode(1,2);
        ListNode cur = solution.removeNthFromEnd(listNode, 1);

        System.out.println(cur);
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val; this.next = next; } }
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode slow = new ListNode();
            ListNode cur = slow;
            slow.next = head;

            ListNode fast = head;
            int i = 0;
            while (fast != null) {
                if (i < n) {
                    i++;
                } else {
                    slow = slow.next;
                }
                fast = fast.next;
            }
            ListNode slowNext = slow.next;
            if (slowNext != null) {
                slow.next = slowNext.next;
            }
            return cur.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}