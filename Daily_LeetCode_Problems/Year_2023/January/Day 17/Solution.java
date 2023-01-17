// https://leetcode.com/problems/flip-string-to-monotone-increasing/description/

class Solution {
    public int minFlipsMonoIncr(String S) {
        char[] s= S.toCharArray();
        int n=s.length, res=Integer.MAX_VALUE;
        int[] fwd= new int[n+1];
        for (int i=0; i<n; i++){
            fwd[i+1]=fwd[i]+s[i]-'0';
        }
        int bwd=0;
        for (int i=n-1; i>-1; i--){
            int f1=fwd[i+1], f0=i+1-f1, b1=bwd, b0=n-1-i-b1;
            bwd+=s[i]-'0';
            res=Math.min(res, f1+b0);
        }
        res=Math.min(res, n-bwd);
        return res;
    }
}
