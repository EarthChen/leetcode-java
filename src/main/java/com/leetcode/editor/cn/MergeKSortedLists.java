package com.leetcode.editor.cn;

//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
// Related Topics 堆 链表 分治算法 
// 👍 1232 👎 0


import com.leetcode.editor.cn.list.ListNode;

public class MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {} ListNode(int
     * val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val; this.next = next; } }
     */
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }
            if (lists.length <= 1) {
                return lists[0];
            }
            ListNode ret = merge(lists[0], lists[1]);
            for (int i = 2; i < lists.length; i++) {
                ret = merge(ret, lists[i]);
            }
            return ret;
        }

        private ListNode merge(ListNode list1, ListNode list2) {
            if (list1 == null) {
                return list2;
            }
            if (list2 == null) {
                return list1;
            }
            ListNode pre = new ListNode(0);
            ListNode preIndex = pre;
            ListNode pre1 = list1;
            ListNode pre2 = list2;
            while (pre1 != null && pre2 != null) {
                int val1 = pre1.val;
                int val2 = pre2.val;
                if (val1 <= val2) {
                    preIndex.next = pre1;
                    pre1 = pre1.next;
                } else {
                    preIndex.next = pre2;
                    pre2 = pre2.next;
                }
                preIndex = preIndex.next;
            }
            if (pre1 != null) {
                preIndex.next = pre1;
            }
            if (pre2 != null) {
                preIndex.next = pre2;
            }
            return pre.next;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
}

