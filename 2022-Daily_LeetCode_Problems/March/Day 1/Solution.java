// https://leetcode.com/problems/counting-bits/

class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i < ans.length; i++) {
            int count = 0;
            int check = i;
            while (check > 0) {
                if (check % 2 == 1) {
                    count++;
                }
                check = check / 2;
            }
            ans[i] = count;
        }
        return ans;
    }
}

class Solution {
    public int[] countBits(int n) {
        int res[] = new int[n + 1]; // create one result array,
        // & our array size is n + 1 because we have to cover 0 as well

        for (int i = 0; i <= n; i++) { // run a loop to store all the values we get from a solve function
            res[i] = solve(i);
        }
        return res;
    }

    public int solve(int n) {
        // base condition
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        if (n % 2 == 0)
            return solve(n / 2); // handling even case
        else
            return 1 + solve(n / 2); // handling odd case
    }
}