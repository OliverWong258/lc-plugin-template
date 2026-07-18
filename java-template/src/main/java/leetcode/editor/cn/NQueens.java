/*
 * @lc app=leetcode.cn id=51 lang=java
 * @lcpr version=30203
 *
 * [51] N 皇后
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class NQueens {

    // @lc code=start
    class Solution {
        List<List<String>> results = new LinkedList<>();

        public List<List<String>> solveNQueens(int n) {
            int[][] chessboard = new int[n][n];
            traverse(0, chessboard, n);
            return results;
        }

        void traverse(int row, int[][] chessboard, int n) {
            if (row == n) {
                List<String> result = new LinkedList<>();
                for (int i = 0; i < n; ++i) {
                    StringBuilder rowSB = new StringBuilder();
                    for (int j = 0; j < n; ++j) {
                        if (chessboard[i][j] == 0) {
                            rowSB.append(".");
                        }
                        else {
                            rowSB.append("Q");
                        }
                    }
                    result.add(rowSB.toString());
                }
                results.add(result);
                return;
            }

            for (int col = 0; col < n; col++) {
                boolean conflict = false;
                for (int i = 0; i < row; ++i) {
                    for (int j = 0; j < n; ++j) {
                        if (chessboard[i][j] == 1) {
                            if (j == col || Math.abs(i - row) == Math.abs(j - col)) {
                                conflict = true;
                            }
                        }
                    }
                }
                if(!conflict) {
                    chessboard[row][col] = 1;
                    traverse(row + 1, chessboard, n);
                    chessboard[row][col] = 0;
                }
            }
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new NQueens().new Solution();
        // put your test code here
        solution.solveNQueens(4);
    }
}



/*
// @lcpr case=start
// 4\n
// @lcpr case=end

// @lcpr case=start
// 1\n
// @lcpr case=end

 */

