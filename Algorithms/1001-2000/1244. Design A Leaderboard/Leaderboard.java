class Leaderboard {
    List<Integer> playerIDs;
    List<Integer> scores;
    int size;

    public Leaderboard() {
        playerIDs = new ArrayList<Integer>();
        scores = new ArrayList<Integer>();
        size = 0;
    }
    
    public void addScore(int playerId, int score) {
        if (size == 0) {
            playerIDs.add(playerId);
            scores.add(score);
        } else {
            int idIndex = playerIDs.indexOf(playerId);
            if (idIndex >= 0) {
                int newScore = scores.get(idIndex) + score;
                playerIDs.remove(idIndex);
                scores.remove(idIndex);
                int index = binarySearch(scores, newScore);
                if (index < 0)
                    index = -index - 1;
                playerIDs.add(index, playerId);
                scores.add(index, newScore);
            } else {
                int index = binarySearch(scores, score);
                if (index < 0)
                    index = -index - 1;
                playerIDs.add(index, playerId);
                scores.add(index, score);
            }
        }
        size++;
    }
    
    public int top(int K) {
        K = Math.min(K, size);
        int sum = 0;
        for (int i = 0; i < K; i++)
            sum += scores.get(i);
        return sum;
    }
    
    public void reset(int playerId) {
        int index = playerIDs.indexOf(playerId);
        playerIDs.remove(index);
        scores.remove(index);
        size--;
    }

    public int binarySearch(List<Integer> list, int key) {
        int size = list.size();
        int low = 0, high = size - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int num = list.get(mid);
            if (num == key)
                return mid;
            else if (num > key)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -low - 1;
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */