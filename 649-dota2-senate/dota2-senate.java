class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer>rQueue=new LinkedList<>();
        Queue<Integer> dQueue=new LinkedList<>();

        int n=senate.length();
        for(int i=0;i<senate.length();i++){
            if(senate.charAt(i)=='R'){
               rQueue.add(i);
            }else{
                dQueue.add(i);
            }
        }
        while (!rQueue.isEmpty() && !dQueue.isEmpty()) {
            int dturn=dQueue.poll();
            int rturn=rQueue.poll();

            if(dturn<rturn){
                dQueue.add(dturn +n);

            }else{
                rQueue.add(rturn+n);
            }
        }
        return rQueue.isEmpty()?"Dire":"Radiant";
    }
}