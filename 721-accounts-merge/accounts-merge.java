class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        DSU d=new DSU(accounts.size());
        HashMap<String, Integer> mailtoindex=new HashMap<>();

        for(int i=0;i<accounts.size();i++){
            List<String> account=accounts.get(i);
            for(int j=1;j<account.size();j++){
                if(!mailtoindex.containsKey(account.get(j))){
                    mailtoindex.put(account.get(j), i);
                }else{
                    d.union(mailtoindex.get(account.get(j)),i);
                }
            }
        }

        HashMap<Integer, List<String>> parenttomail=new HashMap<>();
        for(String k: mailtoindex.keySet()){
            int parent=d.find(mailtoindex.get(k));
            if(!parenttomail.containsKey(parent)){
       parenttomail.put(parent,new ArrayList<String>());
            }
     
            parenttomail.get(parent).add(k);
        }
           List<List<String>> res= new ArrayList<>();
        for( int l: parenttomail.keySet()){
        
            List<String> email=parenttomail.get(l);
            Collections.sort(email);
            
           List<String> merged=new ArrayList<>();
           merged.add(accounts.get(l).get(0));
           merged.addAll(email);

           res.add(merged);

            


        }
        return res;
    }
}
class DSU{ // tc and sc is 4 alpha
    int[] parent; //n
    int[] rank; //union by rank // int[] size union by size //n

    public DSU(int size){
        parent=new int[size];
        rank=new int[size]; //size[]=new int[n];
        for(int i=0;i<size;i++){
           parent[i]=i;
           //size[i]=1;
        
         }
    }

    public int find(int x){
        if(x==parent[x]){
            return x;
        }

       parent[x]= find(parent[x]); //path compression to get constant time parent
       return parent[x];

    }

    public boolean union(int x, int y){
        int pu=find(x);
        int py=find(y);

        if(pu==py) return false;

        if(rank[pu]<rank[py]){//size[pu]<Size[py] then parent[pu]=py and size[py]+=size[pu];
            parent[pu]=py;
        }else if(rank[py]<rank[pu]){
            parent[py]=pu; //else size[py]<Size[pu] then parent[py]=pu and size[pu]+=size[py];
        }else{
            parent[py]=pu;
            rank[pu]++;
        }
        return true;
    }
}