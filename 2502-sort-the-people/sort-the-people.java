class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
       TreeMap<Integer, String> map=new TreeMap<>();
       int i=0;
       String[] result=new String[names.length];
       for(int num:heights){
           map.put(num, names[i]);
           i++;
       } 
    //    System.out.println(map);
       int j=result.length-1;
       for(int num:map.keySet()){
            result[j]=map.get(num);
            j--;
       }
       return result;
    }
}