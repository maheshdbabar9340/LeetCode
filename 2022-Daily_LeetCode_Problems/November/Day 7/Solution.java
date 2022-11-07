// https://leetcode.com/problems/maximum-69-number/

class Solution {
    public int maximum69Number (int num) {
        String str = String.valueOf(num);
        char[] arr = str.toCharArray();
        for(int i = 0; i< str.length(); i++){
            if(arr[i] == '6') {
                arr[i] = '9';
                break;
            }
        }
        return Integer.parseInt(String.valueOf(arr));
    }
}
