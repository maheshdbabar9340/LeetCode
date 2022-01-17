// First Approach

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String words[] = s.split(" ");

        if (words.length != pattern.length())
            return false; // base condition, if words length not equals to pattern length
        // eg :- aaa != aa aa aa aa

        Map<Character, String> map1 = new HashMap<>(); // this hashmap assign the characters with words
        Map<String, Boolean> map2 = new HashMap<>(); // in this map we will mark the words as used

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);

            if (map1.containsKey(ch) == false) { // if the pattern character has not been mapped
                if (map2.containsKey(words[i]) == true) { // but the word which we will assign to i character has been
                                                          // used
                    return false; // eg :- dog = a & now dog = b;
                } else { // if the word has not been used;
                    map2.put(words[i], true); // now mark it as used
                    map1.put(ch, words[i]); // and put that word infront of character
                }
            } else {
                // if that character has already been mapped, now check with whom it has been
                // mapped
                String mwith = map1.get(ch);
                // if mwith word is not equals to words[i], means already mapped with someone,
                // then return false;
                // eg :- a = dog & now a = cat
                if (mwith.equals(words[i]) == false)
                    return false;
            }
        }
        return true;
    }
}

// Second Approach
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        if (arr.length != pattern.length())
            return false; // Base Condition

        for (int i = 0; i < pattern.length() - 1; i++) {
            for (int j = i + 1; j < pattern.length(); j++) { // Check from next element
                if (pattern.charAt(i) == pattern.charAt(j)) { // if 2 character equals
                    if (!arr[i].equals(arr[j])) { // will check whether it is equal in the array or not
                        return false;
                    }
                } else { // it means character are not equal from pattern
                    if (arr[i].equals(arr[j])) { // Will check for whether elements from array are equal
                        return false;
                    }
                }
            }
        }
        return true;
    }
}