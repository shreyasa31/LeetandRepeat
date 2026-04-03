class Solution {
    public int largestIsland(int[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        DSU ds=new DSU(r*c);
        int max=Integer.MIN_VALUE;
        int dirs[][]={{1,0},{-1,0},{0,-1},{0,1}};
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==1){
                   int currindex=i*c+j;
                   for(int[] k:dirs){
                    int nr=k[0]+i;
                    int nc=k[1]+j;
                    int neighborindex=nr*c+nc;
                    if(nr>=0 && nc>=0 && nr<r && nc<c && grid[nr][nc]==1){
                        ds.unionbysize(neighborindex,currindex);
                    }
                   }
                }
            }
        }

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
          if(grid[i][j]==1){
            continue;
          }
           int currindex=i*c+j;
           HashSet<Integer> hset=new HashSet<>();
           int total=1;
           for(int[] k:dirs){
                    int nr=k[0]+i;
                    int nc=k[1]+j;
                    int neighborindex=nr*c+nc;
                    if(nr>=0 && nc>=0 && nr<r && nc<c && grid[nr][nc]==1){
                    if(!hset.contains(ds.find(neighborindex))){
  hset.add(ds.find(neighborindex));
                       total+=ds.set[ds.find(neighborindex)];
                    }
                     
                    }
                   }
  max=Math.max(max,total);
            }
           
           
        }
         for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                 max=Math.max(max, ds.set[ds.find(i*c+j)]);
            }
            }

        

    return max;
    }
}
class DSU{ // tc and sc is 4 alpha
    int[] parent; //n
    int[] rank; //union by rank // int[] size union by size //n
    int[] set;

    public DSU(int size){
        parent=new int[size];
        rank=new int[size]; //size[]=new int[n];
        set=new int[size];
        for(int i=0;i<size;i++){
           parent[i]=i;
           //size[i]=1;
           set[i]=1;
        
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
      public boolean unionbysize(int x, int y){
        int pu=find(x);
        int py=find(y);

        if(pu==py) return false;

        if(set[pu]<set[py]){//size[pu]<Size[py] then parent[pu]=py and size[py]+=size[pu];
            parent[pu]=py;
            set[py]+=set[pu];
        }else {
            parent[py]=pu;
            set[pu]+=set[py];
            
        }
        return true;
    }
}