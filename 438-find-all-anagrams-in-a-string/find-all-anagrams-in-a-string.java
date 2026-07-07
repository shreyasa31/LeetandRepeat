class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res=new ArrayList<>();
        HashMap<Character, Integer> map=new HashMap<>();
        for(char c:p.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        HashMap<Character, Integer> map2=new HashMap<>();
        int i=0;int j=0;
        int n=p.length();
        while(j<s.length()){
            char c=s.charAt(j);

            if(j-i+1<n){
                map2.put(c, map2.getOrDefault(c, 0)+1);
                j++;
            }else{
                map2.put(c, map2.getOrDefault(c, 0)+1);
                if(map.equals(map2)){
                    res.add(i);
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
        return res;
    }
}