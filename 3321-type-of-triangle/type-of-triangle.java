class Solution {
    public String triangleType(int[] nums) {
         int a = nums[0], b = nums[1], c = nums[2];

        // Check triangle inequality
        if (a + b <= c || a + c <= b || b + c <= a) {
            return "none";
        }
        HashSet<Integer>set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }

        if(set.size()==1){
            return "equilateral";
        }else if(set.size()==2){
            return "isosceles";
        }

        return "scalene";
    }
}