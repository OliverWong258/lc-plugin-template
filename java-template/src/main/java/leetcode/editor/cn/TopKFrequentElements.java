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
            int[] result = new int[k];
            List<Integer>[] buckets = new List[nums.length + 1];
            int idx = 0;

            for (int num : nums) {
                num2freq.put(num, num2freq.getOrDefault(num, 0) + 1);
            }

            for (int num : num2freq.keySet()) {
                int count = num2freq.get(num);
                if (buckets[count] == null) {
                    buckets[count] = new ArrayList<>();
                }
                buckets[count].add(num);
            }

            for (int i = nums.length; i >= 0 && idx < k; --i) {
                if (buckets[i] != null) {
                    for (int num : buckets[i]) {
                        result[idx] = num;
                        idx++;
                        if (idx == k) {
                            break;
                        }
                    }
                }
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

