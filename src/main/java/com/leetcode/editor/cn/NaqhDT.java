package com.leetcode.editor.cn;

//完全二叉树是每一层（除最后一层外）都是完全填充（即，节点数达到最大，第 n 层有 2n-1 个节点）的，并且所有的节点都尽可能地集中在左侧。 
//
// 设计一个用完全二叉树初始化的数据结构 CBTInserter，它支持以下几种操作： 
//
// 
// CBTInserter(TreeNode root) 使用根节点为 root 的给定树初始化该数据结构； 
// CBTInserter.insert(int v) 向树中插入一个新节点，节点类型为 TreeNode，值为 v 。使树保持完全二叉树的状态，并返回插入的
//新节点的父节点的值； 
// CBTInserter.get_root() 将返回树的根节点。 
// 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：inputs = ["CBTInserter","insert","get_root"], inputs = [[[1]],[2],[]]
//输出：[null,1,[1,2]]
// 
//
// 示例 2： 
//
// 
//输入：inputs = ["CBTInserter","insert","insert","get_root"], inputs = [[[1,2,3,4,
//5,6]],[7],[8],[]]
//输出：[null,3,4,[1,2,3,4,5,6,7,8]]
// 
//
// 
//
// 提示： 
//
// 
// 最初给定的树是完全二叉树，且包含 1 到 1000 个节点。 
// 每个测试用例最多调用 CBTInserter.insert 操作 10000 次。 
// 给定节点或插入节点的每个值都在 0 到 5000 之间。 
// 
//
// 
//
// 注意：本题与主站 919 题相同： https://leetcode-cn.com/problems/complete-binary-tree-inser
//ter/ 
// Related Topics 树 广度优先搜索 设计 二叉树 
// 👍 0 👎 0


import com.leetcode.editor.cn.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class NaqhDT {
    public static void main(String[] args) {
        // Solution solution = new NaqhDT().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
     * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val;
     * this.left = left; this.right = right; } }
     */
    class CBTInserter {

        TreeNode root;
        List<TreeNode> list = new ArrayList<>(); //倒数第二层
        List<TreeNode> next = new ArrayList<>(); //最后一层

        public CBTInserter(TreeNode root) {
            this.root = root;
            bfs(root);
        }

        public int insert(int v) {
            TreeNode node = new TreeNode(v);
            if(next.size() < list.size() * 2) { //判断是否满了
                TreeNode last = list.get(next.size() / 2);
                addAsChild(last, node);
                return last.val;
            }
            list = new ArrayList<>(next);
            list.get(0).left = node;
            next.clear();
            next.add(node);
            return list.get(0).val;
        }

        public TreeNode get_root() {
            return root;
        }

        private void bfs(TreeNode root) {
            list.add(root);
            while(true) {
                for (TreeNode cur : list) {
                    if (cur.left != null) {
                        next.add(cur.left);
                    }
                    if (cur.right != null) {
                        next.add(cur.right);
                    }
                }
                if(next.size() == list.size() * 2) {
                    list = new ArrayList<>(next);
                    next.clear();
                } else {
                    break;
                }
            }
        }

        private void addAsChild(TreeNode node, TreeNode subnode) {
            if(node.left == null) {
                node.left = subnode;
            } else {
                node.right = subnode;
            }
            next.add(subnode);
        }

    }

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(v);
 * TreeNode param_2 = obj.get_root();
 */
//leetcode submit region end(Prohibit modification and deletion)

}