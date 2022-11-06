// https://leetcode.com/problems/orderly-queue/

class Solution 
{
    public String orderlyQueue(String s, int k) 
    {
        if (k > 1)
        {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
        
        String ss = s;
        for (int i = 1; i < s.length(); i++) 
        {
            String rot = s.substring(i) + s.substring(0, i);
            if (ss.compareTo(rot) > 0) ss = rot;
        }
        return ss;
    }
}
