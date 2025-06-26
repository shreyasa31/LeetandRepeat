class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] res=new int[nums.length*2];
        int j=0;
        for(int i=0;i<res.length;i++){
            res[i]=nums[j];
            j++;
            if(i==nums.length-1){
                j=0;
            }

        }
        return res;
    }
}