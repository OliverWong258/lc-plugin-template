/*
 * @lc app=leetcode.cn id=92 lang=java
 * @lcpr version=30403
 *
 * [92] 反转链表 II
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class ReverseLinkedListIi {

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
        ListNode successor = null;

        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode prevNode = dummy;

            while (left > 1) {
                prevNode = prevNode.next;
                head = head.next;
                left--;
                right--;
            }

            ListNode newHead = reverseFirstN(head, right);

            head.next = successor;
            prevNode.next = newHead;

            return dummy.next;
        }

        ListNode reverseFirstN(ListNode head, int n) {
            if (n == 1) {
                successor = head.next;
                return head;
            }
            else {
                ListNode newHead = reverseFirstN(head.next, n - 1);
                head.next.next = head;
                return newHead;
            }
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi().new Solution();
        // put your test code here
        
    }
}



/*
// @lcpr case=start
// [1,2,3,4,5]\n2\n4\n
// @lcpr case=end

// @lcpr case=start
// [5]\n1\n1\n
// @lcpr case=end

 */

