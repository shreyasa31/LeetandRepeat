class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<List<Integer>> revlist=new ArrayList<>();
        int[] outdegree=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            revlist.add(new ArrayList<>());
        }
        for(int i=0;i<graph.length;i++){
        for(int k:graph[i]){
            outdegree[i]++;
            revlist.get(k).add(i);
        }
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<outdegree.length;i++){

            if(outdegree[i]==0){
                queue.add(i);
            }
        }
        boolean[] safe=new boolean[graph.length];
       List<Integer> res=new ArrayList<>();
        while(!queue.isEmpty()){
            int curr=queue.poll();
            safe[curr]=true;
            for(int k:revlist.get(curr)){
                outdegree[k]--;
           
                if(outdegree[k]==0){
                    queue.add(k);
                }
            }
        }
        for(int i=0;i<safe.length;i++){
          if(safe[i]) res.add(i);
        }
        return res;
    }
}