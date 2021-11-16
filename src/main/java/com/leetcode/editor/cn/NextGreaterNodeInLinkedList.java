package com.leetcode.editor.cn;

//给出一个以头节点 head 作为第一个节点的链表。链表中的节点分别编号为：node_1, node_2, node_3, ... 。 
//
// 每个节点都可能有下一个更大值（next larger value）：对于 node_i，如果其 next_larger(node_i) 是 node_j.
//val，那么就有 j > i 且 node_j.val > node_i.val，而 j 是可能的选项中最小的那个。如果不存在这样的 j，那么下一个更大值为 0
// 。 
//
// 返回整数答案数组 answer，其中 answer[i] = next_larger(node_{i+1}) 。 
//
// 注意：在下面的示例中，诸如 [2,1,5] 这样的输入（不是输出）是链表的序列化表示，其头节点的值为 2，第二个节点值为 1，第三个节点值为 5 。 
//
// 
//
// 示例 1： 
//
// 输入：[2,1,5]
//输出：[5,5,0]
// 
//
// 示例 2： 
//
// 输入：[2,7,4,3,5]
//输出：[7,0,5,5,0]
// 
//
// 示例 3： 
//
// 输入：[1,7,5,1,9,2,5,1]
//输出：[7,9,9,9,0,5,0,0]
// 
//
// 
//
// 提示： 
//
// 
// 对于链表中的每个节点，1 <= node.val <= 10^9 
// 给定列表的长度在 [0, 10000] 范围内 
// 
// Related Topics 栈 数组 链表 单调栈 👍 176 👎 0


import com.leetcode.editor.cn.list.ListNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class NextGreaterNodeInLinkedList {
    public static void main(String[] args) {
        Solution solution = new NextGreaterNodeInLinkedList().new Solution();
        // int[] ans = solution.nextLargerNodes(ListNode.newListNode(2, 1, 5));
        int[] ans2 = solution.nextLargerNodes(ListNode.newListNode(2, 7, 4, 3, 5));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {} ListNode(int
     * val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val; this.next = next; } }
     */
    class Solution {
        public int[] nextLargerNodes(ListNode head) {
            Map<Integer, Integer> ans = new HashMap<>();
            LinkedList<int[]> stack = new LinkedList<>();
            ListNode cur = head;
            int index = 0;
            while (cur != null) {
                while (!stack.isEmpty() && stack.peekLast()[0] < cur.val) {
                    int[] top = stack.pollLast();
                    ans.put(top[1], cur.val);
                }
                stack.addLast(new int[]{cur.val, index});
                cur = cur.next;
                index++;
            }
            int[] ret = new int[index];
            for (int i = 0; i < index; i++) {
                ret[i] = ans.getOrDefault(i, 0);
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}