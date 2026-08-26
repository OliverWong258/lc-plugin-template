/*
 * @lc app=leetcode.cn id=213 lang=java
 * @lcpr version=30404
 *
 * [213] 打家劫舍 II
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class HouseRobberIi {

    // @lc code=start
    class Solution {
        public int rob(int[] nums) {
            int n = nums.length;
            if (n < 3) {
                if (n == 1) {
                    return nums[0];
                }
                else {
                    return Math.max(nums[0], nums[1]);
                }
            }
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = nums[0];
            int result = 0;

            // choose first
            for (int i = 2; i < n; ++i) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
            }

            result = dp[n - 1];

            // choose last
            dp[1] = 0;
            dp[2] = nums[1];
            for (int i = 3; i <= n; ++i) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
            }

            return Math.max(result, dp[n]); 
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new HouseRobberIi().new Solution();
        // put your test code here
        
    }
}



/*
// @lcpr case=start
// [2,3,2]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3,1]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3]\n
// @lcpr case=end

 */

