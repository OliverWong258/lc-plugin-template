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
            Deque<int[]> mergedIntervals = new ArrayDeque<>();

            for (int i = 0; i < intervals.length; ++i) {
                if (mergedIntervals.isEmpty() || mergedIntervals.peekLast()[1] < intervals[i][0]) {
                    mergedIntervals.addLast(intervals[i]);
                }
                else {
                    int[] prevInterval = mergedIntervals.pollLast();
                    mergedIntervals.addLast(new int[]{prevInterval[0], Math.max(prevInterval[1], intervals[i][1])});
                }
            }

            int[][] result = new int[mergedIntervals.size()][2];

            for (int i = 0; i < result.length; ++i) {
                result[i] = mergedIntervals.pollFirst();
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

