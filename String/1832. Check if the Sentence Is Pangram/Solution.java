// Approach 1 : Converting String into char array for iterating on each element. And then check whether all alphabets are present in the given sentence or not.

class Solution {
    public boolean checkIfPangram(String sentence) {
        for (char c = 'a'; c <= 'z'; c++) {
            if (!sentence.contains(c + ""))
                return false;
        }
        return true;
    }
}

// Approach 2 : Using HashSet, for storing only unique values of all alphabets
// from given sentence and if size of set is equals to 26 it means it contains
// all alphabets.

class Solution {
    public boolean checkIfPangram(String sentence) {
        Set set = new HashSet<>();
        for (char c : sentence.toCharArray()) {
            set.add(c);
        }
        return set.size() == 26;
    }
}