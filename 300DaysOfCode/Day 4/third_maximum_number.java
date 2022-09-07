// https://leetcode.com/problems/third-maximum-number/

// First Apprroach - Using Hashset

class third_maximum_number {
    public int thirdMax(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int[] ans = new int[set.size()];
        int c = 0;
        for (int s : set) {
            ans[c] = s;
            c++;
        }
        Arrays.sort(ans);
        if (ans.length >= 3) {
            return ans[ans.length - 3];
        } else {
            return ans[ans.length - 1];
        }
    }
}

// Second Approach

class Solution {
    public int thirdMax(int[] nums) {
        Integer max = null;
        Integer second_max = null;
        Integer third_max = null;

        for (Integer num : nums) {
            if (num.equals(max) || num.equals(second_max) || num.equals(third_max)) {
                continue;
            }

            if (max == null || num > max) {
                third_max = second_max;
                second_max = max;
                max = num;
            } else if (second_max == null || num > second_max) {
                third_max = second_max;
                second_max = num;
            } else if (third_max == null || num > third_max) {
                third_max = num;
            }
        }

        if (third_max == null) {
            return max;
        }
        return third_max;
    }
}
