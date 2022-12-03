// https://leetcode.com/problems/sort-characters-by-frequency/

class Solution {
    public String frequencySort(String s) {
        if (s.length() < 3) return s;

        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) map.merge(c, 1, Integer::sum);

        map.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .forEach(entry -> {
                    for (int i = 0; i < entry.getValue(); i++) {
                        sb.append(entry.getKey());
                    }
                });
				
        return sb.toString();
    }
}
