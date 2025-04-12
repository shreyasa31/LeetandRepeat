class Solution {
    public String reverseWords(String s) {
        String[] s1=s.split(" ");
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s1.length;i++){
        StringBuilder temp = new StringBuilder(s1[i]);
          sb.append(temp.reverse());
          if(i!=s1.length-1)
          sb.append(" ");

          
        }
        return sb.toString();
    }
}