package com.leetcode.editor.cn;

//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
// Related Topics 树 广度优先搜索 
// 👍 90 👎 0


import com.leetcode.editor.cn.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CongShangDaoXiaDaYinErChaShuIiiLcof {
    public static void main(String[] args) {
        Solution solution = new CongShangDaoXiaDaYinErChaShuIiiLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode(int
     * x) { val = x; } }
     */
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            LinkedList<TreeNode> queue = new LinkedList<>();
            boolean re = false;
            if (root != null) {
                queue.add(root);
                re = false;
            }
            List<List<Integer>> ret = new ArrayList<>();
            while (!queue.isEmpty()) {
                List<Integer> curRet = new ArrayList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node;
                    if (re) {
                        node = queue.pollFirst();
                        if (node.right != null) {
                            queue.addLast(node.right);
                        }
                        if (node.left != null) {
                            queue.addLast(node.left);
                        }
                    } else {
                        node = queue.pollLast();
                        if (node.left != null) {
                            queue.addFirst(node.left);
                        }
                        if (node.right != null) {
                            queue.addFirst(node.right);
                        }
                    }
                    curRet.add(node.val);
                }
                ret.add(curRet);
                re = !re;
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}