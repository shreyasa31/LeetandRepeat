class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {

        int[][] newedges=new int[edges.length][4];
        
        for(int i=0;i<edges.length;i++){
            newedges[i][0]=edges[i][0];
            newedges[i][1]=edges[i][1];
            newedges[i][2]=edges[i][2];
            newedges[i][3]=i;
   
        }

        Arrays.sort(newedges, (a,b)->a[2]-b[2]);
        int weight=krushkal(n, newedges, -1,-1);
ArrayList<List<Integer>> res=new ArrayList<>();
List<Integer> critical=new ArrayList<>();
List<Integer> psuedo=new ArrayList<>();
         for(int j=0;j<newedges.length;j++){
            int skippedweight=krushkal(n, newedges, j, -1);
            if(skippedweight>weight){
                 critical.add(newedges[j][3]);

            }else{
                 int includeweight=krushkal(n,newedges,-1,j);
                 if(includeweight==weight){
                    psuedo.add(newedges[j][3]);
                 }
            }
         }
     res.add(critical);
     res.add(psuedo);
     return res;



        
    }
    int krushkal(int n, int[][] newedges, int skipedges, int includeedge){
        DSU d=new DSU(n);
        int cost=0;
         int edges=0;
        if(includeedge!=-1){
            int u=newedges[includeedge][0];
            int v=newedges[includeedge][1];
            int w=newedges[includeedge][2];

            if(d.union(u,v)){
                cost+=w;
                edges++;
            }
        }
       
        for(int j=0;j<newedges.length;j++){
            if(j==skipedges || j==includeedge) continue;
            int u=newedges[j][0];
            int v=newedges[j][1];
            int w=newedges[j][2];
            
          
            if(d.union(u,v)){
                cost+=w;
                edges++;
            }
              if(edges==n-1) return cost;
        }
        return Integer.MAX_VALUE;
        
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