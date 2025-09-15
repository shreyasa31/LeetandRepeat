class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        HashSet<Character> map=new HashSet<>();
        for(char c:brokenLetters.toCharArray()){
            map.add(c);
        }
        String[] words=text.split(" ");
        Boolean flag=false;
        int count=0;
        for(String s: words){

            for(char c:s.toCharArray()){
                if(map.contains(c)){
                    flag=true;
                   
                }
            }
          
            if(flag==false) count++;
            flag=false;
    
        }
        return count;
    }
}