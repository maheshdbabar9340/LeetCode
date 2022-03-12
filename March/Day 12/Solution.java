// https://leetcode.com/problems/copy-list-with-random-pointer/    

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap();

        Node dummyHead = new Node(-1);
        Node current = head, copy = dummyHead;

        while (current != null) {
            copy.next = new Node(current.val);
            copy = copy.next;
            map.put(current, copy);
            current = current.next;
        }

        current = head;
        copy = dummyHead.next;

        while (current != null) {
            copy.random = map.get(current.random);
            copy = copy.next;
            current = current.next;
        }

        return dummyHead.next;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        Node current = head;

        while (current != null) {
            Node copy = new Node(current.val);
            copy.next = current.next;
            current.next = copy;
            current = current.next.next;
        }

        current = head;
        while (current != null) {
            current.next.random = current.random == null ? null : current.random.next;
            current = current.next.next;
        }

        Node dummyHead = new Node(-1);
        Node dummy = dummyHead;
        current = head;

        while (current != null) {
            dummy.next = current.next;
            dummy = dummy.next;
            current.next = current.next.next;
            current = current.next;
        }

        return dummyHead.next;
    }
}