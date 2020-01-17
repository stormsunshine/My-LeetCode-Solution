class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int heatersLength = heaters.length;
        int minRadius = 0;
        for (int house : houses) {
            int index = binarySearch(heaters, house);
            if (index >= 0)
                continue;
            index = -index - 1;
            if (index == 0) {
                int curRadius = heaters[index] - house;
                minRadius = Math.max(minRadius, curRadius);
            } else if (index >= heatersLength) {
                int curRadius = house - heaters[heatersLength - 1];
                minRadius = Math.max(minRadius, curRadius);
            } else {
                int heater1 = heaters[index - 1], heater2 = heaters[index];
                int curRadius = Math.min(house - heater1, heater2 - house);
                minRadius = Math.max(minRadius, curRadius);
            }
        }
        return minRadius;
    }

    public int binarySearch(int[] array, int key) {
        int low = 0, high = array.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int num = array[mid];
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