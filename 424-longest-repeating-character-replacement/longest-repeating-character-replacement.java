class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map=new HashMap<>();

        int i=0;int j=0; int res=Integer.MIN_VALUE; int max=0;
        while(j<s.length()){

           char c=s.charAt(j);
           map.put(c,map.getOrDefault(c,0)+1);
           max= Math.max(max, map.get(c));

           if((j-i+1)-max>k){
               
                 map.put(s.charAt(i),map.get(s.charAt(i))-1);
                    if (map.get(s.charAt(i)) == 0) {
                    map.remove(s.charAt(i));
                }
                i++;
               
           }
           res=Math.max(res,j-i+1);
           j++;

        }
return res;
    }
}