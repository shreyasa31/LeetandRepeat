class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int count=0;
        int[][] grid=new int[m][n];
        int[][] dirs={{1,0},{-1,0},{0,-1},{0,1}};
        int size=m*n;
        DSU ds=new DSU(size);
        ArrayList<Integer> res=new ArrayList<>();
        for(int[] k: positions){
            int r=k[0];
            int c=k[1];
  if (grid[r][c] == 1) {
                res.add(count);
                continue;
            }
            grid[r][c]=1;
            count++;
            System.out.println(count);
            int previndex=r*n+c;
            for(int[] d:dirs){
                int nr=d[0]+r;
                int nc=d[1]+c;
                 int neighborindex=nr*n+nc;

                if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]==1){
                   if(ds.find(previndex)!=ds.find(neighborindex)){
       ds.union(previndex,neighborindex);
                   count--;
                   }
            
                    
                }
              
            }
              res.add(count);
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