class Solution {
    public void reverseString(char[] s) {
        // char[] t = new char[s.length];
        // for(int i=0; i < s.length; i++) {
        //     t[i] = s[s.length-i-1];
        // }
        // s = t;
        int i  = 0,j = s.length-1;
        while(i < j){
            char temp = s[i];
            s[i++] = s[j];
            s[j--] = temp;
        }
    }
}