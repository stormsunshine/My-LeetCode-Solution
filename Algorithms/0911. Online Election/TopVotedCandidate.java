class TopVotedCandidate {
    TreeMap<Integer, Integer> timeWinningMap = new TreeMap<Integer, Integer>();

    public TopVotedCandidate(int[] persons, int[] times) {
        Map<Integer, Integer> personVotesMap = new HashMap<Integer, Integer>();
        int maxVotes = 0;
        int maxPerson = -1;
        int length = persons.length;
        for (int i = 0; i < length; i++) {
            int person = persons[i];
            int time = times[i];
            int curVotes = personVotesMap.getOrDefault(person, 0) + 1;
            personVotesMap.put(person, curVotes);
            if (curVotes >= maxVotes) {
                maxVotes = curVotes;
                maxPerson = person;
            }
            timeWinningMap.put(time, maxPerson);
        }
    }
    
    public int q(int t) {
        int key = timeWinningMap.floorKey(t);
        int winning = timeWinningMap.get(key);
        return winning;
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */