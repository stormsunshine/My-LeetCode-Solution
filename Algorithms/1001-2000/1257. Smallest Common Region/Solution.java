class Solution {
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        Map<String, String> map = new HashMap<String, String>();
        for (List<String> list : regions) {
            int size = list.size();
            String first = list.get(0);
            for (int i = 1; i < size; i++)
                map.put(list.get(i), first);
        }
        Set<String> set = new HashSet<String>();
        String str1 = region1;
        while (str1 != null) {
            set.add(str1);
            str1 = map.get(str1);
        }
        String str2 = region2;
        while (!set.contains(str2))
            str2 = map.get(str2);
        return str2;
    }
}