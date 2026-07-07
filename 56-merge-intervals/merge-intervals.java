class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        int[] curr=intervals[0];
        List<int[]> res=new ArrayList<>();
        int i=1;
        res.add(curr);
        while(i<intervals.length){
            if(curr[1]>=intervals[i][0]){
        
                curr[1]=Math.max(curr[1], intervals[i][1]);
                
            }
            else{
               
                curr=intervals[i];
                 res.add(curr);
            }
          
            i++;
        }
        if(res.size()==0) res.add(curr);
       return  res.toArray(new int[res.size()][2]);
    }
}