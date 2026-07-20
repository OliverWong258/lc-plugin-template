/*
 * @lc app=leetcode.cn id=1254 lang=java
 * @lcpr version=30404
 *
 * [1254] 统计封闭岛屿的数目
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class NumberOfClosedIslands {

    // @lc code=start
    class Solution {
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        public int closedIsland(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            boolean[][] visited = new boolean[m][n];
            int result = 0;

            for (int i = 0; i < m; ++i) {
                if (!visited[i][0] && grid[i][0] == 0) {
                    dfsMarkOne(grid, i, 0, visited);
                }
                if (!visited[i][n - 1] && grid[i][n - 1] == 0) {
                    dfsMarkOne(grid, i, n - 1, visited);
                }
            }

            for (int j = 0; j < n; ++j) {
                if (!visited[0][j] && grid[0][j] == 0) {
                    dfsMarkOne(grid, 0, j, visited);
                }
                if (!visited[m - 1][j] && grid[m - 1][j] == 0) {
                    dfsMarkOne(grid, m - 1, j, visited);
                }
            }

            for (int i = 1; i < m - 1; ++i) {
                for (int j = 1; j < n - 1; ++j) {
                    if (!visited[i][j] && grid[i][j] == 0) {
                        result++;
                        dfsMarkOne(grid, i, j, visited);
                    }
                }
            } 

            return result;
        }

        void dfsMarkOne(int[][] grid, int row, int col, boolean[][] visited) {
            int m = grid.length;
            int n = grid[0].length;
            visited[row][col] = true;
            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !visited[newRow][newCol] && grid[newRow][newCol] == 0) {
                    dfsMarkOne(grid, newRow, newCol, visited);
                }
            }
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new NumberOfClosedIslands().new Solution();
        // put your test code here
        
    }
}



/*
// @lcpr case=start
// [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]\n
// @lcpr case=end

// @lcpr case=start
// [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]\n
// @lcpr case=end

// @lcpr case=start
// [[1,1,1,1,1,1,1],[1,0,0,0,0,0,1],[1,0,1,1,1,0,1],[1,0,1,0,1,0,1],[1,0,1,1,1,0,1],[1,0,0,0,0,0,1],[1,1,1,1,1,1,1]]\n
// @lcpr case=end

 */

