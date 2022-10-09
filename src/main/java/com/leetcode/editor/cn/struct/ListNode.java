package com.leetcode.editor.cn.struct;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


    public static ListNode newListNode(int... vals) {
        ListNode pre = new ListNode();
        ListNode cur = pre;
        for (int val : vals) {
            cur.next = new ListNode(val);
            cur = cur.next;
        }
        return pre.next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}