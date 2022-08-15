// https://leetcode.com/problems/sort-array-by-parity/

class Solution {
    public int[] sortArrayByParity(int[] nums) {
        Stack<Integer> odd = new Stack<>();
        Stack<Integer> even = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0)
                odd.push(nums[i]);
            else
                even.push(nums[i]);
        }

        int ans[] = new int[nums.length];
        int i = 0;
        while (!even.isEmpty()) {
            ans[i++] = even.pop();
        }
        while (!odd.isEmpty()) {
            ans[i++] = odd.pop();
        }
        return ans;
    }
}

class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            if (nums[i] % 2 > nums[j] % 2) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            if (nums[i] % 2 == 0)
                i++;
            if (nums[j] % 2 != 0)
                j--;
        }
        return nums;
    }
}