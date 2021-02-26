class Solution {
    public String[] sortFeatures(String[] features, String[] responses) {
        Map<String, Integer> indicesMap = new HashMap<String, Integer>();
        int featuresCount = features.length;
        for (int i = 0; i < featuresCount; i++)
            indicesMap.put(features[i], i);
        Map<String, Integer> appearancesMap = new HashMap<String, Integer>();
        int length = responses.length;
        for (int i = 0; i < length; i++) {
            String response = responses[i];
            String[] array = response.split(" ");
            Set<String> set = new HashSet<String>();
            for (String word : array)
                set.add(word);
            for (String feature : features) {
                if (set.contains(feature)) {
                    int count = appearancesMap.getOrDefault(feature, 0) + 1;
                    appearancesMap.put(feature, count);
                }
            }
        }
        Arrays.sort(features, new Comparator<String>() {
            public int compare(String str1, String str2) {
                int appearances1 = appearancesMap.getOrDefault(str1, 0);
                int appearances2 = appearancesMap.getOrDefault(str2, 0);
                if (appearances1 != appearances2)
                    return appearances2 - appearances1;
                else
                    return indicesMap.get(str1) - indicesMap.get(str2);
            }
        });
        return features;
    }
}