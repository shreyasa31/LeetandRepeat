class Solution {
    public int numSub(String s) {
        long mod=1000000007,  total=0, count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                count++;
            }else{
                count=0;
            }
            total=(total+count)%mod;
        }
        return (int)total;
    }
}


//Time Complexity: O(N)
//Space Complexity: O(1)