class Solution {
    class Pair {
        double f;
        String s;

        Pair(String s, double f) {
       
            this.s = s;
                 this.f = f;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, List<Pair>> map=new HashMap<>();

        for(int i=0;i<equations.size();i++){
           List<String> curr=equations.get(i);
            if(!map.containsKey(curr.get(0))){
                 map.put(curr.get(0), new ArrayList<>());
            }
            if(!map.containsKey(curr.get(1))){
                  map.put(curr.get(1), new ArrayList<>());
            }
            map.get(curr.get(0)).add(new Pair(curr.get(1),values[i]));
            map.get(curr.get(1)).add(new Pair(curr.get(0),1.0 / values[i]));
        }
      
        int product=1;
        double[] res=new double[queries.size()];
        int i=0;
        for(List<String> k: queries){
            String first=k.get(0);
            String second=k.get(1);
            
            if(!map.containsKey(first) || !map.containsKey(second)) {
                res[i]=-1;}
            else if(first.equals(second)){
res[i]=1;
            }
            else{
  res[i]=bfs(map,first, second);
            }
            i++;
          
        }
        return res;

    }

    double bfs( HashMap<String, List<Pair>> list, String src, String dest){
       Queue<Pair> queue=new LinkedList<>();
       HashSet<String> set=new HashSet<>();
     
       queue.add(new Pair(src, 1));
       while(!queue.isEmpty()){
        Pair curr=queue.poll();
        if((curr.s).equals(dest)) return curr.f;
        set.add(curr.s);
       
        for(Pair l: list.get(curr.s)){
             if(!set.contains(l.s)){
                set.add(l.s);
                double prod=curr.f*l.f;
                queue.add(new Pair(l.s, prod));
             }
        }

       }
       return -1;
    }
}