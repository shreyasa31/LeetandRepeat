class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set=new HashSet<>();
        HashSet<String> set1=new HashSet<>();

        List<String> res=new ArrayList<>();
        for(int i=0;i<=s.length()-10;i++){
             String s1=s.substring(i, i+10);
             if(!set.contains(s1)){
                set.add(s1);
             }else{
                set1.add(s1);
             }
        }
        for(String l: set1){
            res.add(l);
        }
        return res;
    }
}