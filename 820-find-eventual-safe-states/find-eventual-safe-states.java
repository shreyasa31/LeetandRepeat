class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> revList=new ArrayList<>();
        for(int k=0;k<graph.length;k++){
            revList.add(new ArrayList<>());
        }
        int[] outdegree=new int[graph.length];
        for(int i=0;i<graph.length;i++){

        
            for(int j:graph[i]){
                    outdegree[i]++;
                  revList.get(j).add(i);
            }
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<outdegree.length;i++)
        {    
            if(outdegree[i]==0)
            queue.add(i);

        }
       List<Integer> res=new ArrayList<>();
       boolean[] safe=new boolean[graph.length];
        while(!queue.isEmpty()){
           int curr=queue.poll();

           safe[curr]=true;
           for(int num:revList.get(curr)){
            outdegree[num]--;
            if(outdegree[num]==0){
                queue.add(num);
            }
           }
        }
        for(int i=0;i<graph.length;i++){
            if(safe[i]) res.add(i);
        }
        return res;
    }
}