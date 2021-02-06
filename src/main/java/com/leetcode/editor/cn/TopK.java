package com.leetcode.editor.cn;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author earthchen
 * @date 2021/1/31
 **/
public class TopK {

    public int[] topSmallK(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[]{};
        }
        Queue<Integer> queue = new PriorityQueue<>(k, (i1, i2) -> Integer.compare(i2, i1));
        for (int num : nums) {
            if (queue.size() < k || queue.peek() > num) {
                queue.offer(num);
            }
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] rs = new int[k];
        int i = 0;
        for (Integer integer : queue) {
            rs[i] = integer;
            i++;
        }
        return rs;
    }


    public int[] topSmallKQuackSort(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[]{};
        }
        quackSort(nums, 0, nums.length-1, k);
        int[] kNums = new int[k];
        for (int i = 0; i < k; i++) {
            kNums[i] = nums[i];
        }
        return kNums;
    }

    public void quackSort(int[] nums, int left, int right, int k) {
        if (left >= right) {
            return;
        }
        int m = part(nums, left, right);
        if (m == k) {
            return;
        } else if (m > k) {
            quackSort(nums, left, m - 1, k);
        } else {
            quackSort(nums, m + 1, right, k);
        }
    }

    private int part(int[] nums, int left, int right) {
        int part = nums[left];
        int lp = left;
        int rp = right;
        while (lp < rp) {
            while (nums[lp] < part) {
                lp++;
            }
            while (nums[rp] > part) {
                rp--;
            }
            swap(nums, lp, rp);
        }
        return lp;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public int[] topBigK(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[]{};
        }
        Queue<Integer> queue = new PriorityQueue<>(k);
        for (int num : nums) {
            if (queue.size() < k || queue.peek() < num) {
                queue.offer(num);
            }
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] rs = new int[k];
        int i = 0;
        for (Integer integer : queue) {
            rs[i] = integer;
            i++;
        }
        return rs;
    }


    public static void main(String[] args) {
        TopK topK = new TopK();

        int[] nums = topK.topSmallK(new int[]{
                1, 2, 3, 4, 5, 6, 7, -1
        }, 3);
        for (int num : nums) {
            System.out.println(num);
        }

        nums = topK.topBigK(new int[]{
                1, 2, 3, 4, 5, 6, 7, -1
        }, 3);
        for (int num : nums) {
            System.out.println(num);
        }

        System.out.println("---------");

        nums = topK.topSmallKQuackSort(new int[]{
                1, 2, 3, 4, 5, 6, 7, -1
        }, 3);
        for (int num : nums) {
            System.out.println(num);
        }

    }
}
