// https://leetcode.com/problems/merge-two-sorted-lists/
// Approach 1:Recursive

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }
}

// Approach 2 : Iterative Merging

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp_node = new ListNode(0);
        ListNode current_node = temp_node;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current_node.next = list1;
                list1 = list1.next;
            } else {
                current_node.next = list2;
                list2 = list2.next;
            }
            current_node = current_node.next;
        }

        if (list1 != null) {
            current_node.next = list1;
        } else {
            current_node.next = list2;
        }

        return temp_node.next;
    }
}