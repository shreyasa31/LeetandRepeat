class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map=new HashMap<>();
        for(String s:words){
            map.put(s, map.getOrDefault(s, 0)+1);
        }

        PriorityQueue<String> minHeap=new PriorityQueue<>((a,b)->{
            int f1=map.get(a);
            int f2=map.get(b);
            if(f1==f2){
                return b.compareTo(a);
            }else{
               return f1-f2;
            }
        });
        for(String s1:map.keySet()){
             minHeap.add(s1);

             if(minHeap.size()>k){
                minHeap.poll();
             }
        }

        List<String> res=new ArrayList<>();
        while(!minHeap.isEmpty()){
            res.add(minHeap.poll());
        }
        Collections.reverse(res);
        return res;
    }
}