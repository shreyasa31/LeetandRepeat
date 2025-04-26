public class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        long count = 0;

        int left = 0; // left pointer
        int minIndex = -1, maxIndex = -1; // latest indices where minK and maxK were seen
        int invalidIndex = -1; // latest invalid number index

        for (int right = 0; right < n; right++) {
            // If out of range, reset invalid index
            if (nums[right] < minK || nums[right] > maxK) {
                invalidIndex = right;
            }

            // Update latest minK and maxK positions
            if (nums[right] == minK) minIndex = right;
            if (nums[right] == maxK) maxIndex = right;

            // Calculate valid subarrays ending at 'right'
            int validStart = Math.min(minIndex, maxIndex);
            if (validStart > invalidIndex) {
                count += (validStart - invalidIndex);
            }
        }

        return count;
    }
}
