class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k==0) return 0;
        HashMap<Character, Integer> map=new HashMap<>();
        int i=0;int j=0; int max=0;
        while(j<s.length()){
            char c=s.charAt(j);
            map.put(c, map.getOrDefault(c,0)+1);
            if(map.size()<=k){
                max=Math.max(max, j-i+1);
                j++;
              
            }else{
      
               map.put(s.charAt(i), map.get(s.charAt(i))-1);
               if(map.get(s.charAt(i))==0){
                map.remove(s.charAt(i));
               }
               i++;
               j++;
            
            }
        }
        return max;
    }
}