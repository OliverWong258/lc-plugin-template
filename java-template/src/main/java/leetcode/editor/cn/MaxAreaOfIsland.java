/*
 * @lc app=leetcode.cn id=695 lang=java
 * @lcpr version=30404
 *
 * [695] 岛屿的最大面积
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class MaxAreaOfIsland {

    // @lc code=start
    class Solution {
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        public int maxAreaOfIsland(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            boolean[][] visited = new boolean[m][n];
            int result = 0;

            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (!visited[i][j] && grid[i][j] == 1) {
                        result = Math.max(result, islandArea(grid, visited, i, j));
                    }
                }
            }

            return result;
        }

        int islandArea(int[][] grid, boolean[][] visited, int row, int col) {
            int m = grid.length;
            int n = grid[0].length;
            visited[row][col] = true;
            int result = 1;

            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !visited[newRow][newCol] && grid[newRow][newCol] == 1)
                result += islandArea(grid, visited, newRow, newCol);
            }

            return result;
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new MaxAreaOfIsland().new Solution();
        // put your test code here
        
    }
}



/*
// @lcpr case=start
// [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]\n
// @lcpr case=end

// @lcpr case=start
// [[0,0,0,0,0,0,0,0]]\n
// @lcpr case=end

 */

