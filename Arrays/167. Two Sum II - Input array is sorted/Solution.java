// class Solution {
//     public int[] twoSum(int[] numbers, int target) {
//         int check = 0;
//         int[] res = new int[2];
//         for(int i =0; i < numbers.length; i++) {
//             check = target - numbers[i];
//             for(int j = i+1; j<numbers.length; j++) {
//                 if(check == numbers[j]){
//                     res[0] = i+1;
//                     res[1] = j+1;
//                 }
//             }
//         }
//         return res;
//     }
// }

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res=new int[2];
        int n=nums.length;
        int low=0;
        int high=n-1;
        while(low<high){
            if(nums[low]+nums[high]==target){
                res[0]=low+1;
                res[1]=high+1;
                return res;
            }
            else if(nums[low]+nums[high]<target){      
                low++;        //increment the low pointer
            }
            else     //nums[low]+nums[high]>target
                high--;      //decrement the high pointer
        }
        return res;
    }
}