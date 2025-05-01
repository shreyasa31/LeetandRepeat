class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> set=new HashSet<>();
        for(char c1:jewels.toCharArray())
        {
            set.add(c1);
        }
        int count=0;
        for(char c:stones.toCharArray()){
              if(set.contains(c)){
                   count++;
              }
        }
        return count;
    }
}