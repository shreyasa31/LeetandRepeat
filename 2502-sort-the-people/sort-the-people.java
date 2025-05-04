class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        TreeMap<Integer, String> map = new TreeMap<>();//here all operations logn //also can use Collection.reverseOrder()
        int i = 0;
        String[] result = new String[names.length];
        for (int num : heights) {
            map.put(num, names[i]);
            i++;
        }

        int j = result.length - 1;
        for (int num : map.keySet()) { //so overall n logn solution 
            result[j] = map.get(num);
            j--;
        }
        return result;
    }
}