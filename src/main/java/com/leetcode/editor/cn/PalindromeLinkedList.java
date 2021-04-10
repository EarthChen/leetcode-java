package com.leetcode.editor.cn;

//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 935 👎 0


import com.leetcode.editor.cn.list.ListNode;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {} ListNode(int
     * val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val; this.next = next; } }
     */
    class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null) {
                return true;
            }
            ListNode fast = head;
            ListNode slow = head;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            ListNode firstEndNode = slow;
            ListNode secondStartNode = reverse(firstEndNode.next);
            ListNode p1 = head;
            ListNode p2 = secondStartNode;
            while (p2 != null) {
                if (p1.val != p2.val) {
                    return false;
                }
                p1 = p1.next;
                p2 = p2.next;
            }
            return true;
        }

        private ListNode reverse(ListNode node) {
            ListNode cur = node;
            ListNode pre = null;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}