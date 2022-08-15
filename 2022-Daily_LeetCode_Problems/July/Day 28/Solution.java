// https://leetcode.com/problems/valid-anagram/

// Approach 1: Using Sorting

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        char cs[] = s.toCharArray();
        char ct[] = t.toCharArray();

        Arrays.sort(cs);
        Arrays.sort(ct);

        for (int i = 0; i < s.length(); i++) {
            if (cs[i] != ct[i])
                return false;
        }
        return true;
    }
}

// Approach 2: Using HashMap

class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i)) == false)
                return false;
            if (map.get(t.charAt(i)) > 1)
                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
            else
                map.remove(t.charAt(i));
        }
        return map.size() == 0;
    }
}