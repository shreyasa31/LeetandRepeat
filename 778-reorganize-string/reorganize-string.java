class Solution {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> map=new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        PriorityQueue<Character> maxHeap=new PriorityQueue<>((a,b)-> map.get(b)-map.get(a));
        StringBuilder sb=new StringBuilder();
        for(char c:map.keySet()){
            maxHeap.add(c);
        }
        while(maxHeap.size()>1){
            char first=maxHeap.poll();
            char sec=maxHeap.poll();
            sb.append(first);
            sb.append(sec);

            map.put(first, map.get(first)-1);
             map.put(sec, map.get(sec)-1);

             if(map.get(first)>0){
                maxHeap.add(first);
             }

              if(map.get(sec)>0){
                maxHeap.add(sec);
             }



        }
        while(!maxHeap.isEmpty()){
            if(map.get(maxHeap.peek())==1){
                sb.append(maxHeap.poll());
            }else{
                return "";
            }
        }
        return sb.toString();
    }
}