class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set=new HashSet<>();
       
        int i=0;int j=0; int max=Integer.MIN_VALUE;
        while(j<s.length()){
            char c=s.charAt(j);
           
            if(!set.contains(c)){
                 set.add(c);
                max=Math.max(max, j-i+1);
                j++;
                
            }else{
                // max=Math.max(max, j-i);
                set.remove(s.charAt(i));
                i++;
            }
        }
        return max==Integer.MIN_VALUE?0:max;
    }
}