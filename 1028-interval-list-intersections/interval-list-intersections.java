class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i=0;int j=0;
        List<int[]> res=new ArrayList<>();
        while(i<firstList.length && j<secondList.length){
            int currstrt=Math.max(firstList[i][0], secondList[j][0]);
            int currend=Math.min(firstList[i][1], secondList[j][1]);
            if(currstrt<=currend){
                res.add(new int[]{currstrt,currend});
            }

            if(firstList[i][1]<secondList[j][1]){
                i++;
            }else{
                j++;
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}