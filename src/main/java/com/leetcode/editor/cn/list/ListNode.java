package com.leetcode.editor.cn.list;

/**
 * @author earthchen
 * @date 2021/3/21
 **/
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }


    public static ListNode newListNode(int... vals) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        for (int val : vals) {
            cur.next = new ListNode(val);
            cur = cur.next;
        }
        return pre.next;
    }
}
