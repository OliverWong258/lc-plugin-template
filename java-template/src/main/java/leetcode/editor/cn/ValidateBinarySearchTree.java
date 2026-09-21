/*
 * @lc app=leetcode.cn id=98 lang=java
 * @lcpr version=30203
 *
 * [98] 验证二叉搜索树
 */

package leetcode.editor.cn;

import java.util.*;

import javax.swing.tree.TreeNode;

import leetcode.editor.common.*;

public class ValidateBinarySearchTree {

    // @lc code=start
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        public boolean isValidBST(TreeNode root) {
            return traverse(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        boolean traverse(TreeNode root, long minVal, long maxVal) {
            if (root.val <= minVal || root.val >= maxVal) {
                return false;
            }

            if (root.left != null) {
                if(!traverse(root.left, minVal, root.val)) {
                    return false;
                }
            }

            if (root.right != null) {
                if (!traverse(root.right, root.val, maxVal)) {
                    return false;
                }
            }

            return true;
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new ValidateBinarySearchTree().new Solution();
        // put your test code here
        TreeNode nodeLeft = new TreeNode(1);
        TreeNode nodeRight = new TreeNode(3);
        TreeNode root = new TreeNode(2, nodeLeft, nodeRight);
        solution.isValidBST(root);
    }
}



/*
// @lcpr case=start
// [2,1,3]\n
// @lcpr case=end

// @lcpr case=start
// [5,1,4,null,null,3,6]\n
// @lcpr case=end

 */

