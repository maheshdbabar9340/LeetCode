// https://leetcode.com/contest/biweekly-contest-71/problems/minimum-sum-of-four-digit-number-after-splitting-digits/

class Solution {
    public int minimumSum(int num) {
        int[] arr = new int[4];
        int i = 0;
        while(num>0) {
            arr[i++] = num % 10;
            num = num/10;
        }
        Arrays.sort(arr);
        int first = arr[0]* 10 + arr[3];
        int sec = arr[1]* 10 + arr[2];
        return first + sec;
    }
}