package com.leetcode.editor.cn;

//从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。 
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
// 返回： 
//
// [3,9,20,15,7]
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
// 👍 89 👎 0


import com.leetcode.editor.cn.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CongShangDaoXiaDaYinErChaShuLcof {
    public static void main(String[] args) {
        Solution solution = new CongShangDaoXiaDaYinErChaShuLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode(int
     * x) { val = x; } }
     */
    class Solution {
        public int[] levelOrder(TreeNode root) {
            List<Integer> ret = new ArrayList<>();
            if (root == null) {
                return new int[]{};
            }
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.pollFirst();

                ret.add(node.val);
                TreeNode left = node.left;
                TreeNode right = node.right;
                if (left != null) {
                    queue.add(left);
                }
                if (right != null) {
                    queue.add(right);
                }
            }
            int[] ans = new int[ret.size()];
            for (int i = 0; i < ret.size(); i++) {
                ans[i] = ret.get(i);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}