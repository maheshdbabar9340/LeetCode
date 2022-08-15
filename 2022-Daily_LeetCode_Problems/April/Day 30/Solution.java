// https://leetcode.com/problems/evaluate-division/

class Solution {
    private Map<String, Map<String, Double>> graph;
    private double[] result;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        // Build graph
        this.graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String val1 = equations.get(i).get(0);
            String val2 = equations.get(i).get(1);
            if (!graph.containsKey(val1)) {
                graph.put(val1, new HashMap<>());
            }
            if (!graph.containsKey(val2)) {
                graph.put(val2, new HashMap<>());
            }
            // Add values in the graph
            graph.get(val1).put(val2, values[i]);
            graph.get(val2).put(val1, 1 / values[i]);
        }

        double[] result = new double[queries.size()];

        // Run queries
        for (int i = 0; i < queries.size(); i++) {
            String numer = queries.get(i).get(0);
            String demon = queries.get(i).get(1);

            result[i] = calculate(numer, demon, 1, new HashSet<>());
        }
        return result;
    }

    private double calculate(String curr, String denom, double prevValues, Set<String> visited) {
        // Base Cases
        if (!graph.containsKey(curr) || !graph.containsKey(denom)) {
            return -1.00;
        }
        if (curr.equals(denom)) {
            return 1;
        }
        visited.add(curr);
        // Backtrack
        for (Map.Entry<String, Double> adj : graph.get(curr).entrySet()) {
            if (!visited.contains(adj.getKey())) {
                visited.add(adj.getKey());
                double calculated = this.calculate(adj.getKey(), denom, prevValues * adj.getValue(), visited);
                if (calculated != -1.00) {
                    return calculated * adj.getValue();
                }
                visited.remove(adj);
            }
        }
        return -1.00;
    }
}