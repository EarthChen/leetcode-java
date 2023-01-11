//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
// 
//
// 示例 2： 
// 
// 
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 500] 内 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 10⁹ 
// 
//
// Related Topics 链表 双指针 👍 877 👎 0


package com.leetcode.editor.cn;

import com.leetcode.editor.cn.struct.ListNode;

//Java：旋转链表
public class P61RotateList {
    public static void main(String[] args) {
        Solution solution = new P61RotateList().new Solution();
        ListNode head = ListNode.newListNode(1, 2, 3, 4, 5);
        ListNode ret = solution.rotateRight(head, 2);
        System.out.println(ret);
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val; this.next = next; } }
     */
    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null) {
                return null;
            }
            int size = 0;
            ListNode cur = head;
            while (cur != null) {
                size++;
                cur = cur.next;
            }
            int number = k % size;
            if (number == 0) {
                return head;
            }
            cur = head;
            ListNode fast = head;
            for (int i = 0; i < number; i++) {
                fast = fast.next;
            }
            while (fast.next != null) {
                cur = cur.next;
                fast = fast.next;
            }
            ListNode node = cur.next;
            ListNode tmp = node;
            cur.next = null;
            for (int i = 1; i < number; i++) {
                tmp = tmp.next;
            }
            tmp.next = head;
            return node;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}