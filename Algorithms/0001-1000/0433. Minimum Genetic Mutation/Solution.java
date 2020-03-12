class Solution {
    public int minMutation(String start, String end, String[] bank) {
        int length = start.length();
        char[] chars = {'A', 'C', 'G', 'T'};
        Set<String> bankSet = new HashSet<String>();
        for (String str : bank)
            bankSet.add(str);
        Set<String> visitedSet = new HashSet<String>();
        visitedSet.add(start);
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        int mutations = 0;
        while (!queue.isEmpty()) {
            mutations++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                for (int j = 0; j < length; j++) {
                    char[] array = str.toCharArray();
                    char c = array[j];
                    for (char candidate : chars) {
                        if (candidate != c) {
                            array[j] = candidate;
                            String newStr = new String(array);
                            if (bankSet.contains(newStr)) {
                                if (newStr.equals(end))
                                    return mutations;
                                else if (visitedSet.add(newStr))
                                    queue.offer(newStr);
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }
}