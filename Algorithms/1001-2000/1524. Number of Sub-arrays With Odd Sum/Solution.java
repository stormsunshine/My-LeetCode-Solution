class Solution {
    public int numOfSubarrays(int[] arr) {
        final int MODULO = 1000000007;
        List<Integer> oddIndicesDifferences = new ArrayList<Integer>();
        int prev = -1;
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            if (arr[i] % 2 == 1) {
                oddIndicesDifferences.add(i - prev);
                prev = i;
            }
        }
        oddIndicesDifferences.add(length - prev);
        int size = oddIndicesDifferences.size();
        long evenIndicesSum = 0, oddIndicesSum = 0;
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0)
                evenIndicesSum += oddIndicesDifferences.get(i);
            else
                oddIndicesSum += oddIndicesDifferences.get(i);
        }
        int subarrays = (int) (evenIndicesSum * oddIndicesSum % MODULO);
        return subarrays;
    }
}