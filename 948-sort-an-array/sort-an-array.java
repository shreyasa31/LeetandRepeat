class Solution {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums; // No sorting needed for null or single-element arrays
        }

        // Step 1: Find the minimum and maximum values in the array
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        // Step 2: Create a frequency array that can store counts for values from min to max
        int range = max - min + 1;
        int[] count = new int[range];

        // Step 3: Populate the frequency array
        for (int num : nums) {
            count[num - min]++; // Shift the index by min to handle negative numbers
        }

        // Step 4: Rebuild the sorted array from the frequency array
        int index = 0;
        for (int i = 0; i < range; i++) {
            while (count[i] > 0) {
                nums[index++] = i + min; // Rebuild the sorted array using the shifted index
                count[i]--;
            }
        }

        return nums;
    }
}