// https://leetcode.com/problems/design-add-and-search-words-data-structure/

class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode('#');

    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (char ch : word.toCharArray()) {
            if (cur.child[ch - 'a'] == null)
                cur.child[ch - 'a'] = new TrieNode(ch);
            cur = cur.child[ch - 'a'];
        }
        cur.last = true;
    }

    public boolean search(String word) {
        TrieNode s = root;
        return helper(s, 0, word);
    }

    public boolean helper(TrieNode s, int idx, String word) {
        if (idx >= word.length())
            return s.last;
        if (word.charAt(idx) == '.') {
            for (int i = 0; i < 26; i++) {
                if (s.child[i] != null && helper(s.child[i], idx + 1, word)) {
                    return true;
                }
            }
        } else {
            if (s.child[word.charAt(idx) - 'a'] == null || s.child[word.charAt(idx) - 'a'].c != word.charAt(idx))
                return false;
            s = s.child[word.charAt(idx) - 'a'];
            return helper(s, idx + 1, word);
        }
        return false;
    }

    class TrieNode {
        char c;
        TrieNode[] child;
        boolean last;

        public TrieNode(char c) {
            this.c = c;
            child = new TrieNode[26];
            last = false;
        }
    }
}