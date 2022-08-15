// https://leetcode.com/problems/intersection-of-two-linked-lists/

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ptrA = headA, ptrB = headB;
        while (ptrA != ptrB) { // loop until we found the first common node
            ptrA = ptrA == null ? headB : ptrA.next; // once we're done with A, move to B
            ptrB = ptrB == null ? headA : ptrB.next; // once we're done with B, move to A
        }
        return ptrA;
    }
}