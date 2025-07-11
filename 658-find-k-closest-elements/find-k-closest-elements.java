class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(
            (a,b)->{
                int diffA=Math.abs(x-a);
                int diffB=Math.abs(x-b);
                if(diffA==diffB){
                    return b-a;
                }else{
                    return diffB-diffA;
                }
            }
        );

        for(int i=0;i<arr.length;i++){
            maxHeap.add(arr[i]);
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }

        ArrayList<Integer> res=new ArrayList<>();
        while(!maxHeap.isEmpty()){
            res.add(maxHeap.poll());
        }
        Collections.sort(res);
        return res;
    }
}