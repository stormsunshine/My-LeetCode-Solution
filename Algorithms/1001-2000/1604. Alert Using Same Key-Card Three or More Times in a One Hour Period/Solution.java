class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        int length = keyName.length;
        for (int i = 0; i < length; i++) {
            String name = keyName[i];
            String time = keyTime[i];
            List<String> list = map.getOrDefault(name, new ArrayList<String>());
            list.add(time);
            map.put(name, list);
        }
        List<String> alertList = new ArrayList<String>();
        Set<String> keySet = map.keySet();
        for (String name : keySet) {
            List<String> list = map.get(name);
            Collections.sort(list);
            int size = list.size();
            for (int i = 2; i < size; i++) {
                String time1 = list.get(i - 2), time2 = list.get(i);
                int hour1 = Integer.parseInt(time1.substring(0, 2)), minute1 = Integer.parseInt(time1.substring(3));
                int hour2 = Integer.parseInt(time2.substring(0, 2)), minute2 = Integer.parseInt(time2.substring(3));
                int difference = (hour2 * 60 + minute2) - (hour1 * 60 + minute1);
                if (difference <= 60) {
                    alertList.add(name);
                    break;
                }
            }
        }
        Collections.sort(alertList);
        return alertList;
    }
}