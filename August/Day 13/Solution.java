// https://leetcode.com/problems/substring-with-concatenation-of-all-words/

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        /**
         * Let n=s.length, k=words[0].length traverse s with indices i, i+k,
         * i+2k, ... for 0<=i<k, so that the time complexity is O(n).
         */
        List<Integer> res = new ArrayList<Integer>();
        int n = s.length(), m = words.length, k;
        if (n == 0 || m == 0 || (k = words[0].length()) == 0)
            return res;

        HashMap<String, Integer> wDict = new HashMap<String, Integer>();

        for (String word : words) {
            if (wDict.containsKey(word))
                wDict.put(word, wDict.get(word) + 1);
            else
                wDict.put(word, 1);
        }

        int i, j, start, x, wordsLen = m * k;
        HashMap<String, Integer> curDict = new HashMap<String, Integer>();
        String test, temp;
        for (i = 0; i < k; i++) {
            curDict.clear();
            start = i;
            if (start + wordsLen > n)
                return res;
            for (j = i; j + k <= n; j += k) {
                test = s.substring(j, j + k);

                if (wDict.containsKey(test)) {
                    if (!curDict.containsKey(test)) {
                        curDict.put(test, 1);

                        start = checkFound(res, start, wordsLen, j, k, curDict, s);
                        continue;
                    }

                    // curDict.containsKey(test)
                    x = curDict.get(test);
                    if (x < wDict.get(test)) {
                        curDict.put(test, x + 1);

                        start = checkFound(res, start, wordsLen, j, k, curDict, s);
                        continue;
                    }

                    // curDict.get(test)==wDict.get(test), slide start to
                    // the next word of the first same word as test
                    while (!(temp = s.substring(start, start + k)).equals(test)) {
                        decreaseCount(curDict, temp);
                        start += k;
                    }
                    start += k;
                    if (start + wordsLen > n)
                        break;
                    continue;
                }

                // totally failed up to index j+k, slide start and reset all
                start = j + k;
                if (start + wordsLen > n)
                    break;
                curDict.clear();
            }
        }
        return res;
    }

    public int checkFound(List<Integer> res, int start, int wordsLen, int j, int k,
            HashMap<String, Integer> curDict, String s) {
        if (start + wordsLen == j + k) {
            res.add(start);
            // slide start to the next word
            decreaseCount(curDict, s.substring(start, start + k));
            return start + k;
        }
        return start;
    }

    public void decreaseCount(HashMap<String, Integer> curDict, String key) {
        // remove key if curDict.get(key)==1, otherwise decrease it by 1
        int x = curDict.get(key);
        if (x == 1)
            curDict.remove(key);
        else
            curDict.put(key, x - 1);
    }
}