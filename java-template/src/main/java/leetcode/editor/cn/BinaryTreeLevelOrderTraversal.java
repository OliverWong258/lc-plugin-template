/*
 * @lc app=leetcode.cn id=102 lang=java
 * @lcpr version=30203
 *
 * [102] 二叉树的层序遍历
 */

package leetcode.editor.cn;

import java.util.*;

import javax.swing.tree.TreeNode;

import leetcode.editor.common.*;

public class BinaryTreeLevelOrderTraversal {

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
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }

            List<List<Integer>> result = new ArrayList<>();
            Deque<TreeNode> q = new ArrayDeque<>();
            q.addLast(root);

            while (!q.isEmpty()) {
                int sz = q.size();
                List<Integer> l = new ArrayList<>();
                for (int i = 0; i < sz; ++i) {
                    TreeNode curNode = q.pollFirst();
                    l.add(curNode.val);
                    if (curNode.left != null) q.addLast(curNode.left);
                    if (curNode.right != null) q.addLast(curNode.right);
                }
                result.add(l);
            }

            return result;
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
        // put your test code here
        
    }
}



/*
// @lcpr case=start
// [3,9,20,null,null,15,7]\n
// @lcpr case=end

// @lcpr case=start
// [1]\n
// @lcpr case=end

// @lcpr case=start
// []\n
// @lcpr case=end

 */

