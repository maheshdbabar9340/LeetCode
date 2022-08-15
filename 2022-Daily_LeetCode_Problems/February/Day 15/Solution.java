// https://leetcode.com/problems/single-number/

// Approach 1 = Using HashSet ==> TC = O(n) SC=O(n)

class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i : nums) {
            if (set.contains(i)) {
                set.remove(i);
            } else {
                set.add(i);
            }
        }

        for (int i : set) {
            return i;
        }
        return -1;
    }
}

// Approach 2 = Using Sorting ==> TC: O(NlogN) SC: O(1)

class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i += 2) {
            if (nums[i] != nums[i - 1]) {
                return nums[i - 1];
            }
        }
        return nums[nums.length - 1];
    }
}

// Approach 3 = Using XOR ==> TC: O(N) SC: O(1)

class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int x : nums)
            ans ^= x;
        return ans;
    }
}