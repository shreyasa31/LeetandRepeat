import java.util.HashMap;

class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int i = 0, j = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int pick = 0;
        int max = 0;

        while (j < n) {
            int r = fruits[j];

            if (map.size() < 2 || map.containsKey(r)) {
                // safe to add right fruit
                map.put(r, map.getOrDefault(r, 0) + 1);
                pick++;
                if (pick > max) max = pick;
                j++; // move right only after a valid add
            } else {
                // need to make room by removing one from the left
                int l = fruits[i];
                int c = map.get(l) - 1;
                if (c == 0) map.remove(l);
                else map.put(l, c);
                pick--;
                i++; // move left
            }
        }
        return max;
    }
}
