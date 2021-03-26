package com.leetcode.editor.cn.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author earthchen
 * @date 2021/3/26
 **/
public class BinTreeMain {

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        System.out.println(first(one));
        List<Integer> ret2 = new ArrayList<>();
        first2(one, ret2);
        System.out.println(ret2);


        System.out.println(mid(one));
        ret2 = new ArrayList<>();
        mid2(one, ret2);
        System.out.println(ret2);

        System.out.println(end(one));
        ret2 = new ArrayList<>();
        end2(one, ret2);
        System.out.println(ret2);


    }


    public static void end2(TreeNode root, List<Integer> ret) {
        if (root == null) {
            return;
        }
        end2(root.left, ret);
        end2(root.right, ret);
        ret.add(root.val);
    }


    public static List<Integer> end(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node == null) {
                stack.pop();
                node = stack.pop();
                ret.add(node.val);
            } else {
                node = stack.pop();
                TreeNode left = node.left;
                TreeNode right = node.right;
                stack.push(node);
                stack.push(null);

                if (right != null) {
                    stack.push(right);
                }
                if (left != null) {
                    stack.push(left);
                }
            }
        }
        return ret;

    }


    public static List<Integer> mid(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node == null) {
                stack.pop();
                node = stack.pop();
                ret.add(node.val);
            } else {
                node = stack.pop();
                TreeNode left = node.left;
                TreeNode right = node.right;
                if (right != null) {
                    stack.push(right);
                }
                stack.push(node);
                stack.push(null);
                if (left != null) {
                    stack.push(left);
                }
            }
        }
        return ret;
    }


    public static void mid2(TreeNode root, List<Integer> ret) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        mid2(left, ret);
        ret.add(root.val);
        mid2(right, ret);
    }


    public static List<Integer> first(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root != null) {
            stack.add(root);
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node == null) {
                stack.pop();
                node = stack.pop();
                ret.add(node.val);
            } else {
                stack.pop();
                TreeNode left = node.left;
                TreeNode right = node.right;
                if (right != null) {
                    stack.push(right);
                }
                if (left != null) {
                    stack.push(left);
                }
                stack.push(node);
                stack.push(null);
            }
        }
        return ret;
    }

    public static void first2(TreeNode node, List<Integer> ret) {
        if (node == null) {
            return;
        }
        ret.add(node.val);
        first2(node.left, ret);
        first2(node.right, ret);
    }
}
