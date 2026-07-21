/*
 * @lc app=leetcode.cn id=967 lang=java
 * @lcpr version=30404
 *
 * [967] 连续差相同的数字
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class NumbersWithSameConsecutiveDifferences {

    // @lc code=start
    class Solution {
        List<Integer> result = new ArrayList<>();

        public int[] numsSameConsecDiff(int n, int k) {
            for (int i = 1; i <= 9; ++i) {
                StringBuilder sb = new StringBuilder();
                sb.append(String.valueOf(i));
                traverse(sb, i, n, k);
            }
            int[] resultArray = new int[result.size()];
            for (int i = 0; i < result.size(); ++i) {
                resultArray[i] = result.get(i);
            }

            return resultArray;
        }

        void traverse(StringBuilder curStr, int preNum, int n, int k) {
            if (curStr.length() == n) {
                result.add(Integer.valueOf(curStr.toString()));
                return;
            }

            if (preNum + k <= 9) {
                curStr.append(String.valueOf(preNum + k));
                traverse(curStr, preNum + k, n, k);
                curStr.delete(curStr.length() - 1, curStr.length());
            }
            if (preNum - k >= 0 && k != 0) {
                curStr.append(String.valueOf(preNum - k));
                traverse(curStr, preNum - k, n, k);
                curStr.delete(curStr.length() - 1, curStr.length());
            }
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new NumbersWithSameConsecutiveDifferences().new Solution();
        // put your test code here
        
    }
}



/*
// @lcpr case=start
// 3\n7\n
// @lcpr case=end

// @lcpr case=start
// 2\n1\n
// @lcpr case=end

 */

