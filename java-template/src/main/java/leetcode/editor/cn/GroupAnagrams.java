/*
 * @lc app=leetcode.cn id=49 lang=java
 * @lcpr version=30203
 *
 * [49] 字母异位词分组
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class GroupAnagrams {

    // @lc code=start
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            
            for (String str : strs) {
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                String key = new String(chars);
                if (!map.containsKey(key)) map.put(key, new ArrayList<>());
                map.get(key).add(str);
            }

            return new ArrayList<>(map.values());
        }


    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
        // put your test code here
        
    }
}



/*
// @lcpr case=start
// ["eat", "tea", "tan", "ate", "nat", "bat"]\n
// @lcpr case=end

// @lcpr case=start
// [""]\n
// @lcpr case=end

// @lcpr case=start
// ["a"]\n
// @lcpr case=end

 */

