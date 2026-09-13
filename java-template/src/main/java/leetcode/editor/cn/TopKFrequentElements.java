/*
 * @lc app=leetcode.cn id=347 lang=java
 * @lcpr version=30404
 *
 * [347] 前 K 个高频元素
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class TopKFrequentElements {

    // @lc code=start
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> num2freq = new HashMap<>();
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
            int[] result = new int[k];

            for (int num : nums) {
                num2freq.put(num, num2freq.getOrDefault(num, 0) + 1);
            }

            for (int num : num2freq.keySet()) {
                pq.add(new int[]{num, num2freq.get(num)});
            }

            for (int i = 0; i < k; ++i) {
                result[i] = pq.poll()[0];
            }

            return result;
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new TopKFrequentElements().new Solution();
        // put your test code here
        
    }
}



/*
// @lcpr case=start
// [1,1,1,2,2,3]\n2\n
// @lcpr case=end

// @lcpr case=start
// [1]\n1\n
// @lcpr case=end

// @lcpr case=start
// [1,2,1,2,1,2,3,1,3,2]\n2\n
// @lcpr case=end

 */

