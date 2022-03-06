// Using Sorting 

class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}

// Using HashMap

class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : nums) {
            if (map.containsKey(i) && map.get(i) + 1 > nums.length / 2) {
                return i;
            } else {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }
        return -1;
    }
}

class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int index = 0;

        for (int i : nums) {
            if (count == 0) {
                index = i;
            }

            if (i == index) {
                count++;
            } else {
                count--;
            }
        }
        return index;
    }
}