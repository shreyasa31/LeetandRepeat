class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, List<String>> map = new HashMap<>();

        // Build graph
        for (List<String> t : tickets) {
            String from = t.get(0);
            String to = t.get(1);

            if (!map.containsKey(from)) {
                map.put(from, new ArrayList<>());
            }
            map.get(from).add(to);
        }

        // Sort in reverse lexical order
        for (String key : map.keySet()) {
            Collections.sort(map.get(key), Collections.reverseOrder());
        }

        List<String> result = new ArrayList<>();
        dfs("JFK", map, result);

        Collections.reverse(result);
        return result;
    }

    void dfs(String airport, HashMap<String, List<String>> map, List<String> result) {
        if (!map.containsKey(airport) || map.get(airport).isEmpty()) {
            result.add(airport);
            return;
        }

        List<String> neighbors = map.get(airport);

        while (!neighbors.isEmpty()) {
            String next = neighbors.remove(neighbors.size() - 1);
            dfs(next, map, result);
        }

        result.add(airport);
    }
}