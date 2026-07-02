class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
         List<List<Integer>> adjList=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
             adjList.add(new ArrayList<>());
        }

        int[] indegree=new int[numCourses];

        for(int[] p: prerequisites){
            int n1=p[0];
            int n2=p[1];

            adjList.get(n2).add(n1);
            indegree[n1]++;
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                  queue.add(i);
            }
        }
        int[] res=new int[numCourses]; int i=0; int count=0;
        while(!queue.isEmpty()){
            int curr=queue.poll();
            res[i]=curr; i++;
            count++;
            for(int k: adjList.get(curr)){
                indegree[k]--;
                if(indegree[k]==0){
                    queue.add(k);
                }
            }
        }
        if(count!=numCourses) return new int[0];
        return res;
    }
}