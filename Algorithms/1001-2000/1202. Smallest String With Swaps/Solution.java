class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        Map<Integer, Set<Integer>> adjacentMap = new HashMap<Integer, Set<Integer>>();
        for (List<Integer> pair : pairs) {
            int index1 = pair.get(0), index2 = pair.get(1);
            Set<Integer> set1 = adjacentMap.getOrDefault(index1, new HashSet<Integer>());
            Set<Integer> set2 = adjacentMap.getOrDefault(index2, new HashSet<Integer>());
            set1.add(index2);
            set2.add(index1);
            adjacentMap.put(index1, set1);
            adjacentMap.put(index2, set2);
        }
        char[] array = s.toCharArray();
        int length = array.length;
        int[] groups = new int[length];
        Arrays.fill(groups, -1);
        Map<Integer, Set<Integer>> groupNumsMap = new HashMap<Integer, Set<Integer>>();
        int groupNum = 0;
        int ungrouped = length;
        Queue<Integer> queue = new LinkedList<Integer>();
        int startIndex = 0;
        while (ungrouped > 0) {
            while (startIndex < length && groups[startIndex] >= 0)
                startIndex++;
            if (startIndex < length)
                queue.offer(startIndex);
            Set<Integer> groupSet = new HashSet<Integer>();
            while (!queue.isEmpty()) {
                int index = queue.poll();
                if (groups[index] < 0) {
                    groups[index] = groupNum;
                    groupSet.add(index);
                    ungrouped--;
                    Set<Integer> adjacentSet = adjacentMap.getOrDefault(index, new HashSet<Integer>());
                    for (int adjacent : adjacentSet) {
                        if (groups[adjacent] < 0)
                            queue.offer(adjacent);
                    }
                }
            }
            groupNumsMap.put(groupNum, groupSet);
            groupNum++;
            startIndex++;
        }
        boolean[] sorted = new boolean[length];
        for (int i = 0; i < length; i++) {
            if (!sorted[i]) {
                int group = groups[i];
                if (group >= 0) {
                    List<Integer> indicesList = new ArrayList<Integer>(groupNumsMap.get(group));
                    Collections.sort(indicesList);
                    StringBuffer sb = new StringBuffer();
                    for (int index : indicesList)
                        sb.append(array[index]);
                    char[] subsequence = sb.toString().toCharArray();
                    Arrays.sort(subsequence);
                    int size = indicesList.size();
                    for (int j = 0; j < size; j++) {
                        int index = indicesList.get(j);
                        array[index] = subsequence[j];
                        sorted[index] = true;
                    }
                }
            }
        }
        return new String(array);
    }
}