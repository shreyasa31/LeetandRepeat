class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];

        for (int i = 0; i < n; i++) {
            color[i] = -1;
        }
//here it can contains diconnected components thats why the old while queue empyty doesnt work
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                color[i] = 0;

                while (!queue.isEmpty()) {
                    int curr = queue.poll();

                    for (int k : graph[curr]) {
                        if (color[k] == -1) {
                            color[k] = 1 - color[curr];
                            queue.add(k);
                        } else if (color[k] == color[curr]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}