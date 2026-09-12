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
            if (left == right) {
                return nums[left];
            }

            int index = (int)(Math.random() * (right - left) + left);
            
            // switch nums[index] and nums[left]
            int tmp = nums[left];
            nums[left] = nums[index];
            nums[index] = tmp;

            int l = left;
            int r = right;
            int i = left + 1;
            int pivot = nums[left];

            // partion in decreaseing order
            while (i <= r) {
                if (nums[i] > pivot) {
                    tmp = nums[i];
                    nums[i] = nums[l];
                    nums[l] = tmp;
                    i++;
                    l++;
                }
                else if (nums[i] == pivot) {
                    i++;
                }
                else {
                    tmp = nums[r];
                    nums[r] = nums[i];
                    nums[i] = tmp;
                    // i++;
                    r--;
                }
            }

            if (k - 1 < l) {
                return partition(left, l - 1, nums, k);
            }
            else if (k - 1 > r) {
                return partition(r + 1, right, nums, k);
            }
            else {
                return nums[k - 1];
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

