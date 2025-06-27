class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map=new HashMap<>();
        for(String num:strs){
            char[] c=num.toCharArray();
            Arrays.sort(c);
            String g=String.valueOf(c);
            if(!map.containsKey(g)){
                map.put(g, new ArrayList<>());
                
            }
            map.get(g).add(num);

        }
       return new ArrayList(map.values());
    }

}