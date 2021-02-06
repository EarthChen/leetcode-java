import java.util.HashSet;
import java.util.Set;

/**
 * @author earthchen
 * @date 2021/1/30
 **/
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length == 0) {
            return 0;
        }
        int maxLength = 1;
        for (int i = 0; i < length; i++) {
            Set<Character> charSet = new HashSet<>();
            for (int j = i; j < length; j++) {
                char currentChar = s.charAt(j);
                if (!charSet.contains(currentChar)) {
                    charSet.add(currentChar);
                } else {
                    int currentLength = charSet.size();
                    if (currentLength > maxLength) {
                        maxLength = currentLength;
                    }
                    break;
                }
                if (j == length - 1) {
                    int currentLength = charSet.size();
                    if (currentLength > maxLength) {
                        maxLength = currentLength;
                    }
                }
            }
        }
        return maxLength;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int length = solution.lengthOfLongestSubstring("au");
        System.out.println(length);
    }
}
