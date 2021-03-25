package com.leetcode.editor.cn;

//存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 返回同样按升序排列的结果链表。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,1,2,3]
//输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序排列 
// 
// Related Topics 链表 
// 👍 562 👎 0


import com.leetcode.editor.cn.list.ListNode;

public class RemoveDuplicatesFromSortedListIi {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedListIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {} ListNode(int
     * val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val; this.next = next; } }
     */
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode pre = new ListNode(-101, head);
            ListNode pre1 = pre;
            ListNode fast = pre;
            // int preVal = pre.val;
            while (fast.next != null) {
                if (fast.val == fast.next.val) {
                    ListNode cur = fast.next;
                    int val = cur.val;
                    while (cur != null && val == cur.val) {
                        cur = cur.next;
                    }
                    pre1.next = cur;
                    if (cur == null) {
                        break;
                    }
                    fast = cur;
                } else {
                    pre1 = fast;
                    fast = fast.next;
                }
            }
            return pre.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}