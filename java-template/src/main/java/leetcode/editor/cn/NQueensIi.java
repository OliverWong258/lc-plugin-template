/*
 * @lc app=leetcode.cn id=52 lang=java
 * @lcpr version=30404
 *
 * [52] N 皇后 II
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class NQueensIi {

    // @lc code=start
    class Solution {
        int result;

        public int totalNQueens(int n) {
            result = 0;
            int[][] chessBoard = new int[n][n];
            traverse(0, chessBoard);
            return result;
        }

        void traverse(int row, int[][] chessBoard) {
            int n = chessBoard.length;

            if (row == n) {
                result++;
                return;
            }
            else {
                for (int col = 0; col < n; ++col) {
                    boolean check = true;
                    for (int i = 0; i < row; ++i) {
                        for (int j = 0; j < n; ++j) {
                            if (chessBoard[i][j] == 1) {
                                if (col == j || (Math.abs(i - row) == Math.abs(j - col))) {
                                    check = false;
                                    break;
                                }
                            }
                        }
                    }
                    if (check) {
                        chessBoard[row][col] = 1;
                        traverse(row + 1, chessBoard);
                        chessBoard[row][col] = 0;
                    }
                }
            }
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new NQueensIi().new Solution();
        // put your test code here
        
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

