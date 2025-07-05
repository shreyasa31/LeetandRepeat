class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0;int j=0;
        HashSet<Character> set=new HashSet<>();
        int max=Integer.MIN_VALUE;
        while(j<s.length()){
            char c=s.charAt(j);
            if(set.contains(c)){
               set.remove(s.charAt(i));
               i++;
            }else{
                 set.add(c);
                 max=Math.max(j-i+1,max);
                
                 j++;
            }
            


        }
        return max==Integer.MIN_VALUE?0:max;
    }
}