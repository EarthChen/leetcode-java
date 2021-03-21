package com.leetcode.editor.cn;

//编写一个函数，检查输入的链表是否是回文的。 
//
// 
//
// 示例 1： 
//
// 输入： 1->2
//输出： false 
// 
//
// 示例 2： 
//
// 输入： 1->2->2->1
//输出： true 
// 
//
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 
// 👍 54 👎 0


import com.leetcode.editor.cn.list.ListNode;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedListLcci {
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedListLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public boolean isPalindrome(ListNode head) {
            ListNode cur = head;
            List<Integer> list = new ArrayList<>();
            while (cur != null) {
                list.add(cur.val);
                cur = cur.next;
            }
            int i = 0;
            int j = list.size() - 1;

            while (i <= j) {
                if (!list.get(i).equals(list.get(j))) {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}