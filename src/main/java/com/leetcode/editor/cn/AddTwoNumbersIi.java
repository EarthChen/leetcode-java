package com.leetcode.editor.cn;

//给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。 
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 
//
// 进阶： 
//
// 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。 
//
// 
//
// 示例： 
//
// 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 8 -> 0 -> 7
// 
// Related Topics 链表 
// 👍 390 👎 0


import com.leetcode.editor.cn.list.ListNode;

import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbersIi {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbersIi().new Solution();
        System.out.println(solution.addTwoNumbers(ListNode.newListNode(7, 2, 4, 3), ListNode.newListNode(5, 6, 4)));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {} ListNode(int
     * val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val; this.next = next; } }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            List<Integer> list1 = getValList(l1);
            List<Integer> list2 = getValList(l2);
            int i1 = list1.size() - 1;
            int i2 = list2.size() - 1;
            ListNode last = null;
            int n = 0;
            while (i1 >= 0 && i2 >= 0) {
                int sum = list1.get(i1) + list2.get(i2) + n;
                if (sum >= 10) {
                    n = 1;
                    sum = sum - 10;
                } else {
                    n = 0;
                }
                ListNode node = new ListNode(sum, last);
                last = node;
                i1--;
                i2--;
            }
            while (i1 >= 0) {
                int sum = list1.get(i1) + n;
                if (sum >= 10) {
                    n = 1;
                    sum = sum - 10;
                } else {
                    n = 0;
                }
                ListNode node = new ListNode(sum, last);
                last = node;
                i1--;
            }
            while (i2 >= 0) {
                int sum = list2.get(i2) + n;
                if (sum >= 10) {
                    n = 1;
                    sum = sum - 10;
                } else {
                    n = 0;
                }
                ListNode node = new ListNode(sum, last);
                last = node;
                i2--;
            }
            if (n > 0) {
                ListNode node = new ListNode(n, last);
                last = node;
            }
            return last;
        }

        private List<Integer> getValList(ListNode head) {
            List<Integer> list1 = new ArrayList<>();
            ListNode cur1 = head;
            while (cur1 != null) {
                list1.add(cur1.val);
                cur1 = cur1.next;
            }
            return list1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}