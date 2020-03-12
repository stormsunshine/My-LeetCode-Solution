class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDifference = Integer.MAX_VALUE;
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            int difference = arr[i] - arr[i - 1];
            minDifference = Math.min(minDifference, difference);
        }
        List<List<Integer>> pairs = new ArrayList<List<Integer>>();
        for (int i = 1; i < length; i++) {
            int difference = arr[i] - arr[i - 1];
            if (difference == minDifference) {
                List<Integer> pair = new ArrayList<Integer>();
                pair.add(arr[i - 1]);
                pair.add(arr[i]);
                pairs.add(pair);
            }
        }
        return pairs;
    }
}