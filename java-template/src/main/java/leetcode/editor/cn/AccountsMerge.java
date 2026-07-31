/*
 * @lc app=leetcode.cn id=721 lang=java
 * @lcpr version=30202
 *
 * [721] 账户合并
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class AccountsMerge {

    // @lc code=start
    class Solution {
        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            Map<String, String> parents = new HashMap<>();
            Map<String, String> email2name = new HashMap<>();
            Map<String, List<String>> groups = new HashMap<>();
            List<List<String>> result = new ArrayList<>();

            for (List<String> account : accounts) {
                String name = account.get(0);
                for (int i = 1; i < account.size(); ++i) {
                    String email = account.get(i);
                    parents.put(email, email);
                    email2name.put(email, name);
                }
            }

            for (List<String> account : accounts) {
                String rootEmail = account.get(1);
                for (int i = 2; i < account.size(); ++i) {
                    union(account.get(i), rootEmail, parents);
                }
            }

            for (String email : parents.keySet()) {
                String rootEmail = find(email, parents);
                if (!groups.containsKey(rootEmail)) {
                    groups.put(rootEmail, new ArrayList<>());
                }
                groups.get(rootEmail).add(email);
            }

            for (String rootEmail : groups.keySet()) {
                List<String> account = new ArrayList<>();
                account.add(email2name.get(rootEmail));
                List<String> emails = groups.get(rootEmail);
                Collections.sort(emails);
                for (String email : emails) {
                    account.add(email);
                }
                result.add(account);
            }

            return result;
        }

        String find(String email, Map<String, String> parents) {
            if (!email.equals(parents.get(email))) {
                parents.put(email, find(parents.get(email), parents));
            }

            return parents.get(email);
        }

        void union(String email1, String email2, Map<String, String> parents) {
            String parent1 = find(email1, parents);
            String parent2 = find(email2, parents);
            if (!parent1.equals(parent2)) {
                parents.put(parent1, parent2);
            }
            return;
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new AccountsMerge().new Solution();
        // put your test code here
        
    }
}



/*
// @lcpr case=start
// [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John",\n"johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]\n
// @lcpr case=end

// @lcpr case=start
// \n[["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"],["Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"],["Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"],["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],["Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"]]\n
// @lcpr case=end

 */

