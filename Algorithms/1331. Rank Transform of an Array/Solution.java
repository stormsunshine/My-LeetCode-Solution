class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : arr)
            set.add(num);
        List<Integer> list = new ArrayList<Integer>();
        for (int num : set)
            list.add(num);
        Collections.sort(list);
        Map<Integer, Integer> numRankMap = new HashMap<Integer, Integer>();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int num = list.get(i);
            numRankMap.put(num, i + 1);
        }
        int length = arr.length;
        int[] ranks = new int[length];
        for (int i = 0; i < length; i++) {
            int num = arr[i];
            int rank = numRankMap.get(num);
            ranks[i] = rank;
        }
        return ranks;
    }
}