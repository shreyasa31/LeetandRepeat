class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer> map=new HashMap<>();
        ArrayList<Integer> list=new ArrayList<>();
        for(char p1:p.toCharArray()){
            map.put(p1, map.getOrDefault(p1,0)+1);
        }
        int i=0;int j=0;
        HashMap<Character, Integer> map2=new HashMap<>();
        while(j<s.length()){
            map2.put(s.charAt(j), map2.getOrDefault(s.charAt(j),0)+1);
            if(j-i+1<p.length()){
                j++;
            }else{
                if(map.equals(map2)){
                  list.add(i);
                }
                if(map2.containsKey(s.charAt(i))){
                    map2.put(s.charAt(i), map2.get(s.charAt(i))-1);
                    if(map2.get(s.charAt(i))==0){
                    map2.remove(s.charAt(i));
                }
                }
                
                i++;
                j++;
            }
        }
        return list;
    }
}