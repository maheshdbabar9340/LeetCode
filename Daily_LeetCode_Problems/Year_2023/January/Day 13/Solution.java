// https://leetcode.com/problems/longest-path-with-different-adjacent-characters/description/

class Solution {
    int max = 0;
    public int longestPath(int[] parent, String s) {
        Node[] list = new Node[parent.length];
        for (int i = 0; i < list.length; i++) {
            list[i] = new Node(s.charAt(i));
        }
        for (int i = 1; i < list.length; i++) {
            list[i].add(list[parent[i]]);
        }
        iterate(list[0]);
        return max;
    }
    
    private int iterate(Node root) {
        if (root == null) {
            return 0;
        }
        int myMax = 1;
        for (Node n : root.next) {
            int count = iterate(n);
            if (n.c != root.c) {
                if (myMax != 1) {
                    max = Math.max(myMax + count, max);
                }
                myMax = Math.max(count + 1, myMax);
            }
        }
        max = Math.max(myMax, max);
        return myMax;
    }
    
    public class Node {
        char c;
        List<Node> next = new ArrayList<>();
        public Node(char c) {
            this.c = c;
        }
        
        public void add(Node n) {
            n.next.add(this);
        }
    }
    
}
