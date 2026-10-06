/*
 * @lc app=leetcode.cn id=215 lang=java
 * @lcpr version=30304
 *
 * [215] 数组中的第K个最大元素
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class KthLargestElementInAnArray {

    // @lc code=start
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            return partition(0, nums.length - 1, nums, k);
        }

        int partition(int left, int right, int[] nums, int k) {
            int target = nums[right];
            int p = left;

            for (int i = left; i < right; ++i) {
                if (nums[i] > target) {
                    int tmp = nums[i];
                    nums[i] = nums[p];
                    nums[p] = tmp;
                    p++;
                }
            }

            nums[right] = nums[p];
            nums[p] = target;

            if (p + 1 == k) {
                return target;
            }
            else if (p + 1 < k) {
                return partition(p + 1, right, nums, k);
            }
            else {
                return partition(left, p - 1, nums, k);
            }
            
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
        // put your test code here
        solution.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4);
    }
}



/*
// @lcpr case=start
// [3,2,1,5,6,4]\n2\n
// @lcpr case=end

// @lcpr case=start
// [3,2,3,1,2,4,5,5,6]\n4\n
// @lcpr case=end

 */

