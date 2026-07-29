/*
 * @lc app=leetcode.cn id=994 lang=java
 * @lcpr version=30202
 *
 * [994] 腐烂的橘子
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class RottingOranges {

    // @lc code=start
    class Solution {
        public int orangesRotting(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int target = 0;
            Deque<int[]> path = new ArrayDeque<>();
            boolean[][] visited = new boolean[m][n];
            int step = 0;
            int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            int rotted = 0;

            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] != 0) {
                        target++;
                    }
                    if (grid[i][j] == 2) {
                        path.addLast(new int[]{i, j});
                        visited[i][j] = true;
                    }
                }
            }

            if (target == 0) {
                return 0;
            }

            while (!path.isEmpty()) {
                int sz = path.size();
                step++;
                for (int i = 0; i < sz; ++i) {
                    int[] curPos = path.pollFirst();
                    rotted++;
                    for (int[] direction : directions) {
                        int newRow = curPos[0] + direction[0];
                        int newCol = curPos[1] + direction[1];
                        if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !visited[newRow][newCol] && grid[newRow][newCol] == 1) {
                            path.addLast(new int[]{newRow, newCol});
                            visited[newRow][newCol] = true;
                        }
                    } 
                }
            }

            return rotted == target ? step - 1 : -1;
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new RottingOranges().new Solution();
        // put your test code here
        
    }
}



/*
// @lcpr case=start
// [[2,1,1],[1,1,0],[0,1,1]]\n
// @lcpr case=end

// @lcpr case=start
// [[2,1,1],[0,1,1],[1,0,1]]\n
// @lcpr case=end

// @lcpr case=start
// [[0,2]]\n
// @lcpr case=end

 */

