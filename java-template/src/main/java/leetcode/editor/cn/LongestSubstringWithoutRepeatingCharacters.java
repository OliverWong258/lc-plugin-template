/*
 * @lc app=leetcode.cn id=3 lang=java
 * @lcpr version=30201
 *
 * [3] 无重复字符的最长子串
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class LongestSubstringWithoutRepeatingCharacters {

    // @lc code=start
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int left = 0;
            int right = 0;
            Set<Character> window = new HashSet<>();
            int result = 0;

            for (; right < s.length(); right++) {
                char c = s.charAt(right);
                if (!window.contains(c)) {
                    window.add(c);
                    result = Math.max(result, right - left + 1);
                }
                else {
                    while (left < right) {
                        char removed = s.charAt(left);
                        if (removed == c) {
                            left++;
                            break;
                        }
                        else {
                            window.remove(removed);
                            left++;
                        }
                    }
                }
            }

            return result;
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
    Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
    // Example usage:
    // System.out.println(solution.lengthOfLongestSubstring("abcabcbb")); // Output: 3
    // System.out.println(solution.lengthOfLongestSubstring("bbbbb"));    // Output: 1
    // System.out.println(solution.lengthOfLongestSubstring("pwwkew"));   // Output: 3
    // Add your test code here
    }
}



/*
// @lcpr case=start
// "abcabcbb"\n
// @lcpr case=end

// @lcpr case=start
// "bbbbb"\n
// @lcpr case=end

// @lcpr case=start
// "pwwkew"\n
// @lcpr case=end

 */

