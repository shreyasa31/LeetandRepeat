class Solution {
    public boolean isAnagram(String s, String t) {
          HashMap<Character, Integer> map=new HashMap<>();
          if(s.length() != t.length()) return false;
          for(char str:s.toCharArray()){
            map.put(str, map.getOrDefault(str,0)+1);
          }

          for(int i=0;i<t.length();i++){
            char c=t.charAt(i);
            if(!map.containsKey(c)) return false;
            if(map.containsKey(c)){
                map.put(c, map.get(c)-1);
            }
            if(map.get(c)==0)
            {
                map.remove(c);
            }
          }
          return true;
    }
}