class AuthenticationManager {
    int timeToLive;
    Map<String, Integer> tokenTimeMap;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        tokenTimeMap = new HashMap<String, Integer>();
    }
    
    public void generate(String tokenId, int currentTime) {
        int endTime = currentTime + timeToLive;
        tokenTimeMap.put(tokenId, endTime);
    }
    
    public void renew(String tokenId, int currentTime) {
        int endTime = currentTime + timeToLive;
        if (tokenTimeMap.containsKey(tokenId) && tokenTimeMap.get(tokenId) > currentTime)
            tokenTimeMap.put(tokenId, endTime);
    }
    
    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        for (Map.Entry<String, Integer> entry : tokenTimeMap.entrySet()) {
            int time = entry.getValue();
            if (time > currentTime)
                count++;
        }
        return count;
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */