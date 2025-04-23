class Solution {
    public int countLargestGroup(int n) {
        int sum=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=1;i<=n;i++){
            int num=i;
            while(num!=0){
                int rem=num%10;
                sum+=rem;
                num=num/10;
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
            sum=0;
        

        }



        int max=0;
        for(int c: map.values()){
          max=Math.max(c,max);
        }
        int count=0;
        for(int d:map.values()){
            if(d==max){
                count++;
            }
        }

        return count;
    }
}