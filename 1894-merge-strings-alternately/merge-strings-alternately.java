class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i=0;int j=0;
        StringBuilder s1=new StringBuilder();
        while(i<word1.length() && j<word2.length()){ 
            s1.append(word1.charAt(i));
            s1.append(word2.charAt(j));
            i++;
            j++;

        }
        if(i==word1.length()){
            s1.append(word2.substring(j));
        }else{
            s1.append(word1.substring(i));
        }
        return s1.toString();
    }
}