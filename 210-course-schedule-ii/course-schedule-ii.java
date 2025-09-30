import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

        int[] indegree = new int[numCourses];

        // build graph
        for (int[] p : prerequisites) {
            int course = p[0];
            int pre = p[1];
            adj.get(pre).add(course);   // pre -> course
            indegree[course]++;         // one more requirement for course
        }

        // queue of courses ready to take
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        int[] order = new int[numCourses];
        int idx = 0;

        // Kahn BFS
        while (!q.isEmpty()) {
            int cur = q.poll();
            order[idx++] = cur;

            for (int nxt : adj.get(cur)) {
                if (--indegree[nxt] == 0) q.offer(nxt);
            }
        }

        // if we scheduled all courses return order else cycle detected
        if (idx == numCourses) return order;
        return new int[0];
    }
}
