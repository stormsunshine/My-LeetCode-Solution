class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        if (seqs == null)
            return org == null;
        if (seqs.size() == 0)
            return org.length == 0;
        Map<Integer, Integer> numIndexMap = new HashMap<Integer, Integer>();
        int length = org.length;
        for (int i = 0; i < length; i++)
            numIndexMap.put(org[i], i);
        boolean[] adjacentSequences = new boolean[length - 1];
        Set<Integer> set = new HashSet<Integer>();
        for (List<Integer> sequence : seqs) {
            for (int num : sequence) {
                if (num > length)
                    return false;
                else
                    set.add(num);
            }
            int size = sequence.size();
            for (int i = 1; i < size; i++) {
                int num1 = sequence.get(i - 1), num2 = sequence.get(i);
                int index1 = numIndexMap.getOrDefault(num1, -1);
                int index2 = numIndexMap.getOrDefault(num2, -1);
                if (index1 < 0 || index2 < 0 || index1 >= index2)
                    return false;
                if (index2 - index1 == 1)
                    adjacentSequences[index1] = true;
            }
        }
        if (set.size() < length)
            return false;
        for (boolean adjacentSequence : adjacentSequences) {
            if (!adjacentSequence)
                return false;
        }
        return true;
    }
}