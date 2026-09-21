/*
 * @lc app=leetcode.cn id=236 lang=java
 * @lcpr version=30403
 *
 * [236] 二叉树的最近公共祖先
 */

package leetcode.editor.cn;

import java.util.*;

import javax.swing.tree.TreeNode;

import leetcode.editor.common.*;

public class LowestCommonAncestorOfABinaryTree {

    // @lc code=start
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root.val == p.val || root.val == q.val) {
                return root;
            }
            TreeNode leftResult = lowestCommonAncestor(root.left, p, q);
            TreeNode rightResult = lowestCommonAncestor(root.right, p, q);
            if (leftResult != null && rightResult != null) {
                return root;
            }
            else {
                return leftResult != null ? leftResult : rightResult;
            }
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new LowestCommonAncestorOfABinaryTree().new Solution();
        // put your test code here
        
    }
}



/*
// @lcpr case=start
// [3,5,1,6,2,0,8,null,null,7,4]\n5\n1\n
// @lcpr case=end

// @lcpr case=start
// [3,5,1,6,2,0,8,null,null,7,4]\n5\n4\n
// @lcpr case=end

// @lcpr case=start
// [1,2]\n1\n2\n
// @lcpr case=end

 */

