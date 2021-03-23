package com.leetcode.editor.cn;

//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
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
// Related Topics 链表 双指针 
// 👍 1281 👎 0


import com.leetcode.editor.cn.list.ListNode;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
        ListNode frist = new ListNode(1);
        ListNode sencond = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode forth = new ListNode(4);
        frist.next = sencond;
        sencond.next = third;
        third.next = forth;
        System.out.println(solution.removeNthFromEnd(frist, 1));

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {} ListNode(int
     * val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val; this.next = next; } }
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode pre = new ListNode(-1);
            pre.next = head;
            ListNode fast = pre;
            ListNode slow = pre;
            int i = 0;
            while (fast != null) {
                i++;
                fast = fast.next;
                if (i > n + 1) {
                    slow = slow.next;
                }
            }
            ListNode next = slow.next;
            if (next == null) {
                slow.next = null;
            } else {
                slow.next = next.next;
            }
            slow = next;
            return pre.next;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}