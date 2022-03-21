// https://leetcode.com/problems/partition-labels/

class Solution {
    public static List<Integer> partitionLabels(String s) {

        int lastIndex[] = new int[26];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastIndex[s.charAt(i) - 'a']);
            if (end == i) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }
}