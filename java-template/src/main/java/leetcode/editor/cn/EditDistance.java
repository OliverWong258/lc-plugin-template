/*
 * @lc app=leetcode.cn id=72 lang=java
 * @lcpr version=30404
 *
 * [72] 编辑距离
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class EditDistance {

    // @lc code=start
    class Solution {
        public int minDistance(String word1, String word2) {
            int len1 = word1.length();
            int len2 = word2.length();
            int[][] dp = new int[len1 + 1][len2 + 1];
            
            for (int i = 0; i <= len1; ++i) {
                dp[i][0] = i;
            }

            for (int j = 0; j <= len2; ++j) {
                dp[0][j] = j;
            }

            for (int index1 = 1; index1 <= len1; ++index1) {
                for (int index2 = 1; index2 <= len2; ++index2) {
                    if (word1.charAt(index1 - 1) == word2.charAt(index2 - 1)) {
                        dp[index1][index2] = dp[index1 - 1][index2 - 1];
                    }
                    else {
                        dp[index1][index2] = 1 + Math.min(dp[index1 - 1][index2 - 1], Math.min(dp[index1 - 1][index2], dp[index1][index2 - 1]));
                    }
                }
            }
            
            return dp[len1][len2];
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new EditDistance().new Solution();
        // put your test code here
        
    }
}



/*
// @lcpr case=start
// "horse"\n"ros"\n
// @lcpr case=end

// @lcpr case=start
// "intention"\n"execution"\n
// @lcpr case=end

 */

