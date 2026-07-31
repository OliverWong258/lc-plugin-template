/*
 * @lc app=leetcode.cn id=127 lang=java
 * @lcpr version=30202
 *
 * [127] 单词接龙
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class WordLadder {

    // @lc code=start
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> wordSet = new HashSet<>(wordList);
            Deque<String> dq = new ArrayDeque<>();
            int step = 1;

            if (!wordSet.contains(endWord)) {
                return 0;
            }

            wordSet.remove(beginWord);
            dq.addLast(beginWord);

            while (!dq.isEmpty()) {
                int sz = dq.size();
                for (int i = 0; i < sz; ++i) {
                    String curWord = dq.pollFirst();
                    if (curWord.equals(endWord)) {
                        return step;
                    }
                    char[] charArray = curWord.toCharArray();
                    for (int j = 0; j < charArray.length; ++j) {
                        char originalChar = charArray[j];
                        for (char c = 'a'; c <= 'z'; ++c) {
                            if (c == originalChar) {
                                continue;
                            }
                            charArray[j] = c;
                            String newWord = String.valueOf(charArray);
                            if (wordSet.contains(newWord)) {
                                dq.addLast(newWord);
                                wordSet.remove(newWord);
                            }
                        }    
                        charArray[j] = originalChar;
                    }
                }
                step++;
            }

            return 0;
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new WordLadder().new Solution();
        // put your test code here
        
    }
}



/*
// @lcpr case=start
// "hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]\n
// @lcpr case=end

// @lcpr case=start
// "hit"\n"cog"\n["hot","dot","dog","lot","log"]\n
// @lcpr case=end

 */

