package com.leetcode.editor.cn;

//假设你正在读取一串整数。每隔一段时间，你希望能找出数字 x 的秩(小于或等于 x 的值的个数)。请实现数据结构和算法来支持这些操作，也就是说： 
//
// 实现 track(int x) 方法，每读入一个数字都会调用该方法； 
//
// 实现 getRankOfNumber(int x) 方法，返回小于或等于 x 的值的个数。 
//
// 注意：本题相对原题稍作改动 
//
// 示例: 
//
// 输入:
//["StreamRank", "getRankOfNumber", "track", "getRankOfNumber"]
//[[], [1], [0], [0]]
//输出:
//[null,0,null,1]
// 
//
// 提示： 
//
// 
// x <= 50000 
// track 和 getRankOfNumber 方法的调用次数均不超过 2000 次 
// 
// Related Topics 设计 树状数组 二分查找 数据流 
// 👍 18 👎 0


import java.util.ArrayList;
import java.util.List;

public class RankFromStreamLcci {
    public static void main(String[] args) {
        // StreamRank streamRank = new StreamRank();
        // // System.out.println(streamRank.getRankOfNumber(8));
        // // System.out.println(streamRank.getRankOfNumber(6));
        // // System.out.println(streamRank.getRankOfNumber(8));
        // streamRank.track(6);
        // // System.out.println(streamRank.getRankOfNumber(7));
        // streamRank.track(1);
        // streamRank.track(8);
        // // System.out.println(streamRank.getRankOfNumber(0));
        // streamRank.track(0);
        // streamRank.track(7);
        // System.out.println(streamRank.getRankOfNumber(5));
        // System.out.println(streamRank.getRankOfNumber(6));
        // System.out.println(streamRank.getRankOfNumber(7));
        // streamRank.print();

        // Solution solution = new RankFromStreamLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class StreamRank {
        // static class StreamRank {

        private List<Integer> list = new ArrayList<>();

        public StreamRank() {
        }

        public void print() {
            System.out.println(list);
        }

        public void track(int x) {
            int i = 0;
            int j = list.size() - 1;
            while (i <= j) {
                int mid = i + (j - i) / 2;
                int midVal = list.get(mid);
                if (midVal == x) {
                    list.add(mid, x);
                    return;
                }
                if (midVal < x) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }
            list.add(i, x);
        }

        public int getRankOfNumber(int x) {
            int length = list.size();
            int i = 0;
            int j = list.size() - 1;
            while (i <= j) {
                int mid = i + (j - i) / 2;
                int midVal = list.get(mid);
                if (midVal == x) {
                    int k = mid + 1;
                    while (k < length) {
                        if (list.get(k) != x) {
                            break;
                        }
                        k++;
                    }
                    return k;
                }
                if (midVal < x) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }
            return j + 1;
        }
    }

/**
 * Your StreamRank object will be instantiated and called as such:
 * StreamRank obj = new StreamRank();
 * obj.track(x);
 * int param_2 = obj.getRankOfNumber(x);
 */
//leetcode submit region end(Prohibit modification and deletion)

}