/*
 * @lc app=leetcode.cn id=56 lang=java
 * @lcpr version=30203
 *
 * [56] 合并区间
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class MergeIntervals {

    // @lc code=start
    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
            Deque<int[]> dq = new ArrayDeque<>();

            for (int i = 0; i < intervals.length; ++i) {
                if (dq.isEmpty() || dq.peekLast()[1] < intervals[i][0]) {
                    dq.addLast(intervals[i]);
                }
                else {
                    dq.peekLast()[1] = Math.max(dq.peekLast()[1], intervals[i][1]);
                }
            }

            int[][] result = new int[dq.size()][2];

            for (int i = 0; i < result.length; ++i) {
                result[i] = dq.pollFirst();
            }

            return result;
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
        // put your test code here
        
    }
}



/*
// @lcpr case=start
// [[1,3],[2,6],[8,10],[15,18]]\n
// @lcpr case=end

// @lcpr case=start
// [[1,4],[4,5]]\n
// @lcpr case=end

// @lcpr case=start
// [[4,7],[1,4]]\n
// @lcpr case=end

 */

