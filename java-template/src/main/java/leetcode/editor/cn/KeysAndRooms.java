/*
 * @lc app=leetcode.cn id=841 lang=java
 * @lcpr version=30202
 *
 * [841] 钥匙和房间
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class KeysAndRooms {

    // @lc code=start
    class Solution {
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            Queue<Integer> roomQ = new LinkedList<>();
            int count = 0;
            int n = rooms.size();
            boolean[] visited = new boolean[n];
            roomQ.offer(0);
            visited[0] = true;

            while (!roomQ.isEmpty()) {
                int curRoom = roomQ.poll();
                count++;

                for (int nextRoom : rooms.get(curRoom)) {
                    if (!visited[nextRoom]) {
                        visited[nextRoom] = true;
                        roomQ.offer(nextRoom);
                    }
                }
            }

            if (count < n) {
                return false;
            }
            else {
                return true;
            }
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new KeysAndRooms().new Solution();
        // put your test code here
        
    }
}



/*
// @lcpr case=start
// [[1],[2],[3],[]]\n
// @lcpr case=end

// @lcpr case=start
// [[1,3],[3,0,1],[2],[0]]\n
// @lcpr case=end

 */

