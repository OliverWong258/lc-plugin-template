/*
 * @lc app=leetcode.cn id=785 lang=java
 * @lcpr version=30202
 *
 * [785] 判断二分图
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class IsGraphBipartite {

    // @lc code=start
    class Solution {

        public boolean isBipartite(int[][] graph) {
            int num = graph.length;
            int[] colors = new int[num];
            boolean[] visited = new boolean[num];
            
            for (int i = 0; i < num; ++i) {
                if (!visited[i]) {
                    visited[i] = true;
                    colors[i] = 1;
                    if (!traverse(i, graph, visited, colors)) {
                        return false;
                    }
                }
            }

            return true;
        }

        boolean traverse(int curNode, int[][] graph, boolean[] visited, int[] colors) {
            for (int nextNode : graph[curNode]) {
                if (visited[nextNode]) {
                    if (colors[nextNode] == colors[curNode]) {
                        return false;
                    }
                }
                else {
                    visited[nextNode] = true;
                    colors[nextNode] = -colors[curNode];
                    if (!traverse(nextNode, graph, visited, colors)) {
                        return false;
                    }
                }
            }
            return true;
        }        
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new IsGraphBipartite().new Solution();
        // put your test code here
        
    }
}



/*
// @lcpr case=start
// [[1,2,3],[0,2],[0,1,3],[0,2]]\n
// @lcpr case=end

// @lcpr case=start
// [[1,3],[0,2],[1,3],[0,2]]\n
// @lcpr case=end

 */

