//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
//
// Related Topics 递归 链表 👍 2729 👎 0


package com.leetcode.editor.cn;

import com.leetcode.editor.cn.struct.ListNode;

//Java：合并两个有序链表
public class P21MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new P21MergeTwoSortedLists().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val; this.next = next; } }
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode pre = new ListNode();
            ListNode preCur = pre;
            ListNode cur1 = list1;
            ListNode cur2 = list2;
            while (cur1 != null && cur2 != null) {
                if (cur1.val <= cur2.val) {
                    preCur.next = cur1;
                    cur1 = cur1.next;
                } else {
                    preCur.next = cur2;
                    cur2 = cur2.next;
                }
                preCur = preCur.next;
            }
            if (cur1 != null) {
                preCur.next = cur1;
            }
            if (cur2 != null) {
                preCur.next = cur2;
            }
            return pre.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}