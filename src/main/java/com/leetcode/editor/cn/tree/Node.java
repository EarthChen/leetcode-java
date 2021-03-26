package com.leetcode.editor.cn.tree;

import java.util.List;

/**
 * @author earthchen
 * @date 2021/3/26
 **/
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int val) {
        val = val;
    }

    public Node(int val, List<Node> _children) {
        val = val;
        children = _children;
    }
}