//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
//
// Related Topics 递归 链表 数学 👍 8475 👎 0


package com.leetcode.editor.cn;

import com.leetcode.editor.cn.struct.ListNode;

//Java：两数相加
public class P2AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new P2AddTwoNumbers().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val; this.next = next; } }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode result = new ListNode(0);
            ListNode ret = result;
            ListNode cur1 = l1;
            ListNode cur2 = l2;
            int flag = 0;
            while (cur1 != null && cur2 != null) {
                int curRet = cur1.val + cur2.val + flag;
                if (curRet >= 10) {
                    flag = 1;
                    curRet = curRet - 10;
                } else {
                    flag = 0;
                }
                cur1 = cur1.next;
                cur2 = cur2.next;
                ret.next = new ListNode(curRet);
                ret = ret.next;
            }
            while (cur1 != null) {
                int curRet = cur1.val + flag;
                if (curRet >= 10) {
                    curRet = curRet - 10;
                    flag = 1;
                }else {
                    flag = 0;
                }
                ret.next = new ListNode(curRet);
                cur1 = cur1.next;
                ret = ret.next;
            }
            while (cur2 != null) {
                int curRet = cur2.val + flag;
                if (curRet >= 10) {
                    curRet = curRet - 10;
                    flag = 1;
                }else {
                    flag = 0;
                }
                ret.next = new ListNode(curRet);
                cur2 = cur2.next;
                ret = ret.next;
            }
            if (flag > 0) {
                ret.next = new ListNode(flag);
            }
            return result.next;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}