class Solution {
    public int countSymmetricIntegers(int low, int high) {
    
    int count=0;
    
    for(int k=low;k<=high;k++){

        String nums=String.valueOf(k);
        int len=nums.length();
        int sum1=0;int sum2=0;
        if(len%2==0){
            int half=len/2;
            for(int i=0;i<half;i++){
               sum1+=nums.charAt(i)-'0';
            }

             for(int j=half;j<nums.length();j++){
               sum2+=nums.charAt(j)-'0';
            }

            if(sum1==sum2){
                count++;
            }
        
            
        }
    }
     

return count;














    }

}