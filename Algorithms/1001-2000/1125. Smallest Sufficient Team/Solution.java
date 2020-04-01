class Solution {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int skills = req_skills.length, peopleCount = people.size();
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < skills; i++)
            map.put(req_skills[i], i);
        int[] masks = new int[peopleCount];
        for (int i = 0; i < peopleCount; i++)
            masks[i] = getMask(people.get(i), map);
        int[] dp = new int[1 << skills];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int[] prevState = new int[1 << skills];
        int[] prevPerson = new int[1 << skills];
        for (int i = 0; i < peopleCount; i++) {
            int mask = masks[i];
            for (int j = (1 << skills) - 1; j >= 0; j--) {
                if (dp[j] != Integer.MAX_VALUE) {
                    int newState = j | mask;
                    if (dp[newState] > dp[j] + 1) {
                        dp[newState] = dp[j] + 1;
                        prevState[newState] = j;
                        prevPerson[newState] = i;
                    }
                }
            }
        }
        List<Integer> teamList = new ArrayList<Integer>();
        int state = (1 << skills) - 1;
        while (state > 0) {
            teamList.add(prevPerson[state]);
            state = prevState[state];
        }
        int teamSize = teamList.size();
        int[] teamArray = new int[teamSize];
        for (int i = 0; i < teamSize; i++)
            teamArray[i] = teamList.get(teamSize - 1 - i);
        return teamArray;
    }

    public int getMask(List<String> list, Map<String, Integer> map) {
        int mask = 0;
        for (String skill : list) {
            if (map.containsKey(skill))
                mask |= 1 << map.get(skill);
        }
        return mask;
    }
}