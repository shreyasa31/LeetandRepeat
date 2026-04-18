class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap=new PriorityQueue();
       
        int i=0;
        while(i<nums.length){
             minHeap.add(nums[i]);
            if(minHeap.size()>k){
                minHeap.poll();
            }
           
            i++;
        }
        return minHeap.peek();
    }
}