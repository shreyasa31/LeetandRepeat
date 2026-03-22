class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> deadendset=new HashSet<>(Arrays.asList(deadends));
        if(deadendset.contains("0000")){
            return -1;
        }
        
        if(target.equals("0000")){
            return 0;
        }
        HashSet<String> visited=new HashSet<>();


        Queue<String> queue=new LinkedList<>();
        queue.add("0000");
        visited.add("0000");
        int steps=0;
        while(!queue.isEmpty()){
             int size=queue.size();
             for(int i=0;i<size;i++){
                String curr=queue.poll();

                if(curr.equals(target))
                {
                    return steps;
                }

                for(String s:nextstates(curr)){
                    if(deadendset.contains(s)){
                        continue;
                    }
                    if(!visited.contains(s)){
                         visited.add(s);
                         queue.add(s);
                    }
                }


             }
             steps++;
           
        }
      
     return -1;
    }
    List<String> nextstates(String s){
       List<String> res=new ArrayList<>();

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