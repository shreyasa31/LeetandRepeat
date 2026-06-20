
class Pair{
    int freq;
    int value;
    Pair(int freq, int value){
        this.freq=freq;
        this.value=value;
    }

}





class LFUCache {


    HashMap<Integer, Pair> map;
    HashMap<Integer, LinkedHashSet<Integer>> freqMap;
    int minFreq; int size;
    public LFUCache(int capacity) {
        map=new HashMap<>();
        freqMap=new HashMap<>();
        minFreq=0;
        size=capacity;

    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Pair p=map.get(key);
        int f=p.freq;
        int val=p.value;
       
     
            LinkedHashSet<Integer> s=freqMap.get(f);
            s.remove(key);

            if(s.isEmpty()){
                freqMap.remove(f);

                if(f==minFreq){
                    minFreq++;
                }
            }
        
 
        f++;
        p.freq=f;
        if(!freqMap.containsKey(f)){
            freqMap.put(f, new LinkedHashSet<>());
        }
        LinkedHashSet<Integer> adding=freqMap.get(f);
        adding.add(key);
        return val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Pair pair=map.get(key);
            pair.value=value;
            get(key);
            return;
        }

        if(size==map.size()){
            LinkedHashSet<Integer> res=freqMap.get(minFreq);
            int removeKey=res.iterator().next();
            res.remove(removeKey);

            map.remove(removeKey);
            if(res.isEmpty()){
                freqMap.remove(minFreq);
            }
        }



        map.put(key, new Pair(1, value));
        freqMap.putIfAbsent(1, new LinkedHashSet<>());
        freqMap.get(1).add(key);
        minFreq=1;
    }
}