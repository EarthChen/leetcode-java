package com.leetcode.editor.cn;

//序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。 
//
//      _9_
//    /   \
//   3     2
//  / \   / \
// 4   1  #  6
/// \ / \   / \
//# # # #   # #
// 
//
// 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。 
//
// 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。 
//
// 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。 
//
// 你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。 
//
// 示例 1: 
//
// 输入: "9,3,4,#,#,1,#,#,2,#,6,#,#"
//输出: true 
//
// 示例 2: 
//
// 输入: "1,#"
//输出: false
// 
//
// 示例 3: 
//
// 输入: "9,#,#,1"
//输出: false 
// Related Topics 栈 树 字符串 二叉树 
// 👍 323 👎 0


import java.util.LinkedList;

public class VerifyPreorderSerializationOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new VerifyPreorderSerializationOfABinaryTree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public static final String SEPARATOR = ",";

        public static final String NULL_VAL = "#";

        public boolean isValidSerialization(String preorder) {
            LinkedList<String> stack = new LinkedList<>();
            for (String s : preorder.split(SEPARATOR)) {
                stack.push(s);
                while (stack.size() >= 3
                        && stack.get(0).equals(NULL_VAL)
                        && stack.get(1).equals(NULL_VAL)
                        && !stack.get(2).equals(NULL_VAL)) {
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.push(NULL_VAL);
                }
            }
            return stack.size() == 1 && stack.pop().equals(NULL_VAL);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}