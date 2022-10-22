// https://leetcode.com/problems/minimum-window-substring/

class Solution {
    public String minWindow(String s, String t) {
        
        
        if(s=="" || t=="")
            return "";
        if(s==null || t==null)
            return "";
        
        int n = s.length();
        int m = t.length();
        
        
        int freq[] = new int[128];
        int characters = 0;
        
        for(int i=0;i<m;i++){
            freq[t.charAt(i)]++;
            characters++;
        }
        
        int start =0, end = 0;
        int min_length = Integer.MAX_VALUE;
        int start_index = 0;
        
        while(end < n){
            
            if(freq[s.charAt(end)]>0)
                characters--;
            freq[s.charAt(end)]--;
            end++;
            
            while(characters==0){
                
                if(min_length>end-start){
                    min_length = end-start;
                    start_index = start;
                }
                freq[s.charAt(start)]++;
                if(freq[s.charAt(start)]>0){
                    characters++;
                }
                start++;
                
            }
            
        }
        
        return min_length == Integer.MAX_VALUE? "" : s.substring(start_index,start_index+min_length);
        
    }
}
