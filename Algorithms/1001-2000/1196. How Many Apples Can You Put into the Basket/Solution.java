class Solution {
    public int maxNumberOfApples(int[] arr) {
        Arrays.sort(arr);
        int length = arr.length;
        final int CAPACITY = 5000;
        int totalWeight = 0;
        int count = 0;
        for (int i = 0; i < length; i++) {
            int weight = arr[i];
            if (totalWeight + weight <= CAPACITY) {
                totalWeight += weight;
                count++;
            } else
                break;
        }
        return count;
    }
}