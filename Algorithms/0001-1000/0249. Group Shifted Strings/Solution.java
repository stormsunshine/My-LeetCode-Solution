class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> groupMap = new HashMap<String, List<String>>();
        for (String string : strings) {
            int[] group = getGroup(string);
            String groupStr = Arrays.toString(group);
            List<String> groupList = groupMap.getOrDefault(groupStr, new ArrayList<String>());
            groupList.add(string);
            groupMap.put(groupStr, groupList);
        }
        List<List<String>> groupStrings = new ArrayList<List<String>>();
        Set<String> keySet = groupMap.keySet();
        int size = keySet.size();
        for (int i = 0; i < size; i++)
            groupStrings.add(new ArrayList<String>());
        int index = 0;
        for (String key : keySet) {
            List<String> groupList = groupMap.getOrDefault(key, new ArrayList<String>());
            for (String string : groupList)
                groupStrings.get(index).add(string);
            index++;
        }
        return groupStrings;
    }

    public int[] getGroup(String string) {
        int length = string.length() - 1;
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            int difference = string.charAt(i + 1) - string.charAt(i);
            if (difference < 0)
                difference += 26;
            array[i] = difference;
        }
        return array;
    }
}