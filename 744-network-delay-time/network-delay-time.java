class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<List<int[]>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            list.get(u).add(new int[]{v, w});
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{k, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int dist = curr[1];

            if (dist > distance[node]) continue;

            for (int[] nei : list.get(node)) {
                int nextNode = nei[0];
                int weight = nei[1];

                if (dist + weight < distance[nextNode]) {
                    distance[nextNode] = dist + weight;
                    pq.add(new int[]{nextNode, distance[nextNode]});
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, distance[i]);
        }

        return max;
    }
}