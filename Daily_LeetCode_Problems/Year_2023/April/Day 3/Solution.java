// Leetcode 2405

class Solution {
    public int partitionString(String s) {
        int xr=0;
        int ans=1;
        for(char c : s.toCharArray()){
            if((xr & (1<<c))!=0){
                xr=0;
                ans++;
            }
            xr^=(1<<c);
        }
        return ans;
    }
}
