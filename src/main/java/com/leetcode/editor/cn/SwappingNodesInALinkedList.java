package com.leetcode.editor.cn;

//给你链表的头节点 head 和一个整数 k 。 
//
// 交换 链表正数第 k 个节点和倒数第 k 个节点的值后，返回链表的头节点（链表 从 1 开始索引）。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [7,9,6,6,7,8,3,0,9,5], k = 5
//输出：[7,9,6,6,8,7,3,0,9,5]
// 
//
// 示例 3： 
//
// 
//输入：head = [1], k = 1
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：head = [1,2], k = 1
//输出：[2,1]
// 
//
// 示例 5： 
//
// 
//输入：head = [1,2,3], k = 2
//输出：[1,2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目是 n 
// 1 <= k <= n <= 105 
// 0 <= Node.val <= 100 
// 
// Related Topics 链表 
// 👍 20 👎 0


import com.leetcode.editor.cn.list.ListNode;

import java.util.ArrayList;
import java.util.List;

public class SwappingNodesInALinkedList {
    public static void main(String[] args) {
        Solution solution = new SwappingNodesInALinkedList().new Solution();
        ListNode head = ListNode.newListNode(7, 9, 6, 6, 7, 8, 3, 0, 9, 5);
        // System.out.println(solution.swapNodes(head, 5));

        head = ListNode.newListNode(1, 2);
        System.out.println(solution.swapNodes(head, 2));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {} ListNode(int
     * val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val; this.next = next; } }
     */
    class Solution {
        public ListNode swapNodes(ListNode head, int k) {
            if (head == null) {
                return null;
            }
            ListNode pre = new ListNode(0, head);
            List<ListNode> list = new ArrayList<>();
            ListNode cur = pre;
            while (cur != null) {
                list.add(cur);
                cur = cur.next;
            }
            int mid = list.size() / 2;
            if (k > mid) {
                k = list.size() - k;
            }

            ListNode nodeK1 = list.get(k);

            int k2 = list.size() - k;
            ListNode nodek2 = list.get(k2);
            if (nodeK1 == nodek2) {
                return head;
            }
            ListNode k1Pre = list.get(k - 1);
            ListNode k1Next = nodeK1.next;


            ListNode k2Pre = list.get(k2 - 1);
            ListNode k2Next = nodek2.next;
            if (nodeK1.next == nodek2) {
                k1Pre.next = nodek2;
                nodek2.next = nodeK1;
                nodeK1.next = k2Next;
                return pre.next;
            }

            k1Pre.next = nodek2;
            nodek2.next = k1Next;

            k2Pre.next = nodeK1;
            nodeK1.next = k2Next;
            return pre.next;


            // ListNode cur = pre;
            // int i = 0;
            // while (cur != null) {
            //
            // }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}