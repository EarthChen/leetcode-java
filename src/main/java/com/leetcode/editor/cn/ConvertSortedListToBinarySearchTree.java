package com.leetcode.editor.cn;

//给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定的有序链表： [-10, -3, 0, 5, 9],
//
//一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics 树 二叉搜索树 链表 分治 二叉树 
// 👍 555 👎 0


import com.leetcode.editor.cn.list.ListNode;
import com.leetcode.editor.cn.tree.TreeNode;

import java.util.List;

public class ConvertSortedListToBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ConvertSortedListToBinarySearchTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
    /**
     * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
     * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val;
     * this.left = left; this.right = right; } }
     */
    class Solution {
        // public TreeNode sortedListToBST(ListNode head) {
        //     List<Integer> valList = new ArrayList<>();
        //     ListNode cur = head;
        //     while (cur != null) {
        //         valList.add(cur.val);
        //         cur = cur.next;
        //     }
        //     return build(valList, 0, valList.size() - 1);
        // }

        private TreeNode build(List<Integer> nums, int i, int j) {
            if (i > j) {
                return null;
            }
            int mid = i + (j - i) / 2;
            int midVal = nums.get(mid);
            TreeNode root = new TreeNode(midVal);
            root.left = build(nums, i, mid - 1);
            root.right = build(nums, mid + 1, j);
            return root;
        }

        ListNode lhead;

        public TreeNode sortedListToBST(ListNode head) {
            lhead = head;
            int length = getListLength(head);
            return inOrderMakeBST(head, 0, length - 1);
        }

        //获得链表长度
        public int getListLength(ListNode head) {
            int length = 0;
            while (head != null) {
                length++;
                head = head.next;
            }
            return length;
        }

        //分治+递归中序生成平衡二叉搜索树
        public TreeNode inOrderMakeBST(ListNode head, int left, int right) {
            //递归终止条件
            if (left > right) {
                return null;
            }
            //mid = (left + right + 1)/2也可以，只是生成的树的叶子位置不同
            int mid = left + (right - left) / 2;
            TreeNode root = new TreeNode(0);
            //分治递归中序遍历生成左右子树
            root.left = inOrderMakeBST(lhead, left, mid - 1);
            root.val = lhead.val;
            lhead = lhead.next;
            root.right = inOrderMakeBST(lhead, mid + 1, right);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}