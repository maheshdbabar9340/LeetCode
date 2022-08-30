// https://leetcode.com/problems/reorder-list/

class Solution {
    public void reorderList(ListNode head) {
        // so here mid is 3 in second example
        // so me make two linked lsit which consist of
        // first in which 1-2-3 iks there
        // second in which 4-5 is there
        ListNode mid = middle(head);
        ListNode first = head;
        // so process is that we have to take last node we get fromsecond 4-5 i want 5
        // from second first node
        // so I will take revbese of that second node that mid.next
        // and marking mid.enxt ==null as break the list
        ListNode second = reverse(mid.next);
        mid.next = null;
        // continue till second is null as second will small in case of odd so that why
        // we marked till second is null
        while (second != null) {
            // first we store first next in temp because when we will link 1-5 then 1 will
            // lost connectivity with 2 so storing 2 in temp
            ListNode temp = first.next;
            // marking second next to save value as in temp2 as we will lost value
            // when 1 will conect ot 5 so 4 connectivity will be lost
            ListNode temp2 = second.next;
            // then first next with second 1-5
            first.next = second;
            // then 5 will be connect to temp as temp has 2 ---1-5-2
            second.next = temp;
            // then again when will jump to next node
            // first will be marked as 2
            // and 4 will be maekd as second
            first = temp;
            second = temp2;

        }
    }

    // taking the reverse of mid.next as when we take second list then it will come
    // in
    // right direction as follows so we have reverse it
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode forward = null;
        ListNode curr = head;
        while (curr != null) {
            forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
        }
        return prev;
    }

    // hetting middle of linked list
    public ListNode middle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}