/*
 * @lc app=leetcode.cn id=973 lang=java
 * @lcpr version=30203
 *
 * [973] 最接近原点的 K 个点
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class KClosestPointsToOrigin {

    // @lc code=start
    class Solution {
        public int[][] kClosest(int[][] points, int k) {
            int left = 0;
            int right = points.length - 1;

            while (left <= right) {
                int pivot = partition(left, right, points);
                    if (pivot == k - 1) {
                        break;
                    }
                    else if (pivot < k - 1) {
                        left = pivot + 1;
                    }
                    else {
                        right = pivot - 1;
                    }
                
            }

            return Arrays.copyOfRange(points, 0, k);
        }

        int partition(int left, int right, int[][] points) {
            int distance = pointDistance(points[right]);
            int i = left;
            int j = left;
            for (; j < right; ++j) {
                if (pointDistance(points[j]) < distance) {
                    swap(points, i, j);
                    i++;
                }
            }

            swap(points, i, right);

            return i;
        }

        int pointDistance(int[] point) {
            return point[0] * point[0] + point[1] * point[1];
        }

        void swap(int[][] points, int i, int j) {
            int[] tmp = points[i];
            points[i] = points[j];
            points[j] = tmp;
            return;
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new KClosestPointsToOrigin().new Solution();
        // put your test code here
        
    }
}



/*
// @lcpr case=start
// [[1,3],[-2,2]]\n1\n
// @lcpr case=end

// @lcpr case=start
// [[3,3],[5,-1],[-2,4]]\n2\n
// @lcpr case=end

 */

