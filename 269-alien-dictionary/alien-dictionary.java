class Solution {
    public String alienOrder(String[] words) {
        List<List<Integer>> adjList=new ArrayList<>();
        for(int i=0;i<26;i++)
        {
            adjList.add(new ArrayList<>());
        }

        boolean[] present=new boolean[26];
           for (String word : words) {
            for (char ch : word.toCharArray()) {
                present[ch - 'a'] = true;
            }
        }

        int[] indegree=new int[26];
            for(int i=0;i<words.length-1;i++){
            String word1=words[i];
            String word2=words[i+1];
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }
            int min=Math.min(word1.length(), word2.length());
            for(int j=0;j<min;j++){
                char c1=word1.charAt(j);
                char c2=word2.charAt(j);
               
                
                if(c1!=c2){
                      adjList.get(c1-'a').add(c2-'a');
                      indegree[c2-'a']++;
                      break;

                }
            }
        }int count=0;
        Queue<Integer> queue=new LinkedList<>();
        for(int k=0;k<indegree.length;k++){
            if(present[k]) count++;
            if(present[k] && indegree[k]==0){

                queue.add(k);
            }
        }
        int currCount=0;
       StringBuilder sb=new StringBuilder();
        while(!queue.isEmpty()){
            int curr=queue.poll();

            sb.append((char)(curr+'a'));
            currCount++;
            for(int i:adjList.get(curr)){
                indegree[i]--;
                if(indegree[i]==0 && present[i]){
                    queue.add(i);
                }
            }
        }
       if(currCount!=count) return "";
       return sb.toString();
    }
}