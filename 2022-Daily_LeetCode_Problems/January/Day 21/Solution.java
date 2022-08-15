// https://leetcode.com/problems/gas-station/

// Explanation : Let's take an example

// gas = [1, 2, 3, 4, 5]

// cost = [3, 4, 5, 1, 2]

// ind = [0, 1, 2, 3, 4]

// Now we will find difference the betweeen gas[i] - cost[i] = [-2, -2, -2, 3, 3] ===> (sum of all values) ==>0 and if it means solution is exists or else we will return -1

// lets take tank as a capacity for storing water as a 0.
// if i = 0, index = 0 at that time we will do tank += gas[i] - cost[i]

// if(tank < 0) it means we can't get the result for previous indexes, So we will update to i+1

// And at last we will check if total < 0 we will return -1 else we will return our updated index.

// So, we calculate the consumption of travel from one gas station to other. If the fuel in tank is less than 0, then reset to zero, because the gas station as start cannot support the problem. So, change the start index. And also, calculate the total consumption, so that no need of iteration in clockwise is needed. If total is still negative, then no answer.

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0, total = 0, index = 0;
        for (int i = 0; i < gas.length; i++) {
            int consume = gas[i] - cost[i];
            tank += consume;
            if (tank < 0) {
                index = i + 1;
                tank = 0;
            }
            total += consume;
        }
        return total < 0 ? -1 : index;
    }
}