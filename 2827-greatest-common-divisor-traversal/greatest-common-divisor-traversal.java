class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
       
         int n = nums.length;

        if (n == 1) return true;

        for (int num : nums) {
            if (num == 1) return false;
        }
         DSU d=new DSU(n);
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
           HashSet<Integer> s=primefactors(nums[i]);

           for(int k:s){
            if(map.containsKey(k)){
                d.union(map.get(k), i);
            }else{
                map.put(k, i);
            }
           }

        }
        int root=d.find(0);
        for(int k=0;k<n;k++){
            if(d.find(k)!=root)return false;
        }
        return true;
    }

    HashSet<Integer> primefactors(int num){
        HashSet<Integer> factors=new HashSet<>();
        for(int p=2;p*p<=num;p++){
            if(num%p==0){
                factors.add(p);
                while(num%p==0){
                    num/=p;
                }
            }
        }
        if(num>1) factors.add(num);
        return factors;
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