// https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/

import java.util.*;
class Solution {
    HashMap<Integer,Integer> map=new HashMap<>();
    HashMap<Integer,List<int[]>> row=new HashMap<>();
    HashMap<Integer,List<int[]>> col=new HashMap<>();
    int len=10000;
    public int removeStones(int[][] stones) {
        for(int[] stone:stones){
            List<int[]> l=row.get(stone[0]);
            if(l==null){
                l=new ArrayList<>();
            }
            l.add(stone);
            row.put(stone[0],l);
            l=col.get(stone[1]);
            if(l==null){
                l=new ArrayList<>();
            }
            l.add(stone);
            col.put(stone[1],l);
        }
        int ret=stones.length;
        for(int i=0;i<stones.length;i++){
            if(dfs(stones[i])){
                ret--;
            }
        }
        return ret;
    }
    public Boolean dfs(int[] stone){
        int index=stone[0]*len+stone[1];
        if(map.containsKey(index)){
            return false;
        }
        map.put(index,1);
        List<int[]> l=row.getOrDefault(stone[0],null);
        if(l!=null){
            for(int[] arr:l){
                dfs(arr);
            }
        }
        l=col.getOrDefault(stone[1],null);
        if(l!=null){
            for(int[] arr:l){
                dfs(arr);
            }
        }
        return true;
    }
}
