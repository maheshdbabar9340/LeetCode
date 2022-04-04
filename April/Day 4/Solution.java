// https://leetcode.com/problems/swapping-nodes-in-a-linked-list/

class Solution {
    public static ListNode swapNodes(ListNode head, int k) {
        ListNode pNode = head;
        List<ListNode> nodeList = new ArrayList<>();
        // store these nodes.
        while (pNode != null) {
            nodeList.add(pNode);
            pNode = pNode.next;
        }

        // swap their values.
        int len = nodeList.size();
        int temp = nodeList.get(k - 1).val;
        nodeList.get(k - 1).val = nodeList.get(len - k).val;
        nodeList.get(len - k).val = temp;

        return head;
    }
}


class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head, second = head, first = head;
        for(int i=0; i<k-1; i++)    fast = fast.next;
        first = fast;
        while(fast.next != null){
            fast = fast.next;
            second = second.next;
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        return head;
    }
}
