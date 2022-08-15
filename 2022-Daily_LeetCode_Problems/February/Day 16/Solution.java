// https://leetcode.com/problems/swap-nodes-in-pairs/

class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null)
            return null;
        ListNode cur = head;

        while (cur != null && cur.next != null) {
            int tmp = cur.val;
            cur.val = cur.next.val;
            cur.next.val = tmp;

            cur = cur.next.next;
        }
        return head;
    }
}