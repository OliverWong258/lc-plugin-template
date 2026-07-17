/*
 * @lc app=leetcode.cn id=47 lang=java
 * @lcpr version=30201
 *
 * [47] 全排列 II
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class PermutationsIi {

    // @lc code=start
    class Solution {
        
        public List<List<Integer>> permuteUnique(int[] nums) {
            int[] numPool = new int[21];
            
            for (int num : nums) {
                numPool[num + 10]++;
            }

            List<Integer> curPath = new ArrayList<>();
            List<List<Integer>> result = new ArrayList<>();

            traverse(nums.length, numPool, curPath, result);

            return result;
        }

        void traverse(int len, int[] numPool, List<Integer> curPath, List<List<Integer>> result) {
            if (curPath.size() == len) {
                result.add(new ArrayList<>(curPath));
                return;
            }

            for (int i = 0; i < numPool.length; ++i) {
                if (numPool[i] > 0) {
                    curPath.add(i - 10);
                    numPool[i]--;
                    traverse(len, numPool, curPath, result);
                    numPool[i]++;
                    curPath.remove(curPath.size() - 1);
                }
            }
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
        // put your test code here
        
    }
}



/*
// @lcpr case=start
// [1,1,2]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3]\n
// @lcpr case=end

 */

