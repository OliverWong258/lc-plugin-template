/*
 * @lc app=leetcode.cn id=221 lang=java
 * @lcpr version=30307
 *
 * [221] 最大正方形
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class MaximalSquare {

    // @lc code=start
    class Solution {
        public int maximalSquare(char[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            int[][] dp = new int[m][n];
            int result = 0;

            for (int j = 0; j < n; ++j) {
                dp[0][j] = matrix[0][j] == '1' ? 1 : 0;
                result = Math.max(result, dp[0][j]);
            }

            for (int i = 0; i < m; ++i) {
                dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
                result = Math.max(result, dp[i][0]);
            }

            for (int i = 1; i < m; ++i) {
                for (int j = 1; j < n; ++j) {
                    if (matrix[i][j] == '0') {
                        dp[i][j] = 0;
                    }
                    else {
                        dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                        result = Math.max(result, dp[i][j]);
                    }
                }
            }

            return result * result;
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new MaximalSquare().new Solution();
        // put your test code here
        
    }
}



/*
// @lcpr case=start
// [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]\n
// @lcpr case=end

// @lcpr case=start
// [["0","1"],["1","0"]]\n
// @lcpr case=end

// @lcpr case=start
// [["0"]]\n
// @lcpr case=end

 */

