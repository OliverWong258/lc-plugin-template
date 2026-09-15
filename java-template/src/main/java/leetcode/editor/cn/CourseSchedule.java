/*
 * @lc app=leetcode.cn id=207 lang=java
 * @lcpr version=30202
 *
 * [207] 课程表
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class CourseSchedule {

    // @lc code=start
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            int[] inDegrees = new int[numCourses];
            Map<Integer, List<Integer>> toDegrees = new HashMap<>();
            Deque<Integer> dq = new ArrayDeque<>();
            int result = 0;

            for (int[] courses : prerequisites) {
                int from = courses[1];
                int to = courses[0];
                inDegrees[to]++;
                if (!toDegrees.containsKey(from)) {
                    toDegrees.put(from, new ArrayList<>());
                }
                toDegrees.get(from).add(to);
            }

            for (int i = 0; i < numCourses; ++i) {
                if (inDegrees[i] == 0) {
                    dq.addLast(i);
                }
            }

            while (!dq.isEmpty()) {
                int curCourse = dq.pollFirst();
                result++;
                if (toDegrees.containsKey(curCourse)) {
                    for (int nextCourse : toDegrees.get(curCourse)) {
                        inDegrees[nextCourse]--;
                        if (inDegrees[nextCourse] == 0) {
                            dq.addLast(nextCourse);
                        }
                    }
                }
            }

            return result == numCourses;
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new CourseSchedule().new Solution();
        // put your test code here
        
    }
}



/*
// @lcpr case=start
// 2\n[[1,0]]\n
// @lcpr case=end

// @lcpr case=start
// 2\n[[1,0],[0,1]]\n
// @lcpr case=end

 */

