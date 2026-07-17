/*
 * @lc app=leetcode.cn id=216 lang=java
 * @lcpr version=30201
 *
 * [216] 组合总和 III
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class CombinationSumIii {

    // @lc code=start
    class Solution {
        
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> curPath = new ArrayList<>();
            traverse(k, n, 1, curPath, result);
            return result;    
        }

        public void traverse(int k, int sumLeft, int start, List<Integer> curPath, List<List<Integer>> result) {
            if (k == curPath.size() && sumLeft == 0) {
                result.add(new ArrayList<>(curPath));
                return;
            }
            else if (k > curPath.size() && sumLeft > 0) {
                for (int i = start;i < 10;++i) {
                    curPath.add(i);
                    traverse(k, sumLeft - i, i + 1, curPath, result);
                    curPath.remove(curPath.size() - 1);
                }
                return;
            }
            else {
                return;
            }
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new CombinationSumIii().new Solution();
        // put your test code here
        
    }
}



/*
// @lcpr case=start
// 3\n7\n
// @lcpr case=end

// @lcpr case=start
// 3\n9\n
// @lcpr case=end

// @lcpr case=start
// 4\n1\n
// @lcpr case=end

 */

