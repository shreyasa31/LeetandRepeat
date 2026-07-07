class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map=new HashMap<>();
        int maxfreq=0;
        int i=0;int j=0; int m=0;
        while(j<s.length()){
            char c=s.charAt(j);
            map.put(c, map.getOrDefault(c, 0)+1);
            maxfreq=Math.max(maxfreq, map.get(c));

            if((j-i+1)-maxfreq<=k){
                m=Math.max(m, j-i+1);
                j++;
                 

            }else{
               
                map.put(s.charAt(i), map.get(s.charAt(i))-1);
                if(map.get(s.charAt(i))==0){
                    map.remove(s.charAt(i));
                }
                i++;j++;
            }
        }
        return m;
    }
}