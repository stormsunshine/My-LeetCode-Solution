class Solution {
    public int kSimilarity(String A, String B) {
        if (A.equals(B))
            return 0;
        int length = A.length();
        StringBuffer sbA = new StringBuffer();
        StringBuffer sbB = new StringBuffer();
        for (int i = 0; i < length; i++) {
            char cA = A.charAt(i), cB = B.charAt(i);
            if (cA != cB) {
                sbA.append(cA);
                sbB.append(cB);
            }
        }
        String strA = sbA.toString();
        String strB = sbB.toString();
        int swaps = 0;
        Set<String> set = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.offer(strA);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                if (str.equals(strB))
                    return swaps;
                List<String> neighbors = getNeighbors(str, strB);
                for (String neighbor : neighbors) {
                    if (set.add(neighbor))
                        queue.offer(neighbor);
                }
            }
            swaps++;
        }
        return -1;
    }

    public List<String> getNeighbors(String str, String target) {
        int length = str.length();
        int startIndex = -1;
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) != target.charAt(i)) {
                startIndex = i;
                break;
            }
        }
        List<String> neighbors = new ArrayList<String>();
        if (startIndex < 0)
            return neighbors;
        char[] array = str.toCharArray();
        char targetC = target.charAt(startIndex);
        for (int i = startIndex + 1; i < length; i++) {
            if (array[i] == targetC) {
                swap(array, startIndex, i);
                neighbors.add(new String(array));
                swap(array, startIndex, i);
            }
        }
        return neighbors;
    }

    public void swap(char[] array, int index1, int index2) {
        char temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}