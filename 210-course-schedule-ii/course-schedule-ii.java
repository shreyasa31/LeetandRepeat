class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res=new int[numCourses];
        ArrayList<List<Integer>> list=new ArrayList<>();
       int[] indegree=new int[numCourses];
       int count=0;
       for(int i=0;i<numCourses;i++){
        list.add(new ArrayList<>());
       }
       for(int[] k:prerequisites){ 
        int first=k[0];
        int second=k[1];
        indegree[first]++;
        list.get(second).add(first);
       }
    
       Queue<Integer> queue=new LinkedList<>();
       for(int i=0;i<indegree.length;i++){ 
           if(indegree[i]==0){
            queue.add(i);
           }
       }
       int i=0;
       while(!queue.isEmpty()){
        int curr=queue.poll();
        count++;
        res[i]=curr;
        i++;
        for(int n:list.get(curr)){
            indegree[n]--;
            if(indegree[n]==0){
                queue.add(n);
            }
        }
        if(count==numCourses) return res;
       }
return new int[]{};
    }
}