class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        ArrayList<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList<>());
        }
        int[] indegree=new int[numCourses];
        for(int[] k:prerequisites){
            int first=k[0];
            int second=k[1];
            indegree[second]++;
            list.get(first).add(second);
        }
        boolean[][] res=new boolean[numCourses][numCourses];
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<indegree.length;i++)
        {
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty())
        {
             int curr=queue.poll();
             for(int k: list.get(curr)){
                indegree[k]--;
                res[curr][k]=true;
                for(int i=0;i<numCourses;i++){
                    if(res[i][curr]){
                        res[i][k]=true;
                    }
                }
                if(indegree[k]==0){
                    queue.add(k);
                }
             }
        }
        List<Boolean> r=new ArrayList<>();
      for (int[] q : queries) {
            r.add(res[q[0]][q[1]]);
        }
        return r;
    }
}