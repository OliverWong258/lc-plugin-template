/*
 * @lc app=leetcode.cn id=206 lang=java
 * @lcpr version=30404
 *
 * [206] 反转链表
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class ReverseLinkedList {

    // @lc code=start
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode newHead = reverseList(head.next);
            head.next.next = head;
            head.next = null;

            return newHead;
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
        // put your test code here
        
    }
}



/*
// @lcpr case=start
// [1,2,3,4,5]\n
// @lcpr case=end

// @lcpr case=start
// [1,2]\n
// @lcpr case=end

// @lcpr case=start
// []\n
// @lcpr case=end

 */

