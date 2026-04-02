class Solution {
    public int removeStones(int[][] stones) {
        DSU d=new DSU(20002);
       HashSet<Integer> set=new HashSet<>();
        for(int[] k:stones){
          int r=k[0];
          int c=k[1]+10001;
         if(d.find(r)!=d.find(c)){
          d.union(r,c);
         set.add(r);
         set.add(c);
         }
     
        }
        int count=0; int n=stones.length;
        for(int l: set)
        {
            if(d.find(l)==l){
                count++;
            }
        }
        return n-count;
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