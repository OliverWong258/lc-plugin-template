/*
 * @lc app=leetcode.cn id=1926 lang=java
 * @lcpr version=30202
 *
 * [1926] 迷宫中离入口最近的出口
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class NearestExitFromEntranceInMaze {

    // @lc code=start
    class Solution {
        public int nearestExit(char[][] maze, int[] entrance) {
            Deque<int[]> path = new ArrayDeque<>();
            int step = 0;
            Set<Integer> visited = new HashSet<>();
            int m = maze.length;
            int n = maze[0].length;
            int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

            path.add(entrance);
            visited.add(n * entrance[0] + entrance[1]);

            while (!path.isEmpty()) {
                int sz = path.size();
                step++;

                for (int i = 0; i < sz; ++i) {
                    int[] curPos = path.pollFirst();
                    for (int[] direction : directions) {
                        int newRow = curPos[0] + direction[0];
                        int newCol = curPos[1] + direction[1];
                        if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !visited.contains(newRow * n + newCol) && maze[newRow][newCol] == '.') {
                            if (newRow == 0 || newRow == m - 1 || newCol == 0 || newCol == n - 1) {
                                return step;
                            }
                            else {
                                path.add(new int[]{newRow, newCol});
                                visited.add(newRow * n + newCol);
                            }
                        }
                    }
                }
            }

            return -1;
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new NearestExitFromEntranceInMaze().new Solution();
        // put your test code here
        
    }
}



/*
// @lcpr case=start
// [["+","+",".","+"],[".",".",".","+"],["+","+","+","."]]\n[1,2]\n
// @lcpr case=end

// @lcpr case=start
// [["+","+","+"],[".",".","."],["+","+","+"]]\n[1,0]\n
// @lcpr case=end

// @lcpr case=start
// [[".","+"]]\n[0,0]\n
// @lcpr case=end

 */

