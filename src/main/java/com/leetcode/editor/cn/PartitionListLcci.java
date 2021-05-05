package com.leetcode.editor.cn;

//编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。
//分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。 
//
// 示例: 
//
// 输入: head = 3->5->8->5->10->2->1, x = 5
//输出: 3->1->2->10->5->5->8
// 
// Related Topics 链表 双指针 
// 👍 58 👎 0


import com.leetcode.editor.cn.list.ListNode;

public class PartitionListLcci {
    public static void main(String[] args) {
        Solution solution = new PartitionListLcci().new Solution();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        System.out.println(solution.partition(node1, 3));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode preSmall = new ListNode(-1);
            ListNode preSmallIndex = preSmall;
            ListNode preBig = new ListNode(-1);
            ListNode preBigIndex = preBig;
            ListNode cur = head;
            while (cur != null) {
                if (cur.val < x) {
                    preSmallIndex.next = cur;
                    preSmallIndex = preSmallIndex.next;
                } else {
                    preBigIndex.next = cur;
                    preBigIndex = preBigIndex.next;
                }
                cur = cur.next;
            }
            if (preBig != preBigIndex) {
                preBigIndex.next = null;
            }
            preSmallIndex.next = preBig.next;
            return preSmall.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}