class Solution {
    public int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i >= 0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            
            digits[i] = 0;
        }
        
        int[] res = new int[digits.length + 1]; // for all 9's containing number
        res[0] = 1;
        return res;//no need to update 0 ..as it is default 
    }
}