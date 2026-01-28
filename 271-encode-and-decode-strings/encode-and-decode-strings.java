public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder encode=new StringBuilder();
        for(String str:strs){
            encode.append(str.length()).append('#');
            encode.append(str);
        }
        return encode.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int i=0;
        ArrayList<String> result=new ArrayList<>();
       
        while(i<s.length()){
            int j=i;
            while(s.charAt(j)!='#'){
                j++;
            }
                int length=Integer.parseInt(s.substring(i,j));
                i=j+1;
                result.add(s.substring(i,i+length));
                i+=length;
            
        }
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));