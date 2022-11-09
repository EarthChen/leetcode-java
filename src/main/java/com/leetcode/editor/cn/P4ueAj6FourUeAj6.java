//给定循环单调非递减列表中的一个点，写一个函数向这个列表中插入一个新元素 insertVal ，使这个列表仍然是循环升序的。 
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
// 
// 注意：本题与主站 708 题相同： https://leetcode-cn.com/problems/insert-into-a-sorted-
//circular-linked-list/ 
//
// Related Topics 链表 👍 129 👎 0


package com.leetcode.editor.cn;

//Java：排序的循环链表
public class P4ueAj6FourUeAj6 {
    public static void main(String[] args) {
        Solution solution = new P4ueAj6FourUeAj6().new Solution();
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node1 = new Node(1);
        node3.next = node4;
        node4.next = node1;
        node1.next = node3;
        solution.insert(node3, 2);

        // TO TEST
    }

    // /*
// Definition for a Node.
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

    ;
// */

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public Node insert(Node head, int insertVal) {
            if (head == null) {
                Node node = new Node(insertVal);
                node.next = node;
                return node;
            }
            if (head.next == head) {
                head.next = new Node(insertVal, head);
                return head;
            }
            Node cur = head;
            while (cur.next != head) {
                if (cur.val <= insertVal && cur.next.val >= insertVal) {
                    break;
                }
                // 在最大值后面或者最小值前面
                if (cur.val > cur.next.val) {
                    if (cur.val <= insertVal || insertVal <= cur.next.val) {
                        break;
                    }
                }
                cur = cur.next;
            }
            cur.next = new Node(insertVal, cur.next);
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}