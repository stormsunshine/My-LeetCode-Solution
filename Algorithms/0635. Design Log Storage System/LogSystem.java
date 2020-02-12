class LogSystem {
    List<String> granularityList;
    TreeMap<String, Integer> treeMap;

    public LogSystem() {
        granularityList = new ArrayList<String>(Arrays.asList("Year", "Month", "Day", "Hour", "Minute", "Second"));
        treeMap = new TreeMap<String, Integer>();
    }
    
    public void put(int id, String timestamp) {
        treeMap.put(timestamp, id);
    }
    
    public List<Integer> retrieve(String s, String e, String gra) {
        List<Integer> retrieveList = new ArrayList<Integer>();
        int index = granularityList.indexOf(gra);
        String[] sArrayStr = s.split(":");
        String[] eArrayStr = e.split(":");
        int length = sArrayStr.length;
        int[] sArray = new int[length];
        int[] eArray = new int[length];
        for (int i = 0; i < length; i++) {
            sArray[i] = Integer.parseInt(sArrayStr[i]);
            eArray[i] = Integer.parseInt(eArrayStr[i]);
        }
        eArray[index]++;
        update(eArray);
        StringBuffer sSB = new StringBuffer();
        StringBuffer eSB = new StringBuffer();
        for (int i = 0; i <= index; i++) {
            if (i > 0) {
                sSB.append(':');
                eSB.append(':');
            }
            sSB.append(String.format("%02d", sArray[i]));
            eSB.append(String.format("%02d", eArray[i]));
        }
        String start = sSB.toString();
        String end = eSB.toString();
        Map<String, Integer> sortedMap = treeMap.tailMap(start);
        Set<String> keySet = sortedMap.keySet();
        for (String timestamp : keySet) {
            if (timestamp.compareTo(end) < 0)
                retrieveList.add(sortedMap.get(timestamp));
        }
        return retrieveList;
    }

    public void update(int[] eArray) {
        if (eArray[5] >= 60) {
            eArray[5] -= 60;
            eArray[4]++;
        }
        if (eArray[4] >= 60) {
            eArray[4] -= 60;
            eArray[3]++;
        }
        if (eArray[3] >= 24) {
            eArray[3] -= 24;
            eArray[2]++;
        }
        int month = eArray[1];
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            if (eArray[2] > 31) {
                eArray[2] -= 31;
                eArray[1]++;
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            if (eArray[2] > 30) {
                eArray[2] -= 30;
                eArray[1]++;
            }
        } else if (month == 2) {
            int year = eArray[0];
            boolean isLeap = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
            int maxDate = isLeap ? 29 : 28;
            if (eArray[1] > maxDate) {
                eArray[2] -= maxDate;
                eArray[1]++;
            }
        }
        if (eArray[1] > 12) {
            eArray[1] -= 12;
            eArray[0]++;
        }
    }
}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(s,e,gra);
 */