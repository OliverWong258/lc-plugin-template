/*
 * @lc app=leetcode.cn id=354 lang=java
 * @lcpr version=30404
 *
 * [354] 俄罗斯套娃信封问题
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class RussianDollEnvelopes {

    // @lc code=start
    class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            Arrays.sort(envelopes, (a, b) -> (a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));
            int n = envelopes.length;
            int[] tails = new int[n];
            int size = 0;

            for (int i = 0; i < n; ++i) {
                if (size == 0) {
                    tails[size] = envelopes[i][1];
                    size++;
                }
                else if (tails[size - 1] < envelopes[i][1]) {
                    tails[size] = envelopes[i][1];
                    size++;
                }
                else {
                    int left = 0;
                    int right = size - 1;
                    while (left <= right) {
                        int mid = left + (right - left) / 2;
                        if (tails[mid] < envelopes[i][1]) {
                            left = mid + 1;
                        }
                        else {
                            right = mid - 1;
                        }
                    }
                    tails[left] = envelopes[i][1];
                }
            }

            return size;
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new RussianDollEnvelopes().new Solution();
        // put your test code here
        
    }
}



/*
// @lcpr case=start
// [[5,4],[6,4],[6,7],[2,3]]\n
// @lcpr case=end

// @lcpr case=start
// [[1,1],[1,1],[1,1]]\n
// @lcpr case=end

 */

