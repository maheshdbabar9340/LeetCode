// https://leetcode.com/problems/top-k-frequent-elements/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> maps = new HashMap<>();
        for (int i : nums) {
            if (maps.containsKey(i)) {
                maps.put(i, maps.get(i) + 1);

            } else
                maps.put(i, 1);
        }
        ArrayList<Map.Entry<Integer, Integer>> arr = new ArrayList<>(maps.entrySet());
        Collections.sort(arr, (a, b) -> b.getValue() - a.getValue());

        int[] array = new int[k];
        int i = 0;
        while (i < k) {
            array[i] = arr.get(i).getKey();
            i++;
        }
        return array;
    }
}