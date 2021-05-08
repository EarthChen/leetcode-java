package com.leetcode.editor.cn;

//给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。示例: 给定有序数组: [-10,-3,0,5,9], 一个可能
//的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：           0          / \        -3 
//  9        /   /      -10  5 Related Topics 树 深度优先搜索 
// 👍 85 👎 0


import com.leetcode.editor.cn.tree.TreeNode;

public class MinimumHeightTreeLcci {
    public static void main(String[] args) {
        Solution solution = new MinimumHeightTreeLcci().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode(int
     * x) { val = x; } }
     */
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            // Arrays.sort(nums);
            return child(nums, 0, nums.length - 1);
        }

        private TreeNode child(int[] nums, int l, int r) {
            // if (l < 0 || r >= nums.length) {
            //     return null;
            // }
            if (l > r) {
                return null;
            }
            int mid = l + (r - l) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = child(nums, l, mid-1);
            root.right = child(nums, mid+1, r);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}