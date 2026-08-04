/*
 * @lc app=leetcode.cn id=300 lang=java
 * @lcpr version=30307
 *
 * [300] 最长递增子序列
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class LongestIncreasingSubsequence {

    // @lc code=start
    class Solution {
        public int lengthOfLIS(int[] nums) {
            List<Integer> tails = new ArrayList<>();
            
            for (int num : nums) {
                if (tails.size() == 0 || num > tails.get(tails.size() - 1)) {
                    tails.add(num);
                }
                else {
                    int left = 0;
                    int right = tails.size() - 1;
                    while (left <= right) {
                        int mid = left + (right - left) / 2;
                        if (tails.get(mid) >= num) {
                            right = mid - 1;
                        }
                        else {
                            left = mid + 1;
                        }
                    }
                    tails.set(left, num);
                }
            }

            return tails.size();
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingSubsequence().new Solution();
        // put your test code here
        
    }
}



/*
// @lcpr case=start
// [10,9,2,5,3,7,101,18]\n
// @lcpr case=end

// @lcpr case=start
// [0,1,0,3,2,3]\n
// @lcpr case=end

// @lcpr case=start
// [7,7,7,7,7,7,7]\n
// @lcpr case=end

 */

