class WordDistance {
    Map<String, List<Integer>> wordIndicesMap;

    public WordDistance(String[] words) {
        wordIndicesMap = new HashMap<String, List<Integer>>();
        int length = words.length;
        for (int i = 0; i < length; i++) {
            String word = words[i];
            List<Integer> indices = wordIndicesMap.getOrDefault(word, new ArrayList<Integer>());
            indices.add(i);
            wordIndicesMap.put(word, indices);
        }
    }
    
    public int shortest(String word1, String word2) {
        int shortest = Integer.MAX_VALUE;
        List<Integer> indices1 = wordIndicesMap.get(word1);
        List<Integer> indices2 = wordIndicesMap.get(word2);
        int size1 = indices1.size(), size2 = indices2.size();
        for (int i = 0; i < size1; i++) {
            int index1 = indices1.get(i);
            int begin = shortest == Integer.MAX_VALUE ? 0 : binarySearch(indices2, index1 - shortest);
            if (begin < 0)
                begin = -begin - 1;
            for (int j = begin; j < size2; j++) {
                int index2 = indices2.get(j);
                int difference = Math.abs(index2 - index1);
                if (index2 > index1 && difference > shortest)
                    break;
                shortest = Math.min(shortest, difference);
            }
        }
        return shortest;
    }

    public int binarySearch(List<Integer> list, int key) {
        int low = 0, high = list.size() - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int num = list.get(mid);
            if (num == key)
                return mid;
            else if (num > key)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -low - 1;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */