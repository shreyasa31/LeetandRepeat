

class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length(); //hashset fails for aaabc
        int i = 0, j = 0;
        int result = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        while (j < n) {
            // Add current character to the map
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // While window contains all 3 characters
            while (map.size() == 3) {
                result += (n - j); // all substrings starting at i and ending from j to end

                // Shrink window from left
                char leftChar = s.charAt(i);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                i++;
            }

            j++; // expand window from the right
        }

        return result;
    }
}
