package com.leetcode.editor.cn;

//给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。 
//
// 你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。 
//
// 
//
// 示例 1： 
//输入: 
//
//   5
// /  \
//2   -3
// 
//
// 返回 [2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。 
//
// 示例 2： 
//输入： 
//
//   5
// /  \
//2   -5
// 
//
// 返回 [2]，只有 2 出现两次，-5 只出现 1 次。 
//
// 
//
// 提示： 假设任意子树元素和均可以用 32 位有符号整数表示。 
// Related Topics 树 深度优先搜索 哈希表 二叉树 
// 👍 117 👎 0


import com.leetcode.editor.cn.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MostFrequentSubtreeSum {
    public static void main(String[] args) {
        Solution solution = new MostFrequentSubtreeSum().new Solution();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-3);
        solution.findFrequentTreeSum(root);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
     * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val;
     * this.left = left; this.right = right; } }
     */
    class Solution {

        private Map<TreeNode, Integer> map = new HashMap<>();

        private Map<Integer, Integer> valNumMap = new HashMap<>();

        public int[] findFrequentTreeSum(TreeNode root) {
            dfs(root);
            Map<Integer, List<Integer>> retMap = new HashMap<>();
            int max = 0;
            for (Map.Entry<Integer, Integer> entry : valNumMap.entrySet()) {
                List<Integer> ans = retMap.getOrDefault(entry.getValue(),new ArrayList<>());
                max = Math.max(entry.getValue(), max);
                ans.add(entry.getKey());
                retMap.put(entry.getValue(), ans);

            }
            List<Integer> anList = retMap.getOrDefault(max, new ArrayList<>());
            int length = anList.size();
            int[] ans = new int[length];
            for (int i = 0; i < length; i++) {
                ans[i] = anList.get(i);
            }
            return ans;
        }

        private int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            Integer val = map.get(root);
            if (val != null) {
                return val;
            }
            val = root.val + dfs(root.left) + dfs(root.right);
            valNumMap.put(val, valNumMap.getOrDefault(val, 0) + 1);
            return val;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}