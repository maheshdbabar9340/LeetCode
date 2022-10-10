// https://leetcode.com/problems/break-a-palindrome/

class Solution {
    public String breakPalindrome(String palindrome) {
        char[] c = palindrome.toCharArray();
        int n = c.length;
        boolean b = true;
        for(int i = 0; i<n/2; i++){
            if(c[i] != 'a'){
                c[i] = 'a';
                b = false;
                break;
            }
        }
        if(b && n == 1) return "";
        else if(b){
            c[n-1] = 'b';
            return String.valueOf(c);
        }
        return String.valueOf(c);
    }
}
