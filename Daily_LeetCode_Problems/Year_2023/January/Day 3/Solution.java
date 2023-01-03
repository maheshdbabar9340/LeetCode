// https://leetcode.com/problems/delete-columns-to-make-sorted/description/

class Solution {
    public int minDeletionSize(String[] A) {
        int ans=0;
        if(A.length<=1)
            return 0;
        for(int i=0;i<A[0].length();i++)
        {
            for(int j=0;j<A.length-1;j++)
            {
                if(A[j+1].charAt(i)<A[j].charAt(i))
                {
                    ans++;
                    break;
                }
            }
        }
            
        return ans;
    }
}
