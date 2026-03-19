class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> map=new HashMap<>();
        for(int i=0;i<order.length();i++){
            map.put(order.charAt(i), i);
        }

        for(int i=0;i<words.length-1;i++){
            String s1=words[i];
            String s2=words[i+1];
            if(s1.length()!=s2.length() && s1.startsWith(s2)){
                return false;
            }
            for(int k=0,l=0;k<s1.length() && l<s2.length();k++,l++){
                if(s1.charAt(k)!=s2.charAt(l)){

                  if(map.get(s1.charAt(k))>map.get(s2.charAt(l))){
                    return false;
                }else{
                     break;
                }
            }
            }
        }
        return true;
    }
}