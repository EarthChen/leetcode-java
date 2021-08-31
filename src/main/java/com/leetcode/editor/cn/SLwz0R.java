package com.leetcode.editor.cn;

//给定一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
//
// 
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
// 进阶：能尝试使用一趟扫描实现吗？ 
//
// 
//
// 注意：本题与主站 19 题相同： https://leetcode-cn.com/problems/remove-nth-node-from-end-
//of-list/ 
// Related Topics 链表 双指针 👍 2 👎 0


import com.leetcode.editor.cn.list.ListNode;

import java.util.ArrayList;
import java.util.List;

public class SLwz0R {
    public static void main(String[] args) {
        Solution solution = new SLwz0R().new Solution();
        // System.out.println(solution.removeNthFromEnd(ListNode.newListNode(1,2,3,4),2));
        System.out.println(solution.removeNthFromEnd(ListNode.newListNode(1),1));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {} ListNode(int
     * val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val; this.next = next; } }
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            List<ListNode> ans = new ArrayList<>();
            ListNode cur = head;
            while (cur != null) {
                ans.add(cur);
                cur = cur.next;
            }
            int length = ans.size();
            if (n == 1) {
                if (length == 1) {
                    return null;
                }
                ans.get(length - 2).next = null;
                return ans.get(0);
            }
            if (n == length) {
                return ans.get(1);
            }
            int m = length - n;

            ListNode pre = ans.get(m - 1);
            pre.next = ans.get(m + 1);
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}