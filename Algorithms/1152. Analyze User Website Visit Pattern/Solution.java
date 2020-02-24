class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int length = username.length;
        Struct[] array = new Struct[length];
        for (int i = 0; i < length; i++)
            array[i] = new Struct(username[i], timestamp[i], website[i]);
        Arrays.sort(array);
        Map<String, List<String>> userVisitsMap = new HashMap<String, List<String>>();
        for (int i = 0; i < length; i++) {
            Struct struct = array[i];
            String curUser = struct.username;
            String curWebsite = struct.website;
            List<String> list = userVisitsMap.getOrDefault(curUser, new ArrayList<String>());
            list.add(curWebsite);
            userVisitsMap.put(curUser, list);
        }
        int maxCount = 0;
        Map<String, Integer> countMap = new HashMap<String, Integer>();
        Map<String, List<String>> strListMap = new HashMap<String, List<String>>();
        Set<String> set = userVisitsMap.keySet();
        for (String user : set) {
            Set<String> sequenceSet = new HashSet<String>();
            List<String> list = userVisitsMap.getOrDefault(user, new ArrayList<String>());
            int size = list.size();
            if (size >= 3) {
                for (int i = 0; i < size - 2; i++) {
                    String website1 = list.get(i);
                    for (int j = i + 1; j < size - 1; j++) {
                        String website2 = list.get(j);
                        for (int k = j + 1; k < size; k++) {
                            String website3 = list.get(k);
                            List<String> sequence = new ArrayList<String>();
                            sequence.add(website1);
                            sequence.add(website2);
                            sequence.add(website3);
                            String sequenceStr = sequence.toString();
                            if (sequenceSet.add(sequenceStr)) {
                                int count = countMap.getOrDefault(sequenceStr, 0) + 1;
                                maxCount = Math.max(maxCount, count);
                                countMap.put(sequenceStr, count);
                                strListMap.put(sequenceStr, sequence);
                            }
                        }
                    }
                }
            }
        }
        List<List<String>> candidates = new ArrayList<List<String>>();
        Set<String> sequenceSet = countMap.keySet();
        for (String sequenceStr : sequenceSet) {
            int count = countMap.getOrDefault(sequenceStr, 0);
            if (count == maxCount)
                candidates.add(strListMap.get(sequenceStr));
        }
        Collections.sort(candidates, new Comparator<List<String>>() {
            public int compare(List<String> sequence1, List<String> sequence2) {
                return sequence1.toString().compareTo(sequence2.toString());
            }
        });
        return candidates.get(0);
    }
}

class Struct implements Comparable<Struct> {
    String username;
    int timestamp;
    String website;

    public Struct(String username, int timestamp, String website) {
        this.username = username;
        this.timestamp = timestamp;
        this.website = website;
    }

    public int compareTo(Struct struct2) {
        if (this.timestamp != struct2.timestamp)
            return this.timestamp - struct2.timestamp;
        else
            return this.username.compareTo(struct2.username);
    }
}