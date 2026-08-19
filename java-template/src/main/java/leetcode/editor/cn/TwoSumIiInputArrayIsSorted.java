/*
 * @lc app=leetcode.cn id=167 lang=java
 * @lcpr version=30403
 *
 * [167] 两数之和 II - 输入有序数组
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class TwoSumIiInputArrayIsSorted {

    // @lc code=start
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int n = numbers.length;
            int left = 0;
            int right = n - 1;

            while (left < right) {
                if (numbers[left] + numbers[right] == target) {
                    return new int[]{left + 1, right + 1};
                }
                else if (numbers[left] + numbers[right] > target) {
                    right--;
                    while (right > left && numbers[right] == numbers[right + 1]) {
                        right--;
                    }
                }
                else {
                    left++;
                    while (right > left && numbers[left] == numbers[left - 1]) {
                        left++;
                    }
                }
            }            

            return new int[]{-1, -1};
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new TwoSumIiInputArrayIsSorted().new Solution();
        // put your test code here
        
    }
}



/*
// @lcpr case=start
// [2,7,11,15]\n9\n
// @lcpr case=end

// @lcpr case=start
// [2,3,4]\n6\n
// @lcpr case=end

// @lcpr case=start
// [-1,0]\n-1\n
// @lcpr case=end

 */

