class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map=new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }

        for(char t1:t.toCharArray()){
            
            if(map.containsKey(t1)){
                map.put(t1, map.get(t1)-1);

                if(map.get(t1)==0){
                map.remove(t1);
            }
            }else{
                return false;
            }

            
        }

        return map.isEmpty();
    }
}