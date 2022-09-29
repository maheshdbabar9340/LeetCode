// https://leetcode.com/problems/find-k-closest-elements/

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int[] diff = new int[n];
        for(int i =0;i<n;i++){
            diff[i] = Math.abs(arr[i]-x);
        }
        int count = n;
        int left = 0;
        int right = n-1;
        while(count -- >k){
            if(diff[left] > diff[right]) left++;
            else right --;
        }
        List<Integer> result = new ArrayList<>();
        for(int i = left; i<= right;i++){
            result.add(arr[i]);
        }
        return result;
    }
}
