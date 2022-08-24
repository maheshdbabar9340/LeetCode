/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// class Solution {
// public ListNode reverseList(ListNode head) {
// ListNode dummy = head;
// ListNode test = head;

// int n = 0;
// while(head != null) {
// n++;
// head = head.next;
// }
// int[] arr = new int[n];
// for(int i = 0; i < n; i++) {
// arr[i] = dummy.val;
// dummy = dummy.next;
// }
// for(int i = n-1; i > 0; i--) {
// test.val = arr[i];
// test = test.next;
// }
// return test;
// }
// }

class Solution {
    public ListNode reverseList(ListNode head) {
        // Special case...
        if (head == null || head.next == null)
            return head;
        // Create a new node to call the function recursively and we get the reverse
        // linked list...
        ListNode res = reverseList(head.next);
        // Set head node as head.next.next...
        head.next.next = head;
        // set head's next to be null...
        head.next = null;
        return res; // Return the reverse linked list...
    }
}