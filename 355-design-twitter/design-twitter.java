class Twitter {

    // `followed`: This is a map where:
    // - The KEY is a `userId` (Integer) - this is the user who is doing the following.
    // - The VALUE is a `Set<Integer>` - this set contains all the `userId`s that the key user is following.
    //   Importantly, each user's own ID is added to their set initially, so they can see their own tweets.
    private Map<Integer, Set<Integer>> followed = new HashMap<>(); // Initialize the map immediately.

    // `tw`: This is a LinkedList that stores all the tweets posted in the system.
    // Each tweet is represented as an `int[]` array: `[userId, tweetId, timestamp]`.
    // Using `LinkedList` because `addFirst` (adding to the front) is very efficient (O(1)),
    // and iterating from the start naturally gives us tweets in reverse chronological order (newest first).
    private LinkedList<int[]> tw = new LinkedList<>(); // Initialize the linked list. `ts` will be used for timestamps.
    
    // `ts`: A simple counter that acts as a timestamp.
    // Every time a tweet is posted, `ts` is incremented, giving each tweet a unique, increasing timestamp.
    // This is crucial for sorting tweets chronologically.
    private int ts = 0; // Initialize the timestamp counter.
    
    /**
     * Posts a new tweet.
     * @param userId The ID of the user posting the tweet.
     * @param tweetId The ID of the tweet itself.
     */
    public void postTweet(int userId, int tweetId) {
        // Add the new tweet to the VERY FRONT of our `tw` LinkedList.
        // This ensures tweets are stored with the newest ones at the beginning.
        // The tweet data is stored as `[userId, tweetId, timestamp]`.
        // `ts++` increments the timestamp counter *after* using its current value for this tweet.
        tw.addFirst(new int[]{userId, tweetId, ts++});

        // Now, we need to make sure this `userId` has an entry in our `followed` map.
        // If a user posts a tweet for the first time, they might not be in the map yet.
        // `!followed.containsKey(userId)` checks if the user already has an entry.
        if (!followed.containsKey(userId)) {
            // If the user is NOT in the map, create a new entry for them.
            followed.put(userId, new HashSet<>()); // The value is a new, empty set for their followees.
            // Add the user's OWN ID to their follow list. This is important so that when they check their news feed,
            // their own tweets are included by default.
            followed.get(userId).add(userId);
        }
    }
    
    /**
     * Retrieves the news feed for a given user.
     * The feed contains tweets from the user and people they follow, sorted by recency.
     * @param userId The ID of the user whose news feed is requested.
     * @return A List of tweet IDs, showing up to the 10 most recent relevant tweets.
     */
    public List<Integer> getNewsFeed(int userId) {
        // `res` is an ArrayList that will store the tweet IDs to be returned in the news feed.
        List<Integer> res = new ArrayList<>();
        
        // First, check if the user exists in our `followed` map.
        // If they don't, it means they haven't posted or followed anyone, so they have no feed.
        if (!followed.containsKey(userId)) return res; // Return an empty list.

        // Get the Set of user IDs that `userId` is following. This set includes `userId` themselves.
        Set<Integer> followees = followed.get(userId);

        // Now, we iterate through ALL the tweets stored in our `tw` LinkedList.
        // Since `tw` is a LinkedList and we add tweets to the front, iterating from the beginning (`for (int[] tweet : tw)`)
        // means we process tweets from newest to oldest.
        for (int[] tweet : tw) {
            // `tweet[0]` is the userId of the person who posted this particular tweet.
            // `followees.contains(tweet[0])` checks if the user requesting the feed (`userId`) follows the author of this tweet.
            if (followees.contains(tweet[0])) {
                // If the user follows the author of this tweet (or it's their own tweet),
                // we add the tweet's ID (`tweet[1]`) to our result list.
                res.add(tweet[1]);
                // We only need to show the 10 most recent tweets in the feed.
                // So, if our result list `res` has reached a size of 10, we stop adding tweets.
                if (res.size() == 10) break; // Exit the loop early.
            }
        }

        // Return the list containing the IDs of the 10 most recent relevant tweets.
        return res;
    }
    
    /**
     * Makes `followerId` follow `followeeId`.
     * @param followerId The ID of the user who initiates the follow action.
     * @param followeeId The ID of the user being followed.
     */
    public void follow(int followerId, int followeeId) {
        // First, ensure the `followerId` has an entry in the `followed` map.
        // If not, create it and add the follower to their own follow list.
        if (!followed.containsKey(followerId)) {
            followed.put(followerId, new HashSet<>());
            followed.get(followerId).add(followerId); // User follows themselves by default.
        }
        // Add the `followeeId` to the `followerId`'s set of followed users.
        // `HashSet` handles duplicates, so if they already follow `followeeId`, nothing changes.
        followed.get(followerId).add(followeeId);
    }
    
    /**
     * Makes `followerId` unfollow `followeeId`.
     * @param followerId The ID of the user who is unfollowing.
     * @param followeeId The ID of the user being unfollowed.
     */
    public void unfollow(int followerId, int followeeId) {
        // Check two conditions:
        // 1. Does the `followerId` exist in our system? (i.e., are they in the `followed` map?)
        // 2. Is the `followerId` different from the `followeeId`? (A user doesn't unfollow themselves).
        if (followed.containsKey(followerId) && followerId != followeeId) {
            // If both conditions are true, remove the `followeeId` from the `followerId`'s set.
            // `HashSet.remove()` efficiently removes the element if it exists.
            followed.get(followerId).remove(followeeId);
        }
    }
}
