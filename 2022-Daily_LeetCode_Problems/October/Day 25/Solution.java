// https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/

class Solution 
{
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) 
    {
        // a simple join will de the job
        return String.join("", word1).equals(String.join("", word2));
    }
}
