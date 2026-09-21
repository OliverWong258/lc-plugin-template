/*
 * @lc app=leetcode.cn id=322 lang=java
 * @lcpr version=30201
 *
 * [322] 零钱兑换
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class CoinChange {

    // @lc code=start
    class Solution {
        public int coinChange(int[] coins, int amount) {
            if (amount == 0) {
                return 0;
            }

            int[] dp = new int[amount + 1];
            dp[0] = 0;

            for (int i = 1; i <= amount; ++i) {
                dp[i] = amount + 1;
            }

            // Arrays.sort(coins);

            for (int i = 0; i < coins.length; ++i) {
                for (int j = coins[i]; j <= amount; ++j) {
                    if (coins[i] <= j && dp[j - coins[i]] != j - coins[i] + 1) {
                        dp[j] = Math.min(dp[j], 1 + dp[j - coins[i]]);
                    }
                }
            }

            return dp[amount] == amount + 1 ? -1 : dp[amount];
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();
        // put your test code here
        
    }
}



/*
// @lcpr case=start
// [1, 2, 5]\n11\n
// @lcpr case=end

// @lcpr case=start
// [2]\n3\n
// @lcpr case=end

// @lcpr case=start
// [1]\n0\n
// @lcpr case=end

 */

