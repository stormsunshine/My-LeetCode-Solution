class Solution {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int length = arr.length;
        int avg = target / length;
        if (target % length * 2 > length)
            avg++;
        if (avg <= arr[0])
            return avg;
        int remainSum = target;
        int index = 0;
        while (avg > arr[index]) {
            remainSum -= arr[index];
            index++;
            int curLength = length - index;
            avg = remainSum / curLength;
            if (remainSum % curLength * 2 > curLength)
                avg++;
        }
        return avg;
    }
}