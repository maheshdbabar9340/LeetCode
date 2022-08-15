// https://leetcode.com/problems/critical-connections-in-a-network/

class Solution {
    int[] disc;
    int[] low;
    int time;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        disc = new int[n];
        low = new int[n];
        time = 0;
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] vis = new boolean[n];
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (List<Integer> edge : connections) {
            graph[edge.get(0)].add(edge.get(1));
            graph[edge.get(1)].add(edge.get(0));
        }
        criticalConnections(graph, 0, -1, vis, ans);
        return ans;
    }

    public void criticalConnections(ArrayList<Integer>[] graph, int src, int par, boolean[] vis,
            List<List<Integer>> ans) {
        disc[src] = low[src] = time++;
        vis[src] = true;

        for (int nbr : graph[src]) {
            if (nbr == par) {

            } else if (vis[nbr] == true) {
                low[src] = Math.min(low[src], disc[nbr]);
            } else if (vis[nbr] == false) {
                criticalConnections(graph, nbr, src, vis, ans);

                low[src] = Math.min(low[src], low[nbr]);

                if (disc[src] < low[nbr]) {
                    ArrayList<Integer> edge = new ArrayList<>();
                    edge.add(src);
                    edge.add(nbr);
                    ans.add(edge);
                }
            }
        }
    }
}

class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (List<Integer> c : connections) {
            map.computeIfAbsent(c.get(0), o -> new ArrayList<>()).add(c.get(1));
            map.computeIfAbsent(c.get(1), o -> new ArrayList<>()).add(c.get(0));
        }

        List<List<Integer>> ans = new ArrayList<>();
        int[] order = new int[n], low = new int[n];
        dfs(0, -1, 1, map, low, order, ans);
        // order[i] -> first time we start exploring this vertex i.
        // low[i] -> the earliest vertex that vertex i can reach.

        return ans;
    }

    private int dfs(int v, int p, int time, Map<Integer, List<Integer>> map,
            int[] low, int[] order, List<List<Integer>> ans) {
        order[v] = low[v] = time;
        for (int next : map.get(v)) {
            if (p == next)
                continue; // don't go back to parent otherwise it will mess up the order
            if (order[next] > 0)
                low[v] = Math.min(low[v], order[next]); // this edge is a back edge
            else {
                time = dfs(next, v, time + 1, map, low, order, ans);
                low[v] = Math.min(low[v], low[next]);
                if (low[next] > order[v])
                    ans.add(List.of(next, v));
                // bridge only occurs when low[child] is greater than itself.
            }
        }
        return time;
    }
}