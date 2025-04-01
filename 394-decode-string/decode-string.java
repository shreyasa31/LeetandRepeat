class Solution {
    public String decodeString(String s) {
        Stack<Integer> count=new Stack<>();
        Stack<StringBuilder> stringStack=new Stack<>();
        StringBuilder currentString=new StringBuilder();
        int k=0;
        for(char c:s.toCharArray()){
            if(Character.isDigit(c)){
                k=k*10+(c-'0');
             }else if(c=='['){
                count.push(k);
                stringStack.push(currentString);
                currentString=new StringBuilder();
                k=0;
             }else if(c==']'){
                int repeat=count.pop();
                StringBuilder d=stringStack.pop();
                for(int i=0;i<repeat;i++){
                    d.append(currentString);
                }
                currentString=d;
             }else{
                currentString.append(c);
             }
        }

        return currentString.toString();
    }
}