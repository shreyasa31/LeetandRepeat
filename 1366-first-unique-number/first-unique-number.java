class FirstUnique {
    Queue<Integer> queue;
    LinkedHashMap<Integer, Integer> map;
    public FirstUnique(int[] nums) {
        queue=new LinkedList<>();
        map=new LinkedHashMap<>();
        for(int i=0;i<nums.length;i++){
            queue.add(nums[i]);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
    }
    
    public int showFirstUnique() {
        for(int n: map.keySet()){
           if(map.get(n)==1){
            return n;
           }
        }
        return -1;
    }
    
    public void add(int value) {
        queue.add(value);
        map.put(value, map.getOrDefault(value, 0)+1);
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */