class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(
                        nums1[a[0]] + nums2[a[1]],
                        nums1[b[0]] + nums2[b[1]]));

        ArrayList<List<Integer>> res = new ArrayList<>();
        for (int i=0;i<Math.min(nums2.length,k);i++) {
            minHeap.add(new int[] { 0, i });
        }

        while (k >0 && !minHeap.isEmpty()) {
            int[] h = (minHeap.poll());
            int i = h[0];
            int j = h[1];

            res.add(Arrays.asList(nums1[i], nums2[j]));
            if (i + 1 < nums1.length) {
                minHeap.add(new int[] {
                        i + 1, j
                });
            }
            k--;
        }
        return res;
    }
}