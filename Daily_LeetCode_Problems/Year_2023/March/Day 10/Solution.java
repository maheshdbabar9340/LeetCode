// Leetcode 382

class Solution {
    ArrayList<Integer> list = new ArrayList<>();
    public Solution(ListNode head) {
        while(head!=null){
            list.add(head.val);
            head=head.next;
        }
    }
    
    public int getRandom() {
        double rand=Math.random()*list.size();
        return list.get((int)rand);
    }
}
