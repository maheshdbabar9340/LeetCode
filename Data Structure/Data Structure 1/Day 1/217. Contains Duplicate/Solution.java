// https://leetcode.com/problems/contains-duplicate/

// First Solution : Using Sorting

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0; i<nums.length-1; i++) {
            if(nums[i] == nums[i+1]) {
                return true;   
            }
        }
        return false;
    }
}

// Second Solution : Using HashSet

class Solution {
    public boolean containsDuplicate(int[] nums) {
        
     HashSet<Integer> map = new HashSet();

        for(int ele : nums){
            map.add(ele);
        }
        
        if(map.size() == nums.length)
            return false;
        
        return true;  
        
    }    
}