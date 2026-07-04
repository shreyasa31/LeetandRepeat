class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        
       List<List<Integer>> adjList=new ArrayList<>();
       for(int i=0;i<n+1;i++){
        adjList.add(new ArrayList<>());
       }
       int indegree[] =new int[n+1];
       for(int[] r: relations){
           int f1=r[0];
           int f2=r[1];

           adjList.get(f1).add(f2);
    
           indegree[f2]++;

       }
       Queue<Integer> queue=new LinkedList<>();
       for(int i=0;i<indegree.length;i++)
       { 
        if(indegree[i]==0){
            queue.add(i);
        }

       }
       int[] maxNum=new int[n+1];
       for(int i=1;i<time.length+1;i++){
              maxNum[i]=time[i-1];
       }
       while(!queue.isEmpty()){
        int curr=queue.poll();
  
        for(int i: adjList.get(curr)){
            indegree[i]--;
            maxNum[i]=Math.max(maxNum[i], maxNum[curr]+time[i-1]);
            if(indegree[i]==0){
                queue.add(i);
            }
        }
       }
       int res=Integer.MIN_VALUE;
       for(int m=0;m<maxNum.length;m++){
           res=Math.max(res, maxNum[m] );
       }
       return res;
    }
}