package com.leetcode.editor.cn;

//给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。 
//
// 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "1111"
//输出：["1.1.1.1"]
// 
//
// 示例 4： 
//
// 
//输入：s = "010010"
//输出：["0.10.0.10","0.100.1.0"]
// 
//
// 示例 5： 
//
// 
//输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3000 
// s 仅由数字组成 
// 
// Related Topics 字符串 回溯 👍 658 👎 0


import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    public static void main(String[] args) {
        Solution solution = new RestoreIpAddresses().new Solution();
        System.out.println(solution.restoreIpAddresses("25525511135"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private List<String> ret = new ArrayList<>();

        public List<String> restoreIpAddresses(String s) {
            int length = s.length();
            if (length < 4) {
                return new ArrayList<>();
            }
            dfs(s, 0, new ArrayList<>());
            return ret;
        }

        private void dfs(String str, int start, List<String> ans) {
            int length = str.length();
            if (ans.size() == 4) {
                if (start < length) {
                    return;
                }
                StringBuilder sb = new StringBuilder();
                int count = 0;
                for (String an : ans) {
                    count += an.length();
                    sb.append(an).append('.');
                }
                sb.deleteCharAt(sb.length() - 1);
                if (count != length) {
                    return;
                }
                ret.add(sb.toString());
                return;
            }
            if (start >= length) {
                return;
            }

            for (int i = start; i < length; i++) {
                int maxLeftCount = getMaxLeftCount(ans);
                if (length - i > maxLeftCount) {
                    continue;
                }
                for (int j = i; j < i + 3 && j < length; j++) {
                    String ip = str.substring(i, j + 1);
                    if (isIp(ip)) {
                        ans.add(ip);
                        dfs(str, j + 1, ans);
                        ans.remove(ans.size() - 1);
                    }
                }
            }

        }


        private int getMaxLeftCount(List<String> ans) {
            int curSize = ans.size();
            return (4 - curSize) * 3;
        }

        private boolean isIp(String s) {
            int length = s.length();
            if (length > 3) {
                return false;
            }
            if (s.startsWith("0")) {
                return length == 1;
            }
            int ipNumber = Integer.parseInt(s);
            return ipNumber <= 255;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}