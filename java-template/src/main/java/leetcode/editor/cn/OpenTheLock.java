/*
 * @lc app=leetcode.cn id=752 lang=java
 * @lcpr version=30201
 *
 * [752] 打开转盘锁
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class OpenTheLock {

    // @lc code=start
    class Solution {
        public String initStr = "0000";

        public int openLock(String[] deadends, String target) {
            List<String> queue = new ArrayList<>();
            HashSet<String> visited = new HashSet<>();

            for (String element : deadends) {
                visited.add(element);
            }
            if (visited.contains(initStr)) return -1;
            queue.add(initStr);
            visited.add(initStr);
            int steps = 0;

            while(!queue.isEmpty()) {
                int sz = queue.size();
                for (int i = 0;i < sz;++i){
                    String headStr = queue.getFirst();
                    queue.removeFirst();
                    if (headStr.equals(target)) return steps;
                    List<String> nexts = nextStrs(headStr);
                    for (String next : nexts) {
                        if (visited.contains(next)) continue;
                        queue.add(next);
                        visited.add(next);
                    }
                } 
                steps++;
            }
            return -1;
        }

        public List<String> nextStrs(String currStr) {
            List<String> result = new ArrayList<>();
            for (int i = 0;i < 4;++i) {
                result.add(minusOne(currStr, i));
                result.add(plusOne(currStr, i));
            }
            return result;
        }

        public String minusOne(String currStr, int i) {
            char[] chars = currStr.toCharArray();
            if (chars[i] == '0') chars[i] = '9';
            else chars[i] -= 1;
            return new String(chars);
        }

        public String plusOne(String currStr, int i) {
            char[] chars = currStr.toCharArray();
            if (chars[i] == '9') chars[i] = '0';
            else chars[i] += 1;
            return new String(chars);
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new OpenTheLock().new Solution();
        // put your test code here
        String target = "0009";
        String[] demands = new String[] {"8888"};
        System.out.println(solution.openLock(demands, target));       
    }
}



/*
// @lcpr case=start
// ["0201","0101","0102","1212","2002"]\n"0202"\n
// @lcpr case=end

// @lcpr case=start
// ["8888"]\n"0009"\n
// @lcpr case=end

// @lcpr case=start
// ["8887","8889","8878","8898","8788","8988","7888","9888"]\n"8888"\n
// @lcpr case=end

 */

