class Solution {
    public long countSubarrays(int[] nums, long k) {
        int i = 0;
        int j = 0;
        long sum = 0;
        long res = 1;
        long count = 0;
        while (j < nums.length) {
            sum += nums[j];
            res = sum * (j - i + 1);

            if (res < k) {
                count += (j - i + 1);

            } else {
                while (sum *(j-i+1) >= k) {
                    sum -= nums[i];
                    i++;
                }
                count += (j - i + 1);

            }
            j++;

        }
        return count;
    }
}