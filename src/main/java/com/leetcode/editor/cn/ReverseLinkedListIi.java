package com.leetcode.editor.cn;

//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
// Related Topics 链表 
// 👍 866 👎 0


import com.leetcode.editor.cn.list.ListNode;

public class ReverseLinkedListIi {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi().new Solution();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        // node3.next = node4;
        // node4.next = node5;
        // node3.next = node5;
        // System.out.println(solution.reverseBetween(node3, 2, 4));
        // System.out.println(solution.reverseBetween(node3, 1, 2));
        System.out.println(solution.reverseBetween(node1, 1, 2));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {} ListNode(int
     * val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val; this.next = next; } }
     */
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (left == right) {
                return head;
            }
            ListNode pre = null;
            ListNode cur = head;
            ListNode reverseHeadPre = null;
            ListNode reverseTail = null;
            int i = 0;
            while (cur != null) {
                i++;
                if (i < left) {
                    reverseHeadPre = cur;
                    cur = cur.next;
                    continue;
                }
                if (i > right) {
                    break;
                }
                if (reverseTail == null) {
                    reverseTail = cur;
                }
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            if (reverseHeadPre == null) {
                head = pre;
            } else {
                reverseHeadPre.next = pre;
            }
            if (reverseTail != null) {
                reverseTail.next = cur;
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}