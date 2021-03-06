// class Solution {
//     public int[] findErrorNums(int[] nums) {
//         int[] arr = new int[nums.length];
//         int[] res = new int[2];
        
//         for(int i:nums){
//             arr[i-1]++;
//         }
        
//         for(int i = 0; i<arr.length; i++) {
//             if(arr[i] == 2) {
//                 res[0] = i+1;
//             }
//             if(arr[i] == 0) {
//                 res[1] = i+1;
//             }
//         }
//         return res;
//     }
// }

class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        
        for(int i:nums) {
            if(nums[Math.abs(i)-1]<0) {
                res[0] = Math.abs(i);
            }else{
                nums[Math.abs(i)-1] *=-1;
            }
        }
        
        for(int i =0; i < nums.length; i++) {
            if(nums[i]>0) {
                res[1] = i+1;
            }
        }
        return res;
    }
}