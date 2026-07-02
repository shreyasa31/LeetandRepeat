class Solution {
    public String alienOrder(String[] words) {
        int[] indegree=new int[26];
        boolean[] present=new boolean[26];
        ArrayList<List<Integer>> list=new ArrayList<>();
       for(int i=0;i<words.length;i++){
        for(int j=0;j<words[i].length();j++){
            present[words[i].charAt(j)-'a']=true;
        }
       }
        for(int i=0;i<26;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<words.length-1;i++){
           String first=words[i];
           String second=words[i+1];
           if(first.length()!=second.length() && first.startsWith(second)) return "";
           int min=Math.min(first.length(), second.length());
           for(int l=0;l<min;l++){
               char c= first.charAt(l);
               char c2=second.charAt(l);

               if(c!=c2){
                    // if (!list.get(c-'a').contains(c2-'a')) {
                        list.get(c-'a').add(c2-'a');
                        indegree[c2-'a']++;
                    // }
                     break;
               }
              
           }
           }
           int c=0;
           Queue<Integer> queue=new LinkedList<>();
           for(int i=0;i<indegree.length;i++){
               if(present[i] && indegree[i]==0){
                queue.add(i);
               }
               if(present[i]){
                c++;
               }
           }
           int count=0;
           StringBuilder s=new StringBuilder();
           while(!queue.isEmpty()){
            int curr=queue.poll();
            count++;
            s.append((char)(curr+'a'));
            for(int k: list.get(curr)){
                indegree[k]--;
                if(indegree[k]==0){
                    queue.add(k);
                }
            }
           }


        if(count!=c) return "";
        return s.toString();
    }
}