// 1523. Count Odd Numbers in an Interval Range

class Solution {
    public int countOdds(int low, int high) {
        int count=0;
        for(int i=low;i<=high;i++){
            if(i%2!=0) count++;
        }
        return count;
    }
}



class Solution {
    public int countOdds(int low, int high) {
        int total = high - low + 1;
        if(total % 2 == 0)
            return total / 2;
        else {
            if(low % 2 != 0)
                return total/2 + 1;
            else 
                return total/2;
        }
    }
}
