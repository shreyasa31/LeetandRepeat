class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        PriorityQueue<Integer> minHeap=new PriorityQueue<>((a,b)->map.get(a)-map.get(b));

        for(int num:map.keySet()){
            minHeap.add(num);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }

        int[] res=new int[minHeap.size()];
        int i=0;
        while(!minHeap.isEmpty()){
            res[i]=minHeap.poll();
            i++;
        }
        return res;
    }
}