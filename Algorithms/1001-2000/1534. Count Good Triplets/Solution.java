class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int triplets = 0;
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int num1 = arr[i];
            for (int j = i + 1; j < length; j++) {
                int num2 = arr[j];
                if (Math.abs(num1 - num2) > a)
                    continue;
                for (int k = j + 1; k < length; k++) {
                    int num3 = arr[k];
                    if (Math.abs(num2 - num3) <= b && Math.abs(num1 - num3) <= c)
                        triplets++;
                }
            }
        }
        return triplets;
    }
}