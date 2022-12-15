// https://leetcode.com/problems/longest-common-subsequence/description/

/*
algorithm: dymanic programming. M[i][j] be the LCS(Longest Common Subsequence) from text1[0 ... i - 1],
and text2[0 ... j - 1], i and j stands for the length.
smallest problem:
    M[0][j] = 0     --> "" vs "..."
    M[i][0] = 0     --> "..." vs ""
induction rule:
    M[i][j] = 1 + M[i - 1][j - 1] if text1[i - 1] == text2[j - 1]
            = max(M[i - 1][j],      //skip current char in text1
                  M[i][j - 1],      //skip current char in text2
                  M[i - 1][j - 1]   //skip char in both text1 and text2
                  );
Complexity:
    Time: O(mn), m is length of text1, n is length of text2
    Space: O(mn) --> can be optimized to O(min(m, n)) since only accessing previous row
*/
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() < text2.length()) {
            return LCS(text1, text2);
        }
        return LCS(text2, text1);
    }
    //assumption: s1.length() < s2.length()
    public int LCS(String s1, String s2) {
        int[][] M = new int[2][s1.length() + 1];
        //row represnets the length of s2, col represents the length of s1
        
        for (int i = 1; i <= s2.length(); i++) {
            //base case
            M[i % 2][0] = 0;
            for (int j = 1; j <= s1.length(); j++) {
                if (s1.charAt(j - 1) == s2.charAt(i - 1)) {
                    M[i % 2][j] = M[(i - 1) % 2][j - 1] + 1;
                } else {
                    M[i % 2][j] = Math.max(M[(i - 1) % 2][j - 1],
                                Math.max(M[(i - 1) % 2][j], M[i % 2][j - 1]));
                }
            }
        }
        return M[s2.length() % 2][s1.length()];
    }
}
