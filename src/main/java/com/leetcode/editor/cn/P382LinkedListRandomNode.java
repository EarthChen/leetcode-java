//给你一个单链表，随机选择链表的一个节点，并返回相应的节点值。每个节点 被选中的概率一样 。 
//
// 实现 Solution 类： 
//
// 
// Solution(ListNode head) 使用整数数组初始化对象。 
// int getRandom() 从链表中随机选择一个节点并返回该节点的值。链表中所有节点被选中的概率相等。 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["Solution", "getRandom", "getRandom", "getRandom", "getRandom", "getRandom"]
//[[[1, 2, 3]], [], [], [], [], []]
//输出
//[null, 1, 3, 2, 2, 3]
//
//解释
//Solution solution = new Solution([1, 2, 3]);
//solution.getRandom(); // 返回 1
//solution.getRandom(); // 返回 3
//solution.getRandom(); // 返回 2
//solution.getRandom(); // 返回 2
//solution.getRandom(); // 返回 3
//// getRandom() 方法应随机返回 1、2、3中的一个，每个元素被返回的概率相等。 
//
// 
//
// 提示： 
//
// 
// 链表中的节点数在范围 [1, 10⁴] 内 
// -10⁴ <= Node.val <= 10⁴ 
// 至多调用 getRandom 方法 10⁴ 次 
// 
//
// 
//
// 进阶： 
//
// 
// 如果链表非常大且长度未知，该怎么处理？ 
// 你能否在不使用额外空间的情况下解决此问题？ 
// 
// Related Topics 水塘抽样 链表 数学 随机化 👍 269 👎 0


package com.leetcode.editor.cn;

import com.leetcode.editor.cn.list.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//Java：链表随机节点
public class P382LinkedListRandomNode {
    public static void main(String[] args) {
//        Solution solution = new P382LinkedListRandomNode().new Solution(ListNode.createListNode(new int[]{1, 2, 3}));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {

        private List<Integer> list = new ArrayList<>();

        private Random random = new Random();

        public Solution(ListNode head) {
            ListNode cur = head;
            while (cur != null) {
                list.add(cur.val);
                cur = cur.next;
            }
        }

        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
//leetcode submit region end(Prohibit modification and deletion)

}