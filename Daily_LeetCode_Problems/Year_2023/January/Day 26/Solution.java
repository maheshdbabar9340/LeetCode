// https://leetcode.com/problems/cheapest-flights-within-k-stops/description/

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<Node>> edges = new HashMap<> ();
        for (int i = 0; i < flights.length; i++) {
            int[] edge = flights[i];
            edges.computeIfAbsent (edge[0], label -> new ArrayList<> ()).add (new Node (edge[1], edge[2]));
        }
        PriorityQueue<Node> pq = new PriorityQueue<> ((a, b) -> a.dist - b.dist);
        int[][] dist = new int[n][k + 2];
        for (int i = 0; i < dist.length; i++) for (int j = 0; j < dist[0].length; j++)
            dist[i][j] = i == src ? 0 : Integer.MAX_VALUE;
        pq.offer (new Node (src, 0));
        while (!pq.isEmpty ()) {
            Node cur_node = pq.poll ();
            if (cur_node.label == dst)
                return cur_node.dist;
            if (edges.containsKey (cur_node.label)) {
                for (Node neighbor : edges.get (cur_node.label)) {
                    int new_step = cur_node.step + 1, new_dist = cur_node.dist + neighbor.dist;
                    if (new_step <= k + 1 && new_dist < dist[neighbor.label][new_step]) {
                        dist[neighbor.label][new_step]= new_dist;
                        pq.offer (new Node (neighbor.label, new_dist, new_step));
                    }
                }
            }
        }
        return -1;
    }

    static class Node {
        int label;
        int dist;
        int step = 0;
        Node (int l, int d) {label = l; dist = d; }
        Node (int l, int d, int s) {label = l; dist = d; step = s; }
        public String toString () {
            return String.format ("[%d, %d, %d]", label, dist, step);
        }
    }
}
