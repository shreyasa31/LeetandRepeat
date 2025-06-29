class Solution {
    public boolean isPalindrome(String s) {
        String lower=s.toLowerCase().replaceAll("[^a-z0-9]","");
        int i=0;int j=lower.length()-1;
 
        while(i<j){
           if(lower.charAt(i)!=lower.charAt(j)){
            return false;
           }
           i++;
           j--;
        }
        return true;
    }
}