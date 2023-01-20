// https://leetcode.com/problems/non-decreasing-subsequences/

class Solution {
     public List<List<Integer>> findSubsequences(int[] values) {
        Set<List<Integer>> set = new HashSet<>();

        Set<List<Integer>> additions = new HashSet<>();
        for (int i = values.length - 1; i >= 0; i --) {
          // try to make new sequences from the existing ones
          for (List<Integer> list : set) {
            if (list.get(0) >= values[i]) {
              List<Integer> newList = new LinkedList<>(list);
              newList.add(0, values[i]);
              additions.add(newList);
            }
          }
          set.addAll(additions);
          additions.clear();

          // make a sequence out of the current number
          List<Integer> identity = new LinkedList<>();
          identity.add(values[i]);
          set.add(identity);
        }

        // filter out lists with size less than 2
        List<List<Integer>> results = new LinkedList<>();
        for (List<Integer> list : set) {
          if (list.size() > 1) {
            results.add(list);
          }
        }
        return results;
    }
}
