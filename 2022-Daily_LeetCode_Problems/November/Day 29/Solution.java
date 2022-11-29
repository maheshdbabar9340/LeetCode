// https://leetcode.com/problems/insert-delete-getrandom-o1/

class RandomizedSet {
    Map<Integer, Integer> valToPos = new HashMap<>();
    List <Integer> vals = new ArrayList<>();
    Random rand = new Random();
    public RandomizedSet() {
        
    }
    
    public boolean insert(int val) {
        if(valToPos.containsKey(val)) return false;
        vals.add(val);
        valToPos.put(val, vals.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!valToPos.containsKey(val)) return false;
        int pos = valToPos.remove(val);
        int last = vals.remove(vals.size() - 1);
        if(pos == vals.size()) return true;
        vals.set(pos, last);
        valToPos.put(last, pos);
        return true;
    }
    
    public int getRandom() {
        return vals.get(rand.nextInt(vals.size()));
    }
}
