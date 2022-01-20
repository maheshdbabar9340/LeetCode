// https://leetcode.com/problems/middle-of-the-linked-list/

// Brute Force Code:-
// Time Complexity: O(N)+O(N/2) = O(N)
// Space Complexity: O(1)

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode temp = head;
        int length = 0;
        // Traversing temp till the end of linked list to find length #O(n)
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        int middle = length / 2;
        temp = head;
        // traversing temp node back to middle node #O(n/2)
        while (middle != 0) {
            temp = temp.next;
            middle--;
        }
        return temp;
    }
}

// Two Pointer Algortihm or Tortoise and Hare Algorithm :

// Initialize the two pointers slow and fast at the head of linked list .
// Now every time, slow moves 1 step at a time while fast is moves 2 steps at a
// time. When fast pointer arrives at the end, slow pointer will arrive right in
// the middle of our linked list.
// Now just return the value of slow pointer .

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode tortoise = head;
        ListNode hear = head;

        while (hear != null && hear.next != null) {
            tortoise = tortoise.next;
            hear = hear.next.next;
        }

        return tortoise;
    }
}

// Time Complexity: O(N/2)=O(N)
// Space Complexity: O(1)