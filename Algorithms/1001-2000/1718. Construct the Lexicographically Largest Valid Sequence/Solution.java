class Solution {
    public int[] constructDistancedSequence(int n) {
        int length = n * 2 - 1;
        int[] sequence = new int[length];
        Set<Integer> visited = new HashSet<Integer>();
        backtrack(sequence, visited, 0, n, length);
        return sequence;
    }

    public boolean backtrack(int[] sequence, Set<Integer> visited, int start, int n, int length) {
        if (visited.size() == n)
            return true;
        if (sequence[start] > 0)
            return backtrack(sequence, visited, start + 1, n, length);
        for (int i = n; i > 0; i--) {
            if (!visited.contains(i)) {
                int next = start + i;
                if (i == 1 || next < length && sequence[next] == 0) {
                    sequence[start] = i;
                    if (i > 1)
                        sequence[next] = i;
                    visited.add(i);
                    if (backtrack(sequence, visited, start + 1, n, length))
                        return true;
                    sequence[start] = 0;
                    if (i > 1)
                        sequence[next] = 0;
                    visited.remove(i);
                }
            }
        }
        return false;
    }
}