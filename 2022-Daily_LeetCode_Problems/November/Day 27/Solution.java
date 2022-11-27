// https://leetcode.com/problems/arithmetic-slices-ii-subsequence/

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        HashMap<Integer,Integer>map[]=new HashMap[nums.length];
        int n=nums.length;
        for(int i=0;i<nums.length;i++){
            map[i]=new HashMap<>();
        }
        int ans=0;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                long dif=(long)nums[i]-(long)nums[j];
                if(dif>=Integer.MAX_VALUE||dif<=Integer.MIN_VALUE)continue;
                int d=(int)dif;
                //int len=2;
                // if(map[j].containsKey(d))
                //     len=map[j].get(d)+1;
                //only when there are 3 elements having the same cd only then 1 sequence is formed
                //hence the above commented approach does not work
                //number ending at j is 0 initallly so ans+=0
                //suppose a number ended at j 
                //like 2 4 where j is 4,d=4-2=2
                //now map[j].get(2)=1
                //now i is 6 and has the same d as j i.e 6-4=2
                //now that we have encountered the 3rd element
                //we can increment ans by map[j].get(2) i.e 1
                //we put map[i].put(d,1+0+1)i.e 2
                //now if we encounter 8
                //now j is 6 and i is 8
                //now ans+=map[j].get(2) i.e 2
                //answer is incremented by 2
                //ans=3(final answer)
                //sequences [2,4,6,8]
                //[2,4,6]
                //[4,6,8]
                int cnt1=map[i].getOrDefault(d,0);
                int cnt2=map[j].getOrDefault(d,0);
                ans+=cnt2;//there already must exists 2 number having the same common difference ending at j for it to be 1 i.e cnt1 can only be 1 if two elemenst have the same cd
                //if map[j] is encountered for the first time ans will be 0
                //now that nums[i] also has the same common diference 
        //the total number of elemst having the same cd is 3 so we can increment ans atleast by 1 as cnt2 will atleast have 1
                map[i].put(d,cnt2+cnt1+1);
                //map[i] will have freq of 1

             }
        }
        return ans;
        
    }
}
