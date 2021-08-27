package com.leetcode.editor.cn;

//给定一个链表的 头节点 head ，请判断其是否为回文链表。 
//
// 如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: head = [1,2,3,3,2,1]
//输出: true 
//
// 示例 2： 
//
// 
//
// 
//输入: head = [1,2]
//输出: fasle
// 
//
// 
//
// 提示： 
//
// 
// 链表 L 的长度范围为 [1, 105] 
// 0 <= node.val <= 9 
// 
//
// 
//
// 进阶：能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
//
// 
//
// 注意：本题与主站 234 题相同：https://leetcode-cn.com/problems/palindrome-linked-list/ 
// Related Topics 栈 递归 链表 双指针 
// 👍 2 👎 0


import com.leetcode.editor.cn.list.ListNode;

import java.util.ArrayList;
import java.util.List;

public class AMhZSa {
    public static void main(String[] args) {
        Solution solution = new AMhZSa().new Solution();
        System.out.println(solution.isPalindrome(ListNode.newListNode(1,2)));
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
            List<Integer> ans = new ArrayList<>();
            int count = 0;
            while (fast != null) {
                fast = fast.next;
                count++;
                if (fast != null) {
                    count++;
                    fast = fast.next;
                }
                ans.add(slow.val);
                slow = slow.next;
            }
            int length = ans.size();
            int i = length - 1;
            if (count % 2 != 0) {
                i--;
            }
            while (slow != null && i >= 0) {
                if (slow.val != ans.get(i)) {
                    return false;
                }
                slow = slow.next;
                i--;
            }
            return slow == null && i == -1;
            // List<Integer> ans = new ArrayList<>();
            // ListNode cur = head;
            // while (cur != null) {
            //     ans.add(cur.val);
            //     cur = cur.next;
            // }
            // int i = 0;
            // int j = ans.size() - 1;
            // while (i < j) {
            //     if (!ans.get(i).equals(ans.get(j))) {
            //         return false;
            //     }
            //     i++;
            //     j--;
            // }
            // return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}