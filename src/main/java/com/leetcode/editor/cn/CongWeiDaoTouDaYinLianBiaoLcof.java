package com.leetcode.editor.cn;

//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 链表 
// 👍 116 👎 0


import java.util.LinkedList;

public class CongWeiDaoTouDaYinLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int[] reversePrint(ListNode head) {
            ListNode cur = head;
            LinkedList<Integer> stack = new LinkedList<>();
            while (cur != null) {
                stack.addFirst(cur.val);
                cur = cur.next;
            }
            int[] ret = new int[stack.size()];
            int i = 0;
            while (!stack.isEmpty()) {
                ret[i] = stack.pollFirst();
                i++;
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}