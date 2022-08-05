// https://leetcode.com/problems/combination-sum-iv/

class Solution {
    public int combinationSum4(int[] nums, int target) {
        Integer[] arr=new Integer[target+1];
        return req(nums,target,arr);
    }
    public int req(int[] nums,int target,Integer[] arr){
        if(target==0){ return 1; }
        if(target<0){ return 0; }
        if(arr[target]==null){
            arr[target]=0;
            for(int i : nums){
                arr[target]+=req(nums,target-i,arr);
            }
        }
        return arr[target];
    }
}