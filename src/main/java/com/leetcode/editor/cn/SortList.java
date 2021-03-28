package com.leetcode.editor.cn;

//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 进阶： 
//
// 
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 104] 内 
// -105 <= Node.val <= 105 
// 
// Related Topics 排序 链表 
// 👍 1064 👎 0


import com.leetcode.editor.cn.list.ListNode;

public class SortList {
    public static void main(String[] args) {
        Solution solution = new SortList().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {} ListNode(int
     * val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val; this.next = next; } }
     */
    class Solution {
        public ListNode sortList(ListNode head) {
            return sortList(head, null);
        }

        private ListNode sortList(ListNode head, ListNode tail) {
            if (head == null) {
                return null;
            }
            if (head.next == tail) {
                head.next = null;
                return head;
            }
            ListNode fast = head;
            ListNode slow = head;
            while (fast != tail) {
                fast = fast.next;
                slow = slow.next;
                if (fast != tail) {
                    fast = fast.next;
                }
            }
            ListNode mid = slow;
            ListNode list1 = sortList(head, mid);
            ListNode list2 = sortList(mid, tail);
            return merge(list1, list2);
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