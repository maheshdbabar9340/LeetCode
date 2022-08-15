// https://leetcode.com/problems/my-calendar-i/

class MyCalendar {

    TreeSet<Node> bst = new TreeSet<Node>(new Comparator1());

    public MyCalendar() {
    }

    public boolean book(int start, int end) {
        // bst doesn't insert the node and returns false if the any element in bst is
        // equal(according to the comparator) to the inserting node.
        return this.bst.add(new Node(start, end));
    }

    class Node {
        public int start, end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    // Considers the nodes as equal unless the n1 is completely less than or greater
    // than n2.
    class Comparator1 implements Comparator<Node> {
        @Override
        public int compare(Node n1, Node n2) {
            if (n1.end <= n2.start)
                return -1;
            else if (n1.start >= n2.end)
                return 1;
            else
                return 0;
        }
    }

}