/*
 * @lc app=leetcode.cn id=11 lang=java
 * @lcpr version=30203
 *
 * [11] 盛最多水的容器
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class ContainerWithMostWater {

    // @lc code=start
    class Solution {
        public int maxArea(int[] height) {
            int result = 0;
            int left = 0;
            int right = height.length - 1;

            while (left < right) {
                result = Math.max(result, (right - left) * Math.min(height[left], height[right]));
                if (height[left] >= height[right]) {
                    right--;
                }
                else {
                    left++;
                }
            }

            return result;
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new ContainerWithMostWater().new Solution();
        // put your test code here
        
    }
}



/*
// @lcpr case=start
// [1,8,6,2,5,4,8,3,7]\n
// @lcpr case=end

// @lcpr case=start
// [1,1]\n
// @lcpr case=end

 */

