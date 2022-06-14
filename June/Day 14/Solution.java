// https://leetcode.com/problems/delete-operation-for-two-strings/

class Solution {
    //l1+l2 - 2lcs
    public int minDistance(String word1, String word2) {
        int lcs = longestCommonSubsequence(word1, word2);
        
        return word1.length() + word2.length() - 2 * lcs;
    }
    
	//Utility function to find Longest Common Subsequence 
    public int longestCommonSubsequence(String text1, String text2) {
        
        char[] nums1 = text1.toCharArray();
        char[] nums2 = text2.toCharArray();
        
        int m = nums1.length, n = nums2.length;
        
        int[][] dp = new int[m + 1][n + 1];
        
        if(m == 0 || n == 0)return 0;
        
        int max = 0;
        
        for(int i = 0; i < m +1; i++){
            for(int j = 0; j < n+1; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }else{
                    if(nums1[i-1] == nums2[j-1]){
                        dp[i][j] = 1 + dp[i-1][j-1];
                        //max = Math.max(dp[i][j], max);
                    }else{
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
        }
        
        
        return dp[m][n];
    }
    
}