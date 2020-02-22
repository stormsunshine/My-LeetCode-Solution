class Solution {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        Map<Integer, Integer> ageCountMap = new HashMap<Integer, Integer>();
        for (int age : ages) {
            int count = ageCountMap.getOrDefault(age, 0) + 1;
            ageCountMap.put(age, count);
        }
        int friendRequests = 0;
        int length = ages.length;
        for (int i = 0; i < length; i++) {
            if (i > 0 && ages[i] == ages[i - 1])
                continue;
            int age = ages[i];
            int minAge = age / 2 + 8;
            if (minAge > age)
                continue;
            int minIndex = binarySearch(ages, minAge);
            int count = ageCountMap.get(age);
            friendRequests += count * (i - minIndex);
            friendRequests += count * (count - 1);
        }
        return friendRequests;
    }

    public int binarySearch(int[] ages, int minAge) {
        int low = 0, high = ages.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            int age = ages[mid];
            if (age < minAge)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
}