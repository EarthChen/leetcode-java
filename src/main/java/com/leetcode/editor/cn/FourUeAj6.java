package com.leetcode.editor.cn;

//给定循环升序列表中的一个点，写一个函数向这个列表中插入一个新元素 insertVal ，使这个列表仍然是循环升序的。 
//
// 给定的可以是这个列表中任意一个顶点的指针，并不一定是这个列表中最小元素的指针。 
//
// 如果有多个满足条件的插入位置，可以选择任意一个位置插入新的值，插入后整个列表仍然保持有序。 
//
// 如果列表为空（给定的节点是 null），需要创建一个循环有序列表并返回这个节点。否则。请返回原先给定的节点。 
//
// 
//
// 示例 1： 
//
// 
// 
//
// 
//输入：head = [3,4,1], insertVal = 2
//输出：[3,4,1,2]
//解释：在上图中，有一个包含三个元素的循环有序列表，你获得值为 3 的节点的指针，我们需要向表中插入元素 2 。新插入的节点应该在 1 和 3 之间，插入之后
//，整个列表如上图所示，最后返回节点 3 。
//
//
// 
//
// 示例 2： 
//
// 
//输入：head = [], insertVal = 1
//输出：[1]
//解释：列表为空（给定的节点是 null），创建一个循环有序列表并返回这个节点。
// 
//
// 示例 3： 
//
// 
//输入：head = [1], insertVal = 0
//输出：[1,0]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= Number of Nodes <= 5 * 10^4 
// -10^6 <= Node.val <= 10^6 
// -10^6 <= insertVal <= 10^6 
// 
//
// 
//
// 注意：本题与主站 708 题相同： https://leetcode-cn.com/problems/insert-into-a-sorted-circular-linked-list/
// Related Topics 链表 
// 👍 6 👎 0


public class FourUeAj6 {
    public static void main(String[] args) {
        Solution solution = new FourUeAj6().new Solution();
        Node node3 = new Node(3);
        Node node4 = new Node(3);
        Node node1 = new Node(3);
        node3.next = node4;
        node4.next = node1;
        node1.next = node3;
        Node node = solution.insert(node3, 2);

        System.out.println();
    }


    static class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }

    }

    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
*/


    class Solution {

        /**
         * 1.插入元素大于等于链表最小值，小于等于链表最大值
         * <p>
         * 2.插入的是一个比链表最小值还小或者相等的数，比链表最大值还大或者相等的数
         * <p>
         * 第一种情况直接插入
         * <p>
         * 第二种情况插入的节点都在链表最大值之后
         *
         * @param head
         * @param insertVal
         * @return
         */
        public Node insert(Node head, int insertVal) {
            if (head == null) {
                Node newHead = new Node(insertVal);
                newHead.next = newHead;
                return newHead;
            }
            Node max = null;
            Node cur = head;
            do {
                if (insertVal >= cur.val && insertVal <= cur.next.val) {
                    cur.next = new Node(insertVal, cur.next);
                    return head;
                }
                if (cur.val > cur.next.val) {
                    max = cur;
                }
                cur = cur.next;
            } while (cur != head);
            max = max == null ? cur : max;
            max.next = new Node(insertVal, max.next);
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}