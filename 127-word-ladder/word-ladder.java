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
        for(String i: wordList){ // N
            set.add(i);
        }
        
        Queue<Pair> queue=new LinkedList<>();
        queue.add(new Pair(beginWord,1));

        while(!queue.isEmpty()){ //N
            Pair curr=queue.poll();
            String w=curr.word;
            int steps=curr.val;
            if(w.equals(endWord)){
                return steps;
            }
            for(int i=0;i<w.length();i++){ //L
                char[] arr=w.toCharArray();

                for(char ch='a'; ch<='z';ch++){ //26
                    arr[i]=ch;
                    String s=new String(arr); // L

                    if(set.contains(s)){
                        set.remove(s); //O(1)
                        queue.add(new Pair(s, steps+1)); //O(1)
                    }

                }
            }
        }

      return 0;
    }
}

//N*L*26*L= N*L square