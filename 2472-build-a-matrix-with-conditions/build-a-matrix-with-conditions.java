class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {

    
        int[] rows=topoSort(rowConditions, k);
        int[] cols=topoSort(colConditions, k);
 if (rows.length == 0 || cols.length == 0) {
            return new int[0][0];
        }
        int[][] res=new int[k][k];
        for(int i=0;i<k;i++){
            for(int j=0;j<k;j++){
                if(rows[i]==cols[j]){
                    res[i][j]=rows[i];
                }
            }
        }
        return res;

    }

    int[] topoSort(int[][] matrix, int k){
        ArrayList<List<Integer>> list=new ArrayList<>();

        for(int i=0;i<k+1;i++){
            list.add(new ArrayList<>());

            
        }
         int[] indegree=new int[k+1];
        
        for(int[] l:matrix){
            int first=l[0];
            int second=l[1];

            list.get(first).add(second);
            indegree[second]++;
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=1;i<indegree.length;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        int[] res=new int[k+1];
        int i=0;
        while(!queue.isEmpty())
{
    int curr=queue.poll();
res[i]=curr;
i++;
    
    for(int n:list.get(curr)){

        indegree[n]--;
        if(indegree[n]==0){
            queue.add(n);
        }
    }
}
       if(i!=k){
        return new int[0];
       }
return res;
    }
}