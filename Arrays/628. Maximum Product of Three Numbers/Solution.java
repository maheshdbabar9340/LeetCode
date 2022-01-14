import java.util.*;

class Solution {
    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int lastMax = nums[n - 1] * nums[n - 2] * nums[n - 3];
        int firstLastMax = nums[0] * nums[1] * nums[n - 1];
        // if(lastMax >= firstLastMax) {
        // return lastMax;
        // }
        // return firstLastMax;
        return Math.max(lastMax, firstLastMax);
    }

    public static void main(String[] args) {
        int[] nums = { -145, 23, 56, -333, 89, 44, 0 };
        System.out.println(maximumProduct(nums));
    }
}