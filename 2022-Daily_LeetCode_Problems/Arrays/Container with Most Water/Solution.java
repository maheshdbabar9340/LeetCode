// First Approach Iterative with two loops 
// Time Complexity = O(n*n) Space Complexity = Nothing

// class Solution {
//     public int maxArea(int[] height) {
//         int area = 0;
        
//         for(int i=0; i<height.length; i++){
//             for(int j=i+1; j<height.length; j++){
                
//                 // int k =0;
//                 // k = Math.min(height[i], height[j]);
//                 // int m =0;
//                 // m = Math.abs(j-i);
//                 // if(k*m >area) {
//                 //     area = k*m;
//                 // }
//                 area = Math.max(area, Math.min(height[i], height[j])* Math.abs(j-i));

//             }
//         }
//         return area;
//     }
// }

// Second Approach Two pointer strategy from both start and end.
// Time Complexity = O(n) Space Complexity = O(1)

class Solution{
    public int maxArea(int[] height) {
        int area = 0, left = 0, right = height.length-1;
        
        while(left < right){
            area = Math.max(area, Math.min(height[left], height[right])* (right-left));
            
            if(height[left] > height[right]) right--;
            else left++;
        }
        return area;
    }
}