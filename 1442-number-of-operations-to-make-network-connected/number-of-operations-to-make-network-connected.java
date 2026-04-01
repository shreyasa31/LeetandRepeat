class Solution {
    public int makeConnected(int n, int[][] connections) {
        int numberofcomponents=n;
         if(connections.length < n-1) {
            return -1;
        }
        DSU d=new DSU(n); //create an object of the class
      
        for(int[] c:connections){ //edges m
            if(d.find(c[0]) != d.find(c[1])){ //extra edge if same

                numberofcomponents--;
               
                d.union(c[0],c[1]);
            }
        }
        return numberofcomponents-1;

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

//tc= O(n+m*alpha(n))=O(n+m) and sc=O(n)