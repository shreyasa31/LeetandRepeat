class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List> map=new HashMap<>();
        for(String s:strs){
            char[] k=s.toCharArray();
            Arrays.sort(k);
            String s1=String.valueOf(k);
            if(!map.containsKey(s1)) map.put(s1, new ArrayList<>());
            map.get(s1).add(s);
          }
          return new ArrayList(map.values());
    }
}