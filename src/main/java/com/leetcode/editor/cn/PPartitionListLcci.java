//给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。 
//
// 你不需要 保留 每个分区中各节点的初始相对位置。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,4,3,2,5,2], x = 3
//输出：[1,2,2,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [2,1], x = 2
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 200] 内 
// -100 <= Node.val <= 100 
// -200 <= x <= 200 
// 
//
// Related Topics 链表 双指针 👍 161 👎 0


package com.leetcode.editor.cn;

//Java：分割链表
public class PPartitionListLcci {
    public static void main(String[] args) {
        Solution solution = new PPartitionListLcci().new Solution();
        // TO TEST
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     */
    class Solution {
        public ListNode partition(ListNode head, int x) {

            ListNode head1 = new ListNode();
            ListNode cur1 = head1;

            ListNode head2 = new ListNode();
            ListNode cur2 = head2;

            ListNode cur = head;
            while (cur != null) {
                if (cur.val < x) {
                    cur1.next = cur;
                    cur1 = cur1.next;
                } else {
                    cur2.next = cur;
                    cur2 = cur2.next;
                }
                cur = cur.next;
            }
            cur2.next = null;
            cur1.next = head2.next;
            return head1.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}