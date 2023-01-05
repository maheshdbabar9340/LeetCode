// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/

class Solution {
	public int findMinArrowShots(int[][] points) {
		if(points.length == 0) return 0;

		Arrays.sort(points, (point1, point2) -> Integer.compare(point1[1], point2[1])); //Sorts points array with its end element

		int arrow = 1; // At least we need one arrow if array size greater than 0
		int pos = points[0][1]; // first position which will burst in the first arrow

		for(int i = 1; i < points.length; i++) {
			if(pos >= points[i][0]) { 
				continue; // it will burst from previous arrow only as it is less than or equal to position
			}
			arrow++;  
			pos = points[i][1];  
		}
		return arrow;
	}
}
