class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] arr=new int[1001];


        int curr=0;
        for(int[] trip:trips){
            int p=trip[0];
            int from=trip[1];
            int to=trip[2];

            arr[from]+=p;
            arr[to]-=p;


        }

        for(int i=0;i<arr.length;i++){
            curr+=arr[i];

            if(curr>capacity) return false;
        }
        return true;
    }
}