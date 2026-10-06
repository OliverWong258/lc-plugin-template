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
        private int capacity;
        Node head;
        Node tail;
        Map<Integer, Node> map;

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
        
        public LRUCache(int capacity) {
            this.capacity = capacity;
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            map = new HashMap<>();
            head.next = tail;
            tail.previous = head;
        }

        int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            else {
                Node node = map.get(key);
                removeNode(node);
                addFirst(node);
                return node.value;
            }
        }

        void put(int key, int value) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.value = value;
                removeNode(node);
                addFirst(node);
            }
            else {
                Node node = new Node(key, value);
                addFirst(node);
                map.put(key, node);
                if (map.size() > capacity) {
                    map.remove(tail.previous.key);
                    removeNode(tail.previous);
                }
            }
        }

        void addFirst(Node node) {
            node.previous = head;
            node.next = head.next;
            head.next.previous = node;
            head.next = node;
        }

        void removeNode(Node node) {
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



