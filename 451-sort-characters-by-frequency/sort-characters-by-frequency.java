class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
              map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        } 
        List<Character> res=new ArrayList<>(map.keySet());

        Collections.sort(res, (a,b)-> map.get(b)-map.get(a));
        StringBuilder sb=new StringBuilder();
        for(char c: res){
            int times=map.get(c);
            for(int i=0;i<times;i++){
                 sb.append(c);
            }
        }
        return sb.toString();


        

        
    }
}