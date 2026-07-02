class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> set=new HashSet<>();
        for(String s: deadends){
            set.add(s);
        }
        Queue<Pair<String, Integer>> queue=new LinkedList<>();
        if(set.contains("0000")) return -1;
        if(target.equals("0000")) return 0;
        if(set.contains(target)) return -1;
        queue.add(new Pair<>("0000",0));
        HashSet<String> visited=new HashSet<>();
        visited.add("0000");
        while(!queue.isEmpty()){
            Pair curr=queue.poll();
            String currentNumber=curr.getKey().toString();
            int value=(int)curr.getValue();
      
            if(currentNumber.equals(target)) return value;
            for(String comb: nextString(currentNumber)){
         
               if(!visited.contains(comb) && !set.contains(comb)){
                visited.add(comb);
                queue.add(new Pair<>(comb, value+1));
               }
            }
        }
        return -1;
    }

    List<String> nextString(String s){

       ArrayList<String> res=new ArrayList<>();
       for(int i=0;i<4;i++){
        char[] c= s.toCharArray();
        c[i]=(c[i]=='9')?'0':(char)(c[i]+1);
        res.add(new String(c));
       }
   

       for(int i=0;i<4;i++){
        char[] c1= s.toCharArray();
        c1[i]=(c1[i]=='0')?'9':(char)(c1[i]-1);
        res.add(new String(c1));
       }
       return res;
    }
}