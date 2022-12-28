// https://leetcode.com/problems/remove-stones-to-minimize-the-total/description/

class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int i : piles){
            pq.add(i);
        }
        
        while(k > 0 && !pq.isEmpty()){
            int temp = pq.poll();
            temp -= (int)Math.floor(temp/2);
            pq.add(temp);
            k--;
        }
        
        int sum = 0;
        while(!pq.isEmpty())sum += pq.poll();
        
        return sum;
    }
}
