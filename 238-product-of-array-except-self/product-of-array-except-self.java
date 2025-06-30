class Solution {
    public int[] productExceptSelf(int[] nums) {
      
        int[] left=new int[nums.length];
        left[0]=1;
        for(int i=1;i<left.length;i++){
            left[i]=left[i-1]*nums[i-1];
        }
        int[] right=new int[nums.length];
        right[right.length-1]=1;
        for(int i=right.length-2;i>=0;i--){
            right[i]=right[i+1]*nums[i+1];
        }

        for(int k=0;k<left.length;k++){
            left[k]=left[k]*right[k];
        }
        return left;
    }
}