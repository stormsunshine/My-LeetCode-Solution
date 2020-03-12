class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        Map<Integer, Set<Integer>> poorerMap = new HashMap<Integer, Set<Integer>>();
        Set<Integer> set = new HashSet<Integer>();
        for (int[] curRicher : richer) {
            int person1 = curRicher[0], person2 = curRicher[1];
            Set<Integer> poorerSet = poorerMap.getOrDefault(person1, new HashSet<Integer>());
            poorerSet.add(person2);
            poorerMap.put(person1, poorerSet);
            set.add(person1);
            set.remove(person2);
        }
        int length = quiet.length;
        int[] answer = new int[length];
        for (int i = 0; i < length; i++)
            answer[i] = i;
        while (!set.isEmpty()) {
            Set<Integer> prevSet = new HashSet<Integer>(set);
            set.clear();
            for (int person1 : prevSet) {
                int answer1 = answer[person1];
                Set<Integer> poorerSet = poorerMap.getOrDefault(person1, new HashSet<Integer>());
                for (int person2 : poorerSet) {
                    int answer2 = answer[person2];
                    if (quiet[answer1] < quiet[answer2])
                        answer[person2] = answer[person1];
                    set.add(person2);
                }
            }
        }
        return answer;
    }
}