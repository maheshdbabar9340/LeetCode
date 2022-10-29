// https://leetcode.com/problems/earliest-possible-day-of-full-bloom/

class Solution {
    private class Pair{
        private int plantTime;
        private int growTime;
        public Pair(int plantTime, int growTime){
            this.plantTime = plantTime;
            this.growTime = growTime;
        }
    }
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        Pair[] pairs = new Pair[n];
        for(int i = 0; i < n; i++){
            pairs[i] = new Pair(plantTime[i], growTime[i]);
        }
        // sort according to descending order of growth time
        // Plant seed which have higher growth time first
        Arrays.sort(pairs, (p1, p2) -> p2.growTime - p1.growTime);
        int max = 0;
        int totalPlantTime = 0;
        for (int i = 0; i < n; i++) {
		    //max time = totalPlantTime + current plant time + current growth time
            max = Math.max(max, totalPlantTime + pairs[i].plantTime+ pairs[i].growTime); 
            totalPlantTime = totalPlantTime + pairs[i].plantTime; //update totalPlantTime;
        }
        return max;
    }
}
