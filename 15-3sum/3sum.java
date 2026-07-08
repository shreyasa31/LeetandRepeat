class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int i=0; int sum=0;
        List<List<Integer>> res=new ArrayList<>();
        while(i<=nums.length-3){
            int j=i+1;
            int k=nums.length-1;
            while(i<nums.length-1 && nums[i]==nums[i+1]){
                    i++;
                   }
            while(j<k){
                sum=nums[i]+nums[j]+nums[k];
                if(sum>0){
                    k--;
                }else if(sum<0){
                  j++;
                }else{
                    ArrayList<Integer> list=new ArrayList<>();
                    list.add(nums[i]);list.add(nums[j]);list.add(nums[k]);
                   res.add(list);
                   j++;
                   k--;



                   while(j<k && nums[j]==nums[j-1]){
                    j++;
                   }
                   while(j<k && nums[k]==nums[k+1]){
                    k--;
                   }
                }
            }
            i++;
           








        }
        return res;
    }
}