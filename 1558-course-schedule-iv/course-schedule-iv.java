class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
         List<List<Integer>> adjList=new ArrayList<>();
          List<Set<Integer>> pre=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
             adjList.add(new ArrayList<>());
             pre.add(new HashSet<>());
        }

        int[] indegree=new int[numCourses];

        for(int[] p: prerequisites){
            int n1=p[0];
            int n2=p[1];

            adjList.get(n1).add(n2);
            indegree[n2]++;
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                  queue.add(i);
            }
        }
        int count=0;
        while(!queue.isEmpty()){
            int curr=queue.poll();
            count++;
            for(int k: adjList.get(curr)){
                pre.get(k).add(curr);
                pre.get(k).addAll(pre.get(curr));
                indegree[k]--;
                if(indegree[k]==0){
                    queue.add(k);
                }
            }
        }
        List<Boolean> res=new ArrayList<>();
       for (int[] q : queries) {
            res.add(pre.get(q[1]).contains(q[0]));
        }
        return res ;
    }
}