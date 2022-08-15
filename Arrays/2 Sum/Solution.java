// First Approach by iterating two loops Time Complexity = O(n*n)
// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         int[] ans = new int[2];
//         for(int i=0; i<nums.length; i++){
//             for(int j=i+1; j<nums.length; j++){
//                 if(nums[i]+nums[j]==target){
//                     ans[0] = i;
//                     ans[1] = j;
//                 }
//             }
//         }
//         return ans;
//     }
// }

// Second Approach by HashMap Time complexity = O(n)
class Solution{
    public int[] twoSum(int[] nums, int target){
        int[] ans = new int[2];
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
            for(int i=0; i<nums.length;i++){

                int diff = target - nums[i];
                if(map.containsKey(diff)){
                    ans[0] = i;
                    ans[1] = map.get(diff);
                    return ans;
                }
                map.put(nums[i], i);
            }
        return ans;
        }
}

// We are mapping array values as keys and array index as value 