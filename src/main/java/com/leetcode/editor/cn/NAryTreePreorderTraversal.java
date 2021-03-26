package com.leetcode.editor.cn;

//给定一个 N 叉树，返回其节点值的 前序遍历 。 
//
// N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。 
//
// 
// 
// 
//
// 进阶： 
//
// 递归法很简单，你可以使用迭代法完成此题吗? 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,null,3,2,4,null,5,6]
//输出：[1,3,5,6,2,4]
// 
//示例 2：
//
// 
//
// 
//输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,
//null,13,null,null,14]
//输出：[1,2,3,6,7,11,14,4,8,12,5,9,13,10]
// 
//
// 
//
// 提示： 
//
// 
// N 叉树的高度小于或等于 1000 
// 节点总数在范围 [0, 10^4] 内 
// 
// 
// 
// Related Topics 树 
// 👍 149 👎 0


import com.leetcode.editor.cn.tree.Node;

import java.util.ArrayList;
import java.util.List;

public class NAryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new NAryTreePreorderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

    class Solution {

        private List<Integer> list = new ArrayList<>();


        public List<Integer> preorder(Node root) {
            if (root == null) {
                return list;
            }
            list.add(root.val);
            for (Node child : root.children) {
                preorder(child);
            }
            return list;


            // List<Integer> ret = new ArrayList<>();
            // LinkedList<Node> stack = new LinkedList<>();
            // if (root != null) {
            //     stack.push(root);
            // }
            // while (!stack.isEmpty()) {
            //     Node node = stack.peek();
            //     if (node == null) {
            //         stack.pop();
            //         node = stack.pop();
            //         ret.add(node.val);
            //     } else {
            //         node = stack.pop();
            //         List<Node> nodes = node.children;
            //         for (int i = nodes.size() - 1; i >= 0; i--) {
            //             stack.push(nodes.get(i));
            //         }
            //         stack.push(node);
            //         stack.push(null);
            //     }
            // }
            // return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}