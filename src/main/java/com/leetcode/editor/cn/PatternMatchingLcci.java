package com.leetcode.editor.cn;

//你有两个字符串，即pattern和value。 pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。例如，字符串"catcatgocatg
//o"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），该字符串也匹配像"a"、"ab"和"b"这样的模式。但需注意"a"和"b"不能同时表示相
//同的字符串。编写一个方法判断value字符串是否匹配pattern字符串。 
//
// 示例 1： 
//
// 输入： pattern = "abba", value = "dogcatcatdog"
//输出： true
// 
//
// 示例 2： 
//
// 输入： pattern = "abba", value = "dogcatcatfish"
//输出： false
// 
//
// 示例 3： 
//
// 输入： pattern = "aaaa", value = "dogcatcatdog"
//输出： false
// 
//
// 示例 4： 
//
// 输入： pattern = "abba", value = "dogdogdogdog"
//输出： true
//解释： "a"="dogdog",b=""，反之也符合规则
// 
//
// 提示： 
//
// 
// 1 <= len(pattern) <= 1000 
// 0 <= len(value) <= 1000 
// 你可以假设pattern只包含字母"a"和"b"，value仅包含小写字母。 
// 
// Related Topics 字符串 
// 👍 111 👎 0


public class PatternMatchingLcci {
    public static void main(String[] args) {
        Solution solution = new PatternMatchingLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean patternMatching(String pattern, String value) {
            // 如果pattern不含任意字符，则返回为value是否为空
            if (pattern == null || pattern.length() == 0) {
                return value == null || value.length() == 0;
            }

            int cntA = 0, cntB = 0;
            // 其实a和b是可以互相替换的，因此为了下面方便起见，将首次出现的字母当作a
            char first = pattern.charAt(0);
            for (int i = 0; i < pattern.length(); i++) {
                if (pattern.charAt(i) == first) {
                    cntA++;
                } else {
                    cntB++;
                }
            }

            // 如果a和b有一个是只出现一次，那么一定可以正确表示（另一个表示为空串即可）
            if (cntA != cntB && (cntA == 1 || cntB == 1)) {
                return true;
            }

            int aPresentLength = 0, bPresentLength;
            while (aPresentLength * cntA <= value.length()) {
                // 除去所有a表示字符串后，剩余的字符串长度
                int left = value.length() - aPresentLength * cntA;

                // 如果cntB是0 或者 剩余的字符串是cntB的倍数，则才有可能组成value
                if ((cntB == 0 && left == 0) || (cntB != 0 && left % cntB == 0)) {
                    // 计算b表示的字符串长度
                    bPresentLength = cntB == 0 ? 0 : left / cntB;

                    // 计算a表示的字符串
                    String aPresent = value.substring(0, aPresentLength), bPresent = "";

                    int index = 1;
                    // 找到b首次出现的位置，得到b代表的字符串
                    while (index < pattern.length() && pattern.charAt(index) == first) {
                        ++index;
                    }
                    // 避免越界
                    if (index < pattern.length()) {
                        // 计算b表示的字符串
                        int from = aPresentLength * index, to = from + bPresentLength;
                        bPresent = value.substring(from, to);
                    }

                    // 如果此时a和b表示的字符串相等，则不符合题意
                    if (aPresent.equals(bPresent)) {
                        ++aPresentLength;
                        continue;
                    }

                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < pattern.length(); i++) {
                        if (pattern.charAt(i) == first) {
                            sb.append(aPresent);
                        } else {
                            sb.append(bPresent);
                        }
                    }
                    if (sb.toString().equals(value)) {
                        return true;
                    }
                }
                // 这里如果cntA为0的话，则在上面的if语句里已经计算过了，如果一味增加
                // a的长度，那么会陷入死循环
                if (cntA == 0) {
                    break;
                }

                aPresentLength++;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}