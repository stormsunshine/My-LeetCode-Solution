class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        List<Integer> indices1 = new ArrayList<Integer>();
        List<Integer> indices2 = new ArrayList<Integer>();
        int length = words.length;
        for (int i = 0; i < length; i++) {
            String word = words[i];
            if (word.equals(word1))
                indices1.add(i);
            if (word.equals(word2))
                indices2.add(i);
        }
        int shortestDistance = Integer.MAX_VALUE;
        for (int index1 : indices1) {
            for (int index2 : indices2) {
                int distance = Math.abs(index1 - index2);
                shortestDistance = Math.min(shortestDistance, distance);
                if (index2 > index1 && distance >= shortestDistance)
                    break;
            }
        }
        return shortestDistance;
    }
}