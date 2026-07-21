/*
 * @lc app=leetcode.cn id=1905 lang=java
 * @lcpr version=30404
 *
 * [1905] 统计子岛屿
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class CountSubIslands {

    // @lc code=start
    class Solution {
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        public int countSubIslands(int[][] grid1, int[][] grid2) {
            int m = grid2.length;
            int n = grid2[0].length;
            boolean[][] visited = new boolean[m][n];
            int result = 0;
            
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (!visited[i][j] && grid2[i][j] == 1) {
                        if (traverse(grid1, grid2, visited, i, j)) {
                            result++;
                        }
                    }       
                }
            }

            return result;
        }

        boolean traverse(int[][] grid1, int[][] grid2, boolean[][] visited, int row, int col) {
            int m = grid2.length;
            int n = grid2[0].length;
            visited[row][col] = true;
            boolean isSubIslnd = true;
            
            if (grid1[row][col] == 0) {
                isSubIslnd =  false;
            }

            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !visited[newRow][newCol] && grid2[newRow][newCol] == 1) {
                    if (!traverse(grid1, grid2, visited, newRow, newCol)) {
                        isSubIslnd = false;
                    }
                }
            }

            return isSubIslnd;
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new CountSubIslands().new Solution();
        // put your test code here
        
    }
}



/*
// @lcpr case=start
// [[1,1,1,0,0],[0,1,1,1,1],[0,0,0,0,0],[1,0,0,0,0],[1,1,0,1,1]]\n[[1,1,1,0,0],[0,0,1,1,1],[0,1,0,0,0],[1,0,1,1,0],[0,1,0,1,0]]\n
// @lcpr case=end

// @lcpr case=start
// [[1,0,1,0,1],[1,1,1,1,1],[0,0,0,0,0],[1,1,1,1,1],[1,0,1,0,1]]\n[[0,0,0,0,0],[1,1,1,1,1],[0,1,0,1,0],[0,1,0,1,0],[1,0,0,0,1]]\n
// @lcpr case=end

 */

