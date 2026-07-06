class Solution {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> map=new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }

        PriorityQueue<Character> maxHeap=new PriorityQueue<>((a,b)-> map.get(b)-map.get(a));
        for(char c:map.keySet()){
            maxHeap.add(c);
        }



        StringBuilder sb=new StringBuilder();
        while(maxHeap.size()>1){
            char first=maxHeap.poll();
            char second=maxHeap.poll();

            sb.append(first);
            sb.append(second);

            map.put(first, map.get(first)-1);
            map.put(second, map.get(second)-1);


            if(map.get(first)>0){
                maxHeap.add(first);
            }

            if(map.get(second)>0){
                maxHeap.add(second);
            }
        }

        while(!maxHeap.isEmpty()){
            char f=maxHeap.poll();
            System.out.println(f +""+map.get(f));
            if(map.get(f)==1)
            {
                sb.append(f);
            }else{
                return "";
            }
        }
        return sb.toString();
    }
}