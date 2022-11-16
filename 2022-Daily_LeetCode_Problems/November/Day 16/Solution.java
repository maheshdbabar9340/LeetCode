// https://leetcode.com/problems/guess-number-higher-or-lower/

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        long s = 1;
        while (s <= n)
        {
            int x = (int)((n + s) / 2);
            int g = guess(x);
            if (g == 0)  return x;
            if (g < 0)   n = x - 1;
            if (g > 0)   s = x + 1;
        }
        return -1;
    }
}
