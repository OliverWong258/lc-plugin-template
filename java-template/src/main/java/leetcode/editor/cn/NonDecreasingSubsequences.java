/*
 * @lc app=leetcode.cn id=491 lang=java
 * @lcpr version=30404
 *
 * [491] 非递减子序列
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class NonDecreasingSubsequences {

    // @lc code=start
    class Solution {
        List<List<Integer>> results = new ArrayList<>();

        public List<List<Integer>> findSubsequences(int[] nums) {
            traverse(new ArrayList<>(), 0, nums);
            return results;
        }

        void traverse(List<Integer> curPath, int curIndex, int[] nums) {
            if (curPath.size() >= 2) {
                results.add(new ArrayList<>(curPath));
            }

            Set<Integer> visited = new HashSet<>();

            for (int i = curIndex; i < nums.length; ++i) {
                if ((curPath.size() == 0 || curPath.get(curPath.size() - 1) <= nums[i]) && !visited.contains(nums[i])) {
                    curPath.add(nums[i]);
                    visited.add(nums[i]);
                    traverse(curPath, i + 1, nums);
                    curPath.remove(curPath.size() - 1);
                }
            }
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new NonDecreasingSubsequences().new Solution();
        // put your test code here
        
    }
}



/*
// @lcpr case=start
// [4,6,7,7]\n
// @lcpr case=end

// @lcpr case=start
// [4,4,3,2,1]\n
// @lcpr case=end

 */

