class Solution {
    public boolean checkInclusion(String s1, String s2) {
       HashMap<Character,Integer> map=new HashMap<>();
       for(char c:s1.toCharArray()){
        map.put(c, map.getOrDefault(c,0)+1);
       }
       HashMap<Character,Integer> map2=new HashMap<>();
       int i=0;int j=0; int k=s1.length();
       while(j<s2.length()){
           if(j-i+1<k){ 
             map2.put(s2.charAt(j),map2.getOrDefault(s2.charAt(j),0)+1);
             j++;
            
           }else{
            map2.put(s2.charAt(j),map2.getOrDefault(s2.charAt(j),0)+1);
            if(map.equals(map2)){
                return true;
            }
            if(map2.containsKey(s2.charAt(i))){
            map2.put(s2.charAt(i),map2.get(s2.charAt(i))-1);
            if(map2.get(s2.charAt(i))==0){
                map2.remove(s2.charAt(i));
            }}
            i++;
            j++;
           
          
       
           }
       }
       return false;
    }
}