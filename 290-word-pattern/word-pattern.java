class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] s1 = s.split(" ");
        HashMap map = new HashMap<>(); //new thing learnt if not sure about datatype just declare like this
        if (pattern.length() != s1.length)
            return false;
        for (int i = 0; i < s1.length; i++) {

            char patternCharacter = pattern.charAt(i);
            String words = s1[i];

            if (!map.containsKey(patternCharacter)) {
                map.put(patternCharacter, i);
            }

            if (!map.containsKey(words)) {
                map.put(words, i);
            }

            if (!map.get(patternCharacter).equals( map.get(words)) ){
                return false;
            }

        }
        return true;
    }
}