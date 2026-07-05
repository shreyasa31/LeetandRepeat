

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>((a,b)->{
            int diffA=Math.abs(b-x);
            int diffB=Math.abs(a-x);
            if(diffA==diffB){
                return b-a;
            }else{
                return diffA-diffB;
            }
        });

        for(int i:arr){
            maxHeap.add(i);
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }
        List<Integer> res=new ArrayList<>();
        while(!maxHeap.isEmpty()){
            res.add(maxHeap.poll());
        }
        Collections.sort(res);
        return res;
    }
}