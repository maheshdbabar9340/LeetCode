// https://leetcode.com/problems/numbers-with-same-consecutive-differences/

class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        if(n==1)
            return new int[]{1,2,3,4,5,6,7,8,9};
        
        int prev[] = numsSameConsecDiff(n-1,k);
        ArrayList<Integer> temp = new ArrayList<>();
        
        for(int x : prev){
            int y = x % 10;
            
            if(y+k <10)
                temp.add(x*10 + y+k);
            if(k>0 && y-k >=0)
                temp.add(x*10 + y-k);
        }
        
        int ar[] = new int[temp.size()];
        for(int i=0;i<temp.size();i++)
            ar[i] = temp.get(i);
        
        return ar;
    }
}