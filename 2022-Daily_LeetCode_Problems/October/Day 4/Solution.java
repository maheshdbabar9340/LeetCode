// https://leetcode.com/problems/minimum-time-to-make-rope-colorful/

class Solution {
	public int minCost(String colors, int[] neededTime) {
		//using Greedy approach -> using 2 pointers
		int i=0, j=0, minTime = 0;

		while(i < colors.length()){
			int sumTime = 0, maxTime = neededTime[i];

			//keep moving j forward till ith & jth colors are same and track maxTime among all(only that baloon of similar colors will stay)
			while(j < colors.length() && colors.charAt(i) == colors.charAt(j)){
				sumTime += neededTime[j];
				maxTime = Math.max(maxTime, neededTime[j]);
				j++;
			}

			//update minTime
			minTime += (sumTime - maxTime);
			i = j;
		}

		return minTime;
	}
}
