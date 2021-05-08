package com.leetcode.editor.cn;

//给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。 
//
// 
//
// 示例： 
//
// 输入：[1,2,3,4,5,null,7,8]
//
//        1
//       /  \ 
//      2    3
//     / \    \ 
//    4   5    7
//   /
//  8
//
//输出：[[1],[2,3],[4,5,7],[8]]
// 
// Related Topics 树 广度优先搜索 
// 👍 49 👎 0


import com.leetcode.editor.cn.list.ListNode;
import com.leetcode.editor.cn.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListOfDepthLcci {
    public static void main(String[] args) {
        Solution solution = new ListOfDepthLcci().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
    /**
     * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode[] listOfDepth(TreeNode tree) {
            LinkedList<TreeNode> queue = new LinkedList<>();
            if (tree != null) {
                queue.add(tree);
            }
            List<ListNode> list = new ArrayList<>();
            while (!queue.isEmpty()) {
                int size = queue.size();
                ListNode pre = new ListNode(0);
                ListNode cur = pre;
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.pollFirst();
                    cur.next = new ListNode(node.val);
                    cur = cur.next;
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                list.add(pre.next);
            }
            return list.toArray(new ListNode[0]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}