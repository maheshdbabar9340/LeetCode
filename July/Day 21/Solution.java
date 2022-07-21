// https://leetcode.com/problems/reverse-linked-list-ii/

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null)
            return null;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < left - 1; i++)
            pre = pre.next;
        ListNode start = pre.next;
        ListNode tmp = start.next;
        for (int i = 0; i < right - left; i++) {
            start.next = tmp.next;
            tmp.next = pre.next;
            pre.next = tmp;
            tmp = start.next;
        }
        return dummy.next;
    }
}