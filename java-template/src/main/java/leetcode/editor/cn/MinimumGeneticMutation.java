/*
 * @lc app=leetcode.cn id=433 lang=java
 * @lcpr version=30202
 *
 * [433] 最小基因变化
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class MinimumGeneticMutation {

    // @lc code=start
    class Solution {
        public int minMutation(String startGene, String endGene, String[] bank) {
            int n = bank.length;
            Set<String> visited = new HashSet<>();
            Queue<String> genePath = new LinkedList<>();
            int step = 0;

            genePath.offer(startGene);
            visited.add(startGene);

            while (!genePath.isEmpty()) {
                int levelSize = genePath.size();
                for (int i = 0; i < levelSize; ++i) {
                    String curGene = genePath.poll();
                    if (curGene.equals(endGene)) {
                        return step;
                    }
                    for (String nextGene : bank) {
                        if (compare(curGene, nextGene) && (!visited.contains(nextGene))) {
                            genePath.offer(nextGene);
                            visited.add(nextGene);
                        }
                    }
                }
                step++;
            }

            return -1;
        }

        boolean compare(String gene0, String gene1) {
            int count = 0;

            for (int i = 0; i < 8; ++i) {
                if (gene0.charAt(i) != gene1.charAt(i)) {
                    count++;
                }
            }

            return count == 1;
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new MinimumGeneticMutation().new Solution();
        // put your test code here
        solution.minMutation("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"});
    }
}



/*
// @lcpr case=start
// "AACCGGTT"\n"AACCGGTA"\n["AACCGGTA"]\n
// @lcpr case=end

// @lcpr case=start
// "AACCGGTT"\n"AAACGGTA"\n["AACCGGTA","AACCGCTA","AAACGGTA"]\n
// @lcpr case=end

// @lcpr case=start
// "AAAAACCC"\n"AACCCCCC"\n["AAAACCCC","AAACCCCC","AACCCCCC"]\n
// @lcpr case=end

 */

