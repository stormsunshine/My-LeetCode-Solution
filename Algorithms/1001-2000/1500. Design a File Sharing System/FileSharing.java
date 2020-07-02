class FileSharing {
    Map<Integer, Set<Integer>> chunkUsersMap;
    Map<Integer, Set<Integer>> userChunksMap;
    PriorityQueue<Integer> userQueue;
    int maxUser;

    public FileSharing(int m) {
        chunkUsersMap = new HashMap<Integer, Set<Integer>>();
        userChunksMap = new HashMap<Integer, Set<Integer>>();
        userQueue = new PriorityQueue<Integer>();
        maxUser = 0;
    }
    
    public int join(List<Integer> ownedChunks) {
        int userID = 0;
        if (userQueue.isEmpty()) {
            maxUser++;
            userID = maxUser;
        } else
            userID = userQueue.poll();
        for (int chunk : ownedChunks) {
            Set<Integer> users = chunkUsersMap.getOrDefault(chunk, new TreeSet<Integer>());
            users.add(userID);
            chunkUsersMap.put(chunk, users);
        }
        userChunksMap.put(userID, new HashSet<Integer>(ownedChunks));
        return userID;
    }
    
    public void leave(int userID) {
        if (userChunksMap.containsKey(userID)) {
            Set<Integer> chunks = userChunksMap.get(userID);
            for (int chunk : chunks) {
                if (chunkUsersMap.containsKey(chunk)) {
                    Set<Integer> users = chunkUsersMap.get(chunk);
                    users.remove(userID);
                    if (users.size() > 0)
                        chunkUsersMap.put(chunk, users);
                    else
                        chunkUsersMap.remove(chunk);
                }
            }
            userChunksMap.remove(userID);
        }
        userQueue.add(userID);
    }
    
    public List<Integer> request(int userID, int chunkID) {
        List<Integer> usersList = new ArrayList<Integer>();
        if (!chunkUsersMap.containsKey(chunkID) || !userChunksMap.containsKey(userID))
            return usersList;
        usersList.addAll(chunkUsersMap.get(chunkID));
        Set<Integer> users = chunkUsersMap.get(chunkID);
        users.add(userID);
        chunkUsersMap.put(chunkID, users);
        Set<Integer> chunks = userChunksMap.get(userID);
        chunks.add(chunkID);
        userChunksMap.put(userID, chunks);
        return usersList;
    }
}

/**
 * Your FileSharing object will be instantiated and called as such:
 * FileSharing obj = new FileSharing(m);
 * int param_1 = obj.join(ownedChunks);
 * obj.leave(userID);
 * List<Integer> param_3 = obj.request(userID,chunkID);
 */