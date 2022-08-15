// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/

// Bit Manipulation

class Solution {
    public int numberOfSteps(int num) {
        if (num == 0)
            return 0;
        int result = 0;
        while (num != 0) {
            result += ((num & 1) == 0 ? 1 : 2);
            num >>= 1;
        }
        return result - 1;
    }
}
// Math

class Solution {
    public int numberOfSteps(int num) {
        int count = 0;
        while (num != 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num--;
            }
            count++;
        }
        return count;
    }
}
// recursion

class Solution {
    public int numberOfSteps(int num) {

        int count = 1;
        if (num == 0) {
            return 0;
        }
        if (num / 2 == 0 || num - 1 == 0) {
            return count;
        }

        if (num % 2 == 0) {
            return count + numberOfSteps(num / 2);
        }

        return count + numberOfSteps(num - 1);

    }
}