// https://leetcode.com/problems/jump-game/description/

class Solution {
    //we can use dynamic programming.
    //for a given position i
    //OPT[i] represent whether it is possible to reach the last index or not.
    //OPT[i] = true if (i == last Index)
    //OPT[i] = OPT[i+1] || OPT[i+2] || ... }} OPT[i+nums[i]]
    //OPT[i] = false if (nums[i] == 0)
    //The result is opt[0];
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        Arrays.fill(dp, false);
        dp[nums.length-1] = true;
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] == 0)
                dp[i] = false;
            else{
                if(nums[i] + i >= nums.length)
                    dp[i] = true;
                else{
                   for(int j = 1; j <= nums[i]; j++){
                       dp[i] = dp[i] || dp[i + j];
                       //tricky part: the next recurrance is aslo cover some elements for this value so that we can skip them.
                       j += nums[i + j];
                   } 
                }
            }
        }
        
        return dp[0];
    }
}
