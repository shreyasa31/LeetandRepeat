class Solution {
    public String countAndSay(int n) {
        String res="1"; int count=0;
        for(int i=0;i<n-1;i++){
            StringBuilder ans=new StringBuilder();
            count=1;
            for(int j=0;j<res.length();j++){
                if(j+1<res.length() && res.charAt(j)==res.charAt(j+1)){
                       count++;
                }else{
                    ans.append(count);
                    ans.append(res.charAt(j));
                    count=1;
                }
            }
            res=ans.toString();
        }
        return res;
    }
}