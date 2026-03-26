class Solution {
    class Pair{
        String word;
        int val;
        Pair(String word, int val){
            this.word=word;
            this.val=val;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> set=new HashSet<>();
        for(String i: wordList){
            set.add(i);
        }
        
        Queue<Pair> queue=new LinkedList<>();
        queue.add(new Pair(beginWord,1));

        while(!queue.isEmpty()){
            Pair curr=queue.poll();
            String w=curr.word;
            int steps=curr.val;
            if(w.equals(endWord)){
                return steps;
            }
            for(int i=0;i<w.length();i++){
                char[] arr=w.toCharArray();

                for(char ch='a'; ch<='z';ch++){
                    arr[i]=ch;
                    String s=new String(arr);

                    if(set.contains(s)){
                        set.remove(s);
                        queue.add(new Pair(s, steps+1));
                    }

                }
            }
        }

      return 0;
    }
}