class Solution {
    public int numRabbits(int[] answers) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ans : answers) {
            map.put(ans, map.getOrDefault(ans, 0) + 1);
        }
        int total = 0;
        int groupsize = 0;
        for (int key : map.keySet()) {
            int count = map.get(key);

            groupsize = key + 1;

            int numberofGroups = (int) Math.ceil((double) count / groupsize);

            total += groupsize * numberofGroups;
        }
        return total;
    }
}