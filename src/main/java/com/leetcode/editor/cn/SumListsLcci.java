package com.leetcode.editor.cn;

//给定两个用链表表示的整数，每个节点包含一个数位。 
//
// 这些数位是反向存放的，也就是个位排在链表首部。 
//
// 编写函数对这两个整数求和，并用链表形式返回结果。 
//
// 
//
// 示例： 
//
// 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
//输出：2 -> 1 -> 9，即912
// 
//
// 进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢? 
//
// 示例： 
//
// 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
//输出：9 -> 1 -> 2，即912
// 
// Related Topics 链表 数学 
// 👍 66 👎 0


import com.leetcode.editor.cn.list.ListNode;

public class SumListsLcci {
    public static void main(String[] args) {
        Solution solution = new SumListsLcci().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode cur1 = l1;
            ListNode cur2 = l2;
            // ListNode last = null;
            ListNode pre = new ListNode(-1);
            ListNode curPre = pre;
            int num = 0;
            while (cur1 != null || cur2 != null) {
                int val1 = 0;
                if (cur1 != null) {
                    val1 = cur1.val;
                    cur1 = cur1.next;
                }
                int val2 = 0;
                if (cur2 != null) {
                    val2 = cur2.val;
                    cur2 = cur2.next;
                }
                int curVal = val1 + val2 + num;
                if (curVal >= 10) {
                    num = 1;
                    curVal = curVal - 10;
                } else {
                    num = 0;
                }
                ListNode node = new ListNode(curVal);
                curPre.next = node;
                curPre = curPre.next;
                // last = node;
            }
            if (num > 0) {
                ListNode node = new ListNode(num);
                curPre.next = node;
                // last = node;
            }
            return pre.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}