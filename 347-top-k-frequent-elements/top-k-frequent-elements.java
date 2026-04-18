class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i:nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        PriorityQueue<Integer> minHeap=new PriorityQueue<>((a,b)-> map.get(a)-map.get(b));

        for(int i:map.keySet()){
          minHeap.add(i);
          if(minHeap.size()>k){
            minHeap.poll();
          }
   
        }
        int[] ans=new int[minHeap.size()];
        int j=0;
        while(!minHeap.isEmpty()){
            ans[j]=minHeap.poll();
            j++;
        }
        return ans;
    }
}