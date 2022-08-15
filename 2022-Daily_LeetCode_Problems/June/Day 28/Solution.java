// https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/

class Solution {
    public int minDeletions(String s) {
        int arr[] = new int[26];

        for (char ch : s.toCharArray())
            arr[ch - 'a']++;

        Arrays.sort(arr);

        int delete = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int freq : arr) {

            while (set.contains(freq) && freq > 0) {
                delete++;
                freq--;
            }

            if (freq > 0)
                set.add(freq);
        }

        return delete;
    }
}