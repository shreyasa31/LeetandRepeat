class Solution {
    public String decodeString(String s) {
        Stack<Integer> count=new Stack<>();
        Stack<StringBuilder> stringb=new Stack<>();
        StringBuilder sb=new StringBuilder(); int k=0;
        for(int i=0;i<s.length();i++){
          char c=s.charAt(i);

          if(Character.isDigit(c)){
            k=k*10 +(c-'0');
          }else if(c=='['){
            count.push(k);
            stringb.push(sb);

            k=0;
            sb=new StringBuilder();
          }else if(c==']'){
             int repeat=count.pop();
             StringBuilder letter=stringb.pop();
             for(int j=0;j<repeat;j++){
                  letter.append(sb);
             }
             sb=letter;
          }else{
            sb.append(c);
          }
        }
        return sb.toString();
    }
}