// class Solution {
//     public boolean containsNearbyDuplicate(int[] nums, int k) {
//         for(int i=0; i < nums.length; i++) {
//             for(int j= i+1; j < nums.length; j++) {
//                 if(nums[i] == nums[j] && Math.abs(i-j) <= k)
//                     return true;
//             }
//         }
//         return false;
//     }
// }

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++) {
            int current = nums[i];
            if(map.containsKey(current) && i - map.get(current) <= k) {
                return true;
            } else {
                map.put(current, i);
            }
        }
        return false;
    }
}