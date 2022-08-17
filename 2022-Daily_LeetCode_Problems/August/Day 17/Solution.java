// https://leetcode.com/problems/unique-morse-code-words/

// First Solution 

class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] arr = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
                "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };
        HashSet<String> set = new HashSet<String>();

        for (int j = 0; j < words.length; j++) {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < words[j].length(); i++) {
                int index = words[j].charAt(i) - 'a';
                str.append(arr[index]);
            }
            set.add(str.toString());
        }

        return set.size();
    }
}

// Second Solution: Using For Each Loop

class Solution {
    public int uniqueMorseRepresentations(String[] words) 
    {
        
        String morseCode[] ={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        Set<String> codes = new HashSet<>();
        for(String word:words)
        {
            String mcode ="";
            for(char c:word.toCharArray())
            {
                mcode=mcode+morseCode[c-'a'];
            }
            codes.add(mcode);            
        }
        return codes.size();        
    }
}