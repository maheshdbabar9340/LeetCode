// https://leetcode.com/problems/odd-even-linked-list/

class Solution {
    public ListNode oddEvenList(ListNode head) {
        
        if(head==null || head.next==null){
            return head;
        }
        if(head.next.next==null){
            return head;
        }
        
        ListNode odd_head=head;
         ListNode odd_tail=head;
        ListNode even_head=head.next;
        ListNode even_tail=head.next;
        
        while(even_tail!=null && even_tail.next!=null){
           odd_tail.next=even_tail.next;
            odd_tail=odd_tail.next;
            even_tail.next=odd_tail.next;
            even_tail=even_tail.next;
            
            
        }
        odd_tail.next=even_head;
        return odd_head;
       
    }
}
