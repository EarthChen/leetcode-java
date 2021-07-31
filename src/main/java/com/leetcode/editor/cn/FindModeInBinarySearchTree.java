package com.leetcode.editor.cn;

//给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。 
//
// 假定 BST 有如下定义： 
//
// 
// 结点左子树中所含结点的值小于等于当前结点的值 
// 结点右子树中所含结点的值大于等于当前结点的值 
// 左子树和右子树都是二叉搜索树 
// 
//
// 例如： 
//给定 BST [1,null,2,2], 
//
//    1
//    \
//     2
//    /
//   2
// 
//
// 返回[2]. 
//
// 提示：如果众数超过1个，不需考虑输出顺序 
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 
// 👍 328 👎 0


import com.leetcode.editor.cn.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindModeInBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new FindModeInBinarySearchTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
     * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val;
     * this.left = left; this.right = right; } }
     */
    class Solution {
        int count = 0;  //记当前个数
        int max = 1;    //记最大值
        int pre_value = 0;  //记前一个value
        List<Integer> list = new ArrayList();  //一个个添加 只能用list

        public int[] findMode(TreeNode root) {
            BST(root);
            int[] result = new int[list.size()];  //初始化数组
            for (int i = 0; i < list.size(); i++) {  //list转array
                result[i] = list.get(i);
            }
            return result;
        }

        public void BST(TreeNode root) {    //左根右；中序遍历；从小到大
            if (root == null) {
                return;
            }
            BST(root.left);

            if (root.val == pre_value) { //如果和前一个相同 count+1
                count++;
            } else {       //不同； 刷新count=1；刷新pre_value
                pre_value = root.val;
                count = 1;
            }
            if (count == max) {   //如果是最大个数
                list.add(root.val); //加入list里
            } else if (count > max) {   //如果超过最大个数
                list.clear();   //清空整个list
                list.add(root.val); //加入list里（新的max）
                max = count;    //刷新max
            }

            BST(root.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}