class Solution {
    public int[] shortestToChar(String S, char C) {
        int length = S.length();
        int[] distances = new int[length];
        List<Integer> indices = new ArrayList<Integer>();
        for (int i = 0; i < length; i++) {
            if (S.charAt(i) == C)
                indices.add(i);
        }
        int size = indices.size();
        int pointer = 0;
        for (int i = 0; i < length; i++) {
            if (indices.contains(i)) {
                distances[i] = 0;
                pointer++;
            } else {
                if (pointer == 0) {
                    int curIndex = indices.get(pointer);
                    distances[i] = Math.abs(curIndex - i);
                } else if (pointer == size) {
                    int prevIndex = indices.get(pointer - 1);
                    distances[i] = Math.abs(i - prevIndex);
                } else {
                    int prevIndex = indices.get(pointer - 1), curIndex = indices.get(pointer);
                    distances[i] = Math.min(Math.abs(i - prevIndex), Math.abs(curIndex - i));
                }
            }
        }
        return distances;
    }
}