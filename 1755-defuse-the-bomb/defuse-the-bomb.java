class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] res=new int[code.length];
        int n=code.length;
        for(int i=0;i<n;i++){
            if(k>0){
              for(int j=1;j<=k;j++){
                 res[i]+=code[(i+j)%n];
              }
            }else{
              for(int j=1;j<=-k;j++){
                 res[i]+=code[(i-j+n)%n];
              }
            }
        }
        return res;
    }
}