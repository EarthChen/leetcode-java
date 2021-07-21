package com.leetcode.editor.cn;

//随机产生数字并传递给一个方法。你能否完成这个方法，在每次产生新值时，寻找当前所有值的中间值（中位数）并保存。 
//
// 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。 
//
// 例如， 
//
// [2,3,4] 的中位数是 3 
//
// [2,3] 的中位数是 (2 + 3) / 2 = 2.5 
//
// 设计一个支持以下两种操作的数据结构： 
//
// 
// void addNum(int num) - 从数据流中添加一个整数到数据结构中。 
// double findMedian() - 返回目前所有元素的中位数。 
// 
//
// 示例： 
//
// addNum(1)
//addNum(2)
//findMedian() -> 1.5
//addNum(3) 
//findMedian() -> 2
// 
// Related Topics 设计 双指针 数据流 排序 堆（优先队列） 
// 👍 21 👎 0


import java.util.PriorityQueue;

public class ContinuousMedianLcci {
    public static void main(String[] args) {
        // Solution solution = new ContinuousMedianLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MedianFinder {

        private PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> b - a);
        private PriorityQueue<Integer> min = new PriorityQueue<>();

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {


        }

        public void addNum(int num) {
            if (max.size() != min.size()) {
                min.add(num);
                max.add(min.poll());
            } else {
                max.add(num);
                min.add(max.poll());
            }

        }

        public double findMedian() {
            if (max.size() == min.size()) {
                return (min.peek() + max.peek()) / 2.0;
            }
            return min.peek();
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)

}