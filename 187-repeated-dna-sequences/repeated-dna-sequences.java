class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> h1=new HashSet<>();
        HashSet<String> h2=new HashSet<>();

        for(int i=0;i<=s.length()-10;i++){
            String k=s.substring(i, i+10);
            if(!h1.contains(k)){
                h1.add(k);
            }else{
                h2.add(k);
            }
        }

        ArrayList<String> result=new ArrayList<>(h2);
        return result;

    }
}