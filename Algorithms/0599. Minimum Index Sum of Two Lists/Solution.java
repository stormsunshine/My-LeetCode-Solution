class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int length1 = list1.length, length2 = list2.length;
        int leastIndexSum = Integer.MAX_VALUE;
        Map<String, Integer> list1Map = new HashMap<String, Integer>();
        Map<Integer, List<String>> indexSumInterestMap = new HashMap<Integer, List<String>>();
        for (int i = 0; i < length1; i++)
            list1Map.put(list1[i], i);
        for (int i = 0; i < length2; i++) {
            String interest = list2[i];
            if (!list1Map.containsKey(interest))
                continue;
            int indexSum = list1Map.get(interest) + i;
            List<String> interests = indexSumInterestMap.getOrDefault(indexSum, new ArrayList<String>());
            interests.add(interest);
            indexSumInterestMap.put(indexSum, interests);
            if (indexSum < leastIndexSum)
                leastIndexSum = indexSum;
        }
        List<String> interestsList = indexSumInterestMap.getOrDefault(leastIndexSum, new ArrayList<String>());
        int length = interestsList.size();
        String[] interests = new String[length];
        for (int i = 0; i < length; i++)
            interests[i] = interestsList.get(i);
        return interests;
    }
}