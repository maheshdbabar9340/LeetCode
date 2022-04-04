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