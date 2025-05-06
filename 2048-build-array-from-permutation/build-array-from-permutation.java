class Solution {
    public int[] buildArray(int[] nums) {
        ArrayList<Integer> list=new ArrayList<>();
        for(int num:nums)
        {
            list.add(nums[num]);
        }
        int i=0;
        int[] res=new int[list.size()];
        for(int n:list){
             res[i]=n;
             i++;
        }

        return res;
    }
}