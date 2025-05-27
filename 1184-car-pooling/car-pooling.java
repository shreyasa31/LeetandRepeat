class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] changes = new int[1001]; // Based on problem constraint (locations <= 1000)

        for (int[] trip : trips) {
            int num = trip[0];
            int from = trip[1];
            int to = trip[2];

            changes[from] += num;   // Pick up
            changes[to] -= num;     // Drop off
        }

        int current = 0;
        for (int i = 0; i < changes.length; i++) {
            current += changes[i];
            if (current > capacity) return false;
        }

        return true;
    }
}
