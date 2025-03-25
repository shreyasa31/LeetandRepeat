class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        boolean odd=false;
        int count=0;
        for(int c:map.values()){
            if(c%2==0){
                count=count+c;
            }else{
                count+=c-1;
                odd=true;
            }
        }
        if(odd){
            count+=1;
        }
        return count;
    }
}