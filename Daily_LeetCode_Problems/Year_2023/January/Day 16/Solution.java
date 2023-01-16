// https://leetcode.com/problems/insert-interval/description/

class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        Iterator<Interval> iter = intervals.iterator();
        
        //merge overlap
        while( iter.hasNext() ) {
            Interval n = iter.next();
            
            int a = Math.max(n.start, newInterval.start);
            int b = Math.min(n.end, newInterval.end);
            
            //exists overlap
            if(a <= b) {
                a = Math.min(n.start, newInterval.start);
                b = Math.max(n.end, newInterval.end);
                newInterval = new Interval(a, b);
                
                iter.remove();
            }
        }
        
        //insert interval
        int i = 0;
        for( ; i < intervals.size(); i++) {
            if(intervals.get(i).start > newInterval.start) break;
        }
        
        intervals.add(i, newInterval);
        
        return intervals;
    }
}
