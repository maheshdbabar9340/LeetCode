// import java.util.Arrays;
// class Solution {
//     public int removeDuplicates(int[] nums) {
//         int[] ans = new int[nums.length];
//         int j =0;
//         if(nums.length > 1){
//             for(int i=0; i<nums.length-1; i++) {
//                     if(nums[i]!=nums[i+1]) {
//                         ans[j++] = nums[i];
//                     }else{
//                         i++;
//                     }
//                 }
//         }
//         return ans.length;
//     }
// }

class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 1;
        for(int i = 0; i < nums.length -1; i++){
            if(nums[i] != nums[i+1]) {
                nums[index++] = nums[i+1];
            }
        }
        return index;
    }
}