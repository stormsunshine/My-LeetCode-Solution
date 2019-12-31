class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> sizePeopleMap = new HashMap<Integer, List<Integer>>();
        int length = groupSizes.length;
        for (int i = 0; i < length; i++) {
            int groupSize = groupSizes[i];
            List<Integer> people = sizePeopleMap.getOrDefault(groupSize, new ArrayList<Integer>());
            people.add(i);
            sizePeopleMap.put(groupSize, people);
        }
        List<List<Integer>> groups = new ArrayList<List<Integer>>();
        Set<Integer> keySet = sizePeopleMap.keySet();
        for (int groupSize : keySet) {
            List<Integer> people = sizePeopleMap.get(groupSize);
            int size = people.size();
            if (size == groupSize)
                groups.add(people);
            else {
                int groupsCount = size / groupSize;
                for (int i = 0; i < groupsCount; i++) {
                    List<Integer> group = new ArrayList<Integer>();
                    int start = i * groupSize, end = (i + 1) * groupSize - 1;
                    for (int j = start; j <= end; j++)
                        group.add(people.get(j));
                    groups.add(group);
                }
            }
        }
        return groups;
    }
}