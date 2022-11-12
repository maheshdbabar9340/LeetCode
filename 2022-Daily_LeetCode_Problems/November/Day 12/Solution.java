// https://leetcode.com/problems/find-median-from-data-stream/

class MedianFinder 
{
    PriorityQueue<Integer> sh = new PriorityQueue<>();
    PriorityQueue<Integer> lh = new PriorityQueue<>();
        
    public void addNum(int num) 
    {
        lh.add(-num);
        sh.add(-lh.poll());
        
        if (sh.size() > lh.size())
            lh.add(-sh.poll());
    }
    
    public double findMedian() 
    {
        if (sh.size() == lh.size()) 
            return (sh.peek() - lh.peek()) / 2.0;
        return -lh.peek();
    }
}
