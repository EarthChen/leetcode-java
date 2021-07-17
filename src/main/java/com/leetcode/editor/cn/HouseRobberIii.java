package com.leetcode.editor.cn;

//在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“
//房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。 
//
// 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。 
//
// 示例 1: 
//
// 输入: [3,2,3,null,3,null,1]
//
//     3
//    / \
//   2   3
//    \   \ 
//     3   1
//
//输出: 7 
//解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7. 
//
// 示例 2: 
//
// 输入: [3,4,5,1,3,null,1]
//
//     3
//    / \
//   4   5
//  / \   \ 
// 1   3   1
//
//输出: 9
//解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
// 
// Related Topics 树 深度优先搜索 动态规划 二叉树 
// 👍 910 👎 0


import com.leetcode.editor.cn.tree.TreeNode;

import java.util.Map;

public class HouseRobberIii {
    public static void main(String[] args) {
        Solution solution = new HouseRobberIii().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
     * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val;
     * this.left = left; this.right = right; } }
     */
    class Solution {
        public int rob(TreeNode root) {
            // return rob(root, new HashMap<>());
            int[] ans = robDP(root);
            return Math.max(ans[0], ans[1]);
        }

        private int[] robDP(TreeNode root) {
            if (root == null) {
                return new int[]{0, 0};
            }
            int[] ans = new int[2];
            int[] leftDP = robDP(root.left);
            int[] rightDP = robDP(root.right);
            ans[0] = Math.max(leftDP[1], leftDP[0]) + Math.max(rightDP[1], rightDP[0]);
            ans[1] = leftDP[0] + rightDP[0] + root.val;
            return ans;
        }


        private int rob(TreeNode root, Map<TreeNode, Integer> map) {
            if (root == null) {
                return 0;
            }
            Integer money = map.get(root);
            if (money != null) {
                return money;
            }
            int ret = root.val;
            TreeNode left = root.left;
            TreeNode right = root.right;
            if (left != null) {
                ret += (rob(left.left, map) + rob(left.right, map));
            }
            if (right != null) {
                ret += (rob(right.left, map) + rob(right.right, map));
            }
            ret = Math.max(ret, rob(root.left, map) + rob(root.right, map));
            map.put(root, ret);
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}