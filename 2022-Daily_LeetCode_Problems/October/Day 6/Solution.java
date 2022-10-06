// https://leetcode.com/problems/time-based-key-value-store/

class Data{
    public String value;
    public int timestamp;
    public Data(String value, int timestamp){
        this.value = value;
        this.timestamp = timestamp;
    }
}
class TimeMap {
    HashMap<String, PriorityQueue<Data>> pqMap;
    public TimeMap() {
        pqMap = new HashMap<String, PriorityQueue<Data>>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!pqMap.containsKey(key)){
            pqMap.put(key,new PriorityQueue<Data>((a,b)->{
                return b.timestamp-a.timestamp;
            }));
        }
        PriorityQueue<Data> pq = pqMap.get(key);
        pq.add(new Data(value,timestamp));
    }
    
    public String get(String key, int timestamp) {
        PriorityQueue<Data> pq = pqMap.get(key);
        if(pq == null) return "";
        Iterator<Data> iterator = pq.iterator();
        while(iterator.hasNext()){
            Data dat = iterator.next();
            if(dat.timestamp <= timestamp){
                return dat.value;
            } 
        }
        return "";
    }
}
