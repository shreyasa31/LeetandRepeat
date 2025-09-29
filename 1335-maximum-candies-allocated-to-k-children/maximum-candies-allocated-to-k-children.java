class Solution {

    public int maximumCandies(int[] candies, long k) {
       int max = 0;
        for (int c : candies) max = Math.max(max, c);
        if (max == 0) return 0;

        int l = 1, r = max, ans = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            long pieces = 0;
            for (int c : candies) pieces += c / mid;

            if (pieces >= k) {      // mid works, try bigger
                ans = mid;
                l = mid + 1;
            } else {                // mid too big, try smaller
                r = mid - 1;
            }
        }
        return ans;

    
    }
}