class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set=new HashSet<>();
        for(String s: wordList){
             set.add(s);
        }

        Queue<Pair<String, Integer>> queue=new LinkedList<>();
        queue.add(new Pair<>(beginWord,0));

        while(!queue.isEmpty()){
            Pair curr=queue.poll();
            String word=curr.getKey().toString();
            int d=(int)curr.getValue();
            if(word.equals(endWord)) return d+1;
            for(int i=0;i<word.length();i++){
                char[] arr=word.toCharArray();

                for(char c='a';c<='z';c++){
                    arr[i]=c;

                    String s=new String(arr);
                    if(set.contains(s)){
                        set.remove(s);
                        queue.add(new Pair<>(s, d+1));
                    }
                }
            }
        }
        return 0;
    }
}