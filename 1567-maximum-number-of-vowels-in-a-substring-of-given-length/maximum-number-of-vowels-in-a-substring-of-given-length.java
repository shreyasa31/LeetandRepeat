class Solution {
    public int maxVowels(String s, int k) {
        int i=0;int j=0; int max=Integer.MIN_VALUE; int count=0;
        while(j<s.length()){
            char c=s.charAt(j);
            if(isvowels(c)) count++;
            if(j-i+1<k){
                j++;
            }else{
                max=Math.max(max,count);
                if(isvowels(s.charAt(i))){
                    count--;
                }
                i++;
                j++;
            }
        }
        return max;
    }
    boolean isvowels(char s){
        if(s=='a' || s=='e' || s=='i'||s=='o'|| s=='u'){
            return true;
        }
        return false;
    }
}