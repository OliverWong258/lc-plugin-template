/*
 * @lc app=leetcode.cn id=1091 lang=java
 * @lcpr version=30202
 *
 * [1091] 二进制矩阵中的最短路径
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class ShortestPathInBinaryMatrix {

    // @lc code=start
    class Solution {
        public int shortestPathBinaryMatrix(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
            Deque<int[]> path = new ArrayDeque<>();
            int step = 0;
            boolean[][] visited = new boolean[m][n];

            if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
                return -1;
            }

            path.addLast(new int[]{0, 0});
            visited[0][0] = true;

            while (!path.isEmpty()) {
                int sz = path.size();
                step++;
                for (int i = 0; i < sz; ++i) {
                    int[] curPos = path.pollFirst();
                    if (curPos[0] == m - 1 && curPos[1] == n - 1) {
                        return step;
                    }
                    for (int[] direction : directions) {
                        int newRow = curPos[0] + direction[0];
                        int newCol = curPos[1] + direction[1];
                        if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !visited[newRow][newCol] && grid[newRow][newCol] == 0) {
                            path.add(new int[]{newRow, newCol});
                            visited[newRow][newCol] = true;
                        }
                    }
                }
            }

            return -1;
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new ShortestPathInBinaryMatrix().new Solution();
        // put your test code here
        
    }
}



/*
// @lcpr case=start
// [[0,1],[1,0]]\n
// @lcpr case=end

// @lcpr case=start
// [[0,0,0],[1,1,0],[1,1,0]]\n
// @lcpr case=end

// @lcpr case=start
// [[1,0,0],[1,1,0],[1,1,0]]\n
// @lcpr case=end

 */

