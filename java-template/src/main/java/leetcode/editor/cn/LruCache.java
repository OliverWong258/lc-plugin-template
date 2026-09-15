/*
 * @lc app=leetcode.cn id=146 lang=java
 * @lcpr version=30202
 *
 * [146] LRU 缓存
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class LruCache {

    // @lc code=start
    class LRUCache {
        
        class Node {
            int key;
            int value;
            Node previous;
            Node next;
            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        int cap;
        Map<Integer, Node> map = new HashMap<>();
        Node head = new Node(-1, -1);
        Node tail = new Node(-1, -1);
        
        public LRUCache(int capacity) {
            this.cap = capacity;    
            head.next = tail;
            tail.previous = head;
        }
        
        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }    
            Node node = map.get(key);
            remove(node);
            addFirst(node);
            return node.value;
        }
        
        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.value = value;
                remove(node);
                addFirst(node);
                return;
            }
            else {
                Node node = new Node(key, value);
                addFirst(node);
                map.put(key, node);
                if (map.size() > cap) {
                    map.remove(tail.previous.key);
                    remove(tail.previous);
                }
                return;
            }
        }

        void addFirst(Node node) {
            node.next = head.next;
            node.previous = head;
            head.next.previous = node;
            head.next = node;
        }

        void remove(Node node) {
            node.previous.next = node.next;
            node.next.previous = node.previous;
        }
    }
    
    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new LruCache().new Solution();
        // put your test code here
        
    }
}



