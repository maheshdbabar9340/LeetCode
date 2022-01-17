// First Approach : We will take three variables, space for counting spaces, check is the index for returning substring from index 0 to index check and least is for if space counts are not equal to k it means we go till k-1. i.e. we take least variable if least == 0 it means we did not achived till k we need to return whole string and if least == 1 ....we go till k...return substring from 0 to check.

class Solution {
    public String truncateSentence(String s, int k) {
        int sub = 0, check = 0, least = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sub++;
                if (sub == k) {
                    check = i;
                    least++;
                }
            }
        }
        if (least == 0)
            return s;
        return s.substring(0, check);
    }
}


// Second Approach : Using split to convert it into array and appending each string to StringBuilder

class Solution {
    public String truncateSentence(String s, int k) {
        String words[] = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k - 1; i++) {
            sb.append(words[i] + " ");
        }
        sb.append(words[k - 1]);
        return sb.toString();
    }
}