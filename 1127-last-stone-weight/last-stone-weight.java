class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());

        for(int num:stones){
            maxHeap.add(num);
        }
        // 8 7 4 2 1 1
       
        while(maxHeap.size()>1){
            int first=maxHeap.poll();
            int second=maxHeap.poll();
            if(first>second){
               int diff=first-second;
               maxHeap.add(diff);
            }
        }
        return maxHeap.isEmpty()?0:maxHeap.peek();
    }
}