/*
 * @lc app=leetcode.cn id=90 lang=java
 * @lcpr version=30201
 *
 * [90] 子集 II
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class SubsetsIi {

    // @lc code=start
    class Solution {
        public List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            int[] numPool = new int[21];
            for (int i = 0;i < nums.length;++i) {
                numPool[nums[i] + 10]++;
            }    
            List<Integer> track = new ArrayList<>();
            traverse(0, track, numPool);
            return result;
        }

        public void traverse(int start, List<Integer> track, int[] numPool) {
            result.add(new ArrayList<>(track));
            for (int i = start;i < 21;++i) {
                if (numPool[i] > 0) {
                    numPool[i]--;
                    track.add(i - 10);
                    traverse(i, track, numPool);
                    track.removeLast();
                    numPool[i]++;
                }
            }
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new SubsetsIi().new Solution();
        // put your test code here
        
    }
}



/*
// @lcpr case=start
// [1,2,2]\n
// @lcpr case=end

// @lcpr case=start
// [0]\n
// @lcpr case=end

 */

