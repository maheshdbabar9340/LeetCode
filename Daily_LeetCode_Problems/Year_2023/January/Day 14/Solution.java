// https://leetcode.com/problems/lexicographically-smallest-equivalent-string/description/

class Solution {
    public String smallestEquivalentString(String A, String B, String S) {
        UnionFind uf = new UnionFind();
        for (int i = 0; i < A.length(); ++i) {
            uf.union(A.charAt(i) - 'a', B.charAt(i) - 'a');
        }
        
        StringBuilder sb = new StringBuilder();
        for (char ch : S.toCharArray()) {
            sb.append((char)('a' + uf.find(ch - 'a')));
        }
        return sb.toString();
    }
    
    class UnionFind {
        int[] parent = new int[26];
        
        UnionFind() {
            for (int i = 0; i < 26; ++i) {
                parent[i] = i;
            }
        }
        
        int find(int a) {
            if (a != parent[a]) {
                parent[a] = find(parent[a]);
            }
            return parent[a];
        }
        
        void union(int a, int b) {
            int parentA = find(a);
            int parentB = find(b);
            
            if (parentA == parentB) return;
            
            if (parentA < parentB) {
                parent[parentB] = parentA;
            } else {
                parent[parentA] = parentB;
            }
        }
    }
}
