class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
         List<Integer> res=new ArrayList<>();
        if(n==1) return Arrays.asList(0);
        int[] degree=new int[n];
        
        List<List<Integer>> adjList=new ArrayList<>();
        for(int j=0;j<n;j++){
            adjList.add(new ArrayList<>());
        }
        for(int[] edge:edges){
           int f1=edge[0];
           int f2=edge[1];

           adjList.get(f1).add(f2);
           adjList.get(f2).add(f1);

           degree[f1]++;
           degree[f2]++;
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<degree.length;i++){
             if(degree[i]==1){
                queue.add(i);
             }
        }
       int remNode=n;
        while(remNode>2){
            int size=queue.size();
            remNode-=queue.size();
         for(int l=0;l<size;l++){

            
            int curr=queue.poll();
         
            for(int i: adjList.get(curr)){
                degree[i]--;
                if(degree[i]==1){
                    queue.add(i);
                }
            }
        }}

    
        for(int k=0;k<remNode;k++){
            res.add(queue.poll());
        }
        return res;
    }
}