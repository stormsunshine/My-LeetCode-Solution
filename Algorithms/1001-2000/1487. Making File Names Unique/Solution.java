class Solution {
    public String[] getFolderNames(String[] names) {
        if (names == null || names.length == 0)
            return names;
        int length = names.length;
        String[] actualNames = new String[length];
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < length; i++) {
            String name = names[i];
            if (!map.containsKey(name)) {
                actualNames[i] = name;
                map.put(name, 1);
            } else {
                int count = map.get(name);
                while (map.containsKey(name + "(" + count + ")"))
                    count++;
                String actualName = name + "(" + count + ")";
                actualNames[i] = actualName;
                map.put(name, count + 1);
                map.put(actualName, 1);
            }
        }
        return actualNames;
    }
}