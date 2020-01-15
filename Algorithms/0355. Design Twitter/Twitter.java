class Twitter {
    Map<Integer, List<int[]>> userTweetMap;
    Map<Integer, List<Integer>> userFollowMap;
    int tweetCount;

    /** Initialize your data structure here. */
    public Twitter() {
        userTweetMap = new HashMap<Integer, List<int[]>>();
        userFollowMap = new HashMap<Integer, List<Integer>>();
        tweetCount = 0;
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        List<int[]> tweets = userTweetMap.getOrDefault(userId, new ArrayList<int[]>());
        tweets.add(new int[]{tweetId, ++tweetCount});
        userTweetMap.put(userId, tweets);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<int[]> allTweets = new ArrayList<int[]>();
        allTweets.addAll(userTweetMap.getOrDefault(userId, new ArrayList<int[]>()));
        List<Integer> followees = userFollowMap.getOrDefault(userId, new ArrayList<Integer>());
        for (int followee : followees)
            allTweets.addAll(userTweetMap.getOrDefault(followee, new ArrayList<int[]>()));
        Collections.sort(allTweets, new Comparator<int[]>() {
            public int compare(int[] tweet1, int[] tweet2) {
                return tweet1[1] - tweet2[1];
            }
        });
        List<Integer> newsFeed = new ArrayList<Integer>();
        int size = allTweets.size();
        int maxCount = Math.min(10, size);
        for (int i = 1; i <= maxCount; i++)
            newsFeed.add(allTweets.get(size - i)[0]);
        return newsFeed;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followerId != followeeId) {
            List<Integer> followees = userFollowMap.getOrDefault(followerId, new ArrayList<Integer>());
            if (!followees.contains(followeeId)) {
                followees.add(followeeId);
                userFollowMap.put(followerId, followees);
            }
        }
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followerId != followeeId) {
            List<Integer> followees = userFollowMap.getOrDefault(followerId, new ArrayList<Integer>());
            if (followees.contains(followeeId)) {
                followees.remove(new Integer(followeeId));
                userFollowMap.put(followerId, followees);
            }
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