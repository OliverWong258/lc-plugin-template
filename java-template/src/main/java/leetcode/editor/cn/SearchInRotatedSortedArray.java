/*
 * @lc app=leetcode.cn id=33 lang=java
 * @lcpr version=30203
 *
 * [33] 搜索旋转排序数组
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class SearchInRotatedSortedArray {

    // @lc code=start
    class Solution {
        public int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (target == nums[mid]) {
                    return mid;
                }
                if (nums[left] <= nums[mid]) {
                    if (nums[left] <= target && target < nums[mid]) {
                        right = mid - 1;
                    }
                    else {
                        left = mid + 1;
                    }
                }
                else {
                    if (nums[mid] < target && target <= nums[right]) {
                        left = mid + 1;
                    }
                    else {
                        right = mid - 1;
                    }
                }
            }

            return -1;
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArray().new Solution();
        // put your test code here
        
    }
}



/*
// @lcpr case=start
// [4,5,6,7,0,1,2]\n0\n
// @lcpr case=end

// @lcpr case=start
// [4,5,6,7,0,1,2]\n3\n
// @lcpr case=end

// @lcpr case=start
// [1]\n0\n
// @lcpr case=end

 */

