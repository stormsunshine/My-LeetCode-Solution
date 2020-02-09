class TweetCounts {
    Map<String, List<Integer>> tweetTimesMap;

    public TweetCounts() {
        tweetTimesMap = new HashMap<String, List<Integer>>();
    }
    
    public void recordTweet(String tweetName, int time) {
        if (!tweetTimesMap.containsKey(tweetName))
            tweetTimesMap.put(tweetName, new ArrayList<Integer>());
        tweetTimesMap.get(tweetName).add(time);
    }
    
    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        List<Integer> countsList = new ArrayList<Integer>();
        List<Integer> timesList = tweetTimesMap.getOrDefault(tweetName, new LinkedList<Integer>());
        Collections.sort(timesList);
        int interval = "minute".equals(freq) ? 60 : "hour".equals(freq) ? 3600 : 86400;
        int curStart = startTime;
        int size = timesList.size();
        while (curStart < endTime + 1) {
            int nextStart = Math.min(endTime + 1, curStart + interval);
            int low1 = 0, high1 = size;
            while (low1 < high1) {
                int mid = (low1 + high1) >> 1;
                if (timesList.get(mid) >= curStart)
                    high1 = mid;
                else
                    low1 = mid + 1;
            }
            int low2 = -1, high2 = size - 1;
            while (low2 < high2) {
                int mid = (low2 + high2 + 1) >> 1;
                if (timesList.get(mid) >= nextStart)
                    high2 = mid - 1;
                else
                    low2 = mid;
            }
            int count = low2 - low1 + 1;
            countsList.add(count);
            curStart = nextStart;
        }
        return countsList;
    }
}

/**
 * Your TweetCounts object will be instantiated and called as such:
 * TweetCounts obj = new TweetCounts();
 * obj.recordTweet(tweetName,time);
 * List<Integer> param_2 = obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
 */