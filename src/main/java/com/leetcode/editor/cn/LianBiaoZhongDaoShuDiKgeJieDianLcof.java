package com.leetcode.editor.cn;

//输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。 
//
// 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。 
//
// 
//
// 示例： 
//
// 
//给定一个链表: 1->2->3->4->5, 和 k = 2.
//
//返回链表 4->5. 
// Related Topics 链表 双指针 
// 👍 157 👎 0


import com.leetcode.editor.cn.list.ListNode;

public class LianBiaoZhongDaoShuDiKgeJieDianLcof {
    public static void main(String[] args) {
        Solution solution = new LianBiaoZhongDaoShuDiKgeJieDianLcof().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode getKthFromEnd(ListNode head, int k) {
            int n = 0;
            ListNode cur = head;
            while (cur != null) {
                n++;
                cur = cur.next;
            }
            cur = head;
            int i = 0;
            while (cur != null) {
                if (n - i == k) {
                    return cur;
                }
                i++;
                cur = cur.next;
            }
            return cur;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}