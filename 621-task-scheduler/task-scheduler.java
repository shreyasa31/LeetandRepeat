class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map=new HashMap<>();

        for(char c: tasks){
            map.put(c, map.getOrDefault(c, 0)+1);

        }

        int maxFreq=0;
        for(char c:map.keySet()){
            maxFreq=Math.max(maxFreq, map.get(c));
        }
        int count=0;
        for(char c: map.keySet()){
            if(map.get(c)==maxFreq) count++;
        }

        int interval= (maxFreq-1)*(n+1)+count;

        return Math.max(tasks.length, interval);
    }
}