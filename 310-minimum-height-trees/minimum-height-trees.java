class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        ArrayList<Integer> res=new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        ArrayList<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }

        int[] degree=new int[n];
        for(int[] k: edges){
           int first=k[0];
           int second=k[1];
           list.get(first).add(second);
           list.get(second).add(first);
           degree[first]++;
           degree[second]++;

        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i = 0; i < n; i++){
    if(degree[i] == 1){
        queue.add(i);
    }
}
       
        int remnode=n;
        while(remnode>2){
        
           int size=queue.size();
        //    remnode=remnode-size;
           for(int i=0;i<size;i++){

            int curr=queue.poll();    
            remnode--;
            for(int k: list.get(curr)){
                degree[k]--;
                if(degree[k]==1){
                    queue.add(k);
                }
            }

        }}
       
        while(!queue.isEmpty()){
          res.add(queue.poll());
        }
       return res;
    }
}