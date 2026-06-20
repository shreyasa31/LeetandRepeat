class Twitter {
HashMap<Integer, List<int[]>> posts;
int timestamp;
HashMap<Integer, Set<Integer>> followers;
    public Twitter() {
        posts=new HashMap<>();
        followers=new HashMap<>();
        timestamp=0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if(posts.containsKey(userId)){
            posts.get(userId).add(new int[]{timestamp++, tweetId});
        }else{
            posts.put(userId, new ArrayList<>());
            posts.get(userId).add(new int[]{timestamp++, tweetId});
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> maxHeap=new PriorityQueue<>((a,b)->b[0]-a[0]);
        Set<Integer> res= followers.getOrDefault(userId, new HashSet<>());
        res.add(userId);
        for(Integer f: res ){
            List<int[]> postsbyfollows=posts.getOrDefault(f, new ArrayList<>());
            maxHeap.addAll(postsbyfollows);
        }
        ArrayList<Integer> result=new ArrayList<>();
        while(!maxHeap.isEmpty() && result.size()<10){
            int[] a=maxHeap.poll();
            result.add(a[1]);

        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!followers.containsKey(followerId)){
             followers.put(followerId, new HashSet<>());
            followers.get(followerId).add(followeeId);
           
        }else{
             followers.get(followerId).add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followers.containsKey(followerId)){
            followers.get(followerId).remove(followeeId);
        }

        
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */